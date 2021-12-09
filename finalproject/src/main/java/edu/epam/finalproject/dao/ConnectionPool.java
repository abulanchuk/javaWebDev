package edu.epam.finalproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import edu.epam.finalproject.exception.InvalidConnectionTypeException;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public enum ConnectionPool {
    INSTANCE;
    private static Logger logger = LogManager.getLogger(ConnectionPool.class);
    private BlockingQueue<ProxyConnection> freeConnections;
    private Queue<ProxyConnection> givenConnections;

    private final static int DEFAULT_POOL_SIZE = 32;


    ConnectionPool() {
        freeConnections = new LinkedBlockingDeque<>(DEFAULT_POOL_SIZE);
        givenConnections = new ArrayDeque<>();
    }

    public Connection getConnection() {
        ProxyConnection connection = null;
        try {
            connection = freeConnections.take();
            givenConnections.offer(connection);
        } catch (InterruptedException e) {
            logger.log(Level.ERROR, "There is no way to get a connection" + e);
            e.printStackTrace();
        }
        return connection;
    }

    public void releaseConnection(Connection connection) {
        if (!(connection instanceof ProxyConnection)) {
            try {
                throw new InvalidConnectionTypeException(connection + " not ProxyConnection");
            } catch (InvalidConnectionTypeException e) {
                logger.log(Level.ERROR, connection + " not ProxyConnection" + e);
                e.printStackTrace();
            }
        }

        givenConnections.remove(connection);
        freeConnections.offer((ProxyConnection) connection);
    }

    public void destroyPool() {
        for (int i = 0; i < DEFAULT_POOL_SIZE; i++) {
            try {
                ProxyConnection connection = freeConnections.take();
                connection.reallyClose();
            } catch (InterruptedException e) {
                logger.log(Level.ERROR, "Some problems with pool destroying" + e);
                e.printStackTrace();
            }
        }
        deregisterDrivers();
    }

    private void deregisterDrivers() {
        DriverManager.getDrivers().asIterator().forEachRemaining(driver -> {
            try {
                DriverManager.deregisterDriver(driver);
            } catch (SQLException e) {
                logger.log(Level.ERROR, "Some problems with deregister drivers in pool" + e);
                e.printStackTrace();
            }
        });
    }
}
