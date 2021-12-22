package com.example.finalproject.model.pool;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;


import com.example.finalproject.exception.InvalidConnectionTypeException;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ConnectionPool {
    private static Logger logger = LogManager.getLogger(ConnectionPool.class);

    private BlockingQueue<ProxyConnection> freeConnections;
    private BlockingQueue<ProxyConnection> givenConnections;

    private static AtomicBoolean create = new AtomicBoolean(false);
    private static ReentrantLock lockForSingleton = new ReentrantLock();
    private static ConnectionPool instance;

    private static final ResourceBundle bundle;
    private static final int POOL_SIZE;
    private static final String DRIVER;
    private static final String URL;
    private static final String USER_NAME;
    private static final String PASSWORD;

    static {
        bundle = ResourceBundle.getBundle("database");
        DRIVER = bundle.getString("db.driver");
        POOL_SIZE = Integer.parseInt(bundle.getString("poolsize"));
        URL = bundle.getString("database.url");
        USER_NAME = bundle.getString("user");
        PASSWORD = bundle.getString("password");
    }

    public ConnectionPool() {
        freeConnections = new LinkedBlockingDeque<>(POOL_SIZE);
        givenConnections = new LinkedBlockingDeque<>(POOL_SIZE);
        try {
            Class.forName(DRIVER);
            for (int i = 0; i < POOL_SIZE; i++) {
                ProxyConnection connection =
                        new ProxyConnection(DriverManager.getConnection(URL, USER_NAME, PASSWORD));
                freeConnections.offer(connection);
            }
        } catch (ClassNotFoundException | SQLException e) {
            logger.log(Level.FATAL, "Problems with initializing connection pool", e);
            throw new ExceptionInInitializerError("Problems with initializing connection pool");
        }
    }

    public static ConnectionPool getInstance() {
        if (!create.get()) {
            try {
                lockForSingleton.lock();
                if (instance == null) {
                    instance = new ConnectionPool();
                    create.set(true);
                }
            } finally {
                lockForSingleton.unlock();
            }
        }
        return instance;
    }

    public Connection getConnection() {
        ProxyConnection connection = null;
        try {
            connection = freeConnections.take();
            givenConnections.offer(connection);
        } catch (InterruptedException e) {
            logger.log(Level.ERROR, "There is no way to get a connection" + e.getMessage());
        }
        return connection;
    }

    public void releaseConnection(Connection connection) {
        try {
            if (!(connection instanceof ProxyConnection)) {
                logger.log(Level.ERROR, connection + " not ProxyConnection");
                throw new InvalidConnectionTypeException(connection + " not ProxyConnection");
            }
            givenConnections.remove(connection);
            freeConnections.offer((ProxyConnection) connection);
        } catch (InvalidConnectionTypeException e) {
            logger.log(Level.ERROR, e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    public void destroyPool() {
        for (int i = 0; i < POOL_SIZE; i++) {
            try {
                ProxyConnection connection = freeConnections.take();
                connection.reallyClose();
            } catch (InterruptedException e) {
                logger.log(Level.ERROR, "Some problems with pool destroying" + e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
        logger.log(Level.INFO, "Connection pool was destroyed");
        deregisterDrivers();
    }

    private void deregisterDrivers() {
        DriverManager.getDrivers().asIterator().forEachRemaining(driver -> {
            try {
                DriverManager.deregisterDriver(driver);
            } catch (SQLException e) {
                logger.log(Level.ERROR, "Some problems with deregister drivers in pool" + e.getMessage());
            }
            logger.log(Level.INFO, "Connection pool was destroyed");
        });
    }
}
