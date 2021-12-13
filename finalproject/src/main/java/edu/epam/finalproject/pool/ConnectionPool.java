package edu.epam.finalproject.pool;


import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import edu.epam.finalproject.exception.InvalidConnectionTypeException;
import edu.epam.finalproject.factory.ConnectionFactory;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public enum ConnectionPool {
    INSTANCE;
    private static Logger logger = LogManager.getLogger(ConnectionPool.class);
    private static final Properties properties = new Properties();
    private static final int POOL_SIZE;

    private static BlockingQueue<ProxyConnection> freeConnections;
    private static BlockingQueue<ProxyConnection> givenConnections;

    static {
        try {
            String fileName = "data/database.properties";
            ClassLoader loader = ConnectionFactory.class.getClassLoader();
            URL resource = loader.getResource(fileName);
            if (resource != null) {
                fileName = resource.getFile();
            } else {
                logger.log(Level.ERROR, "Resource is null! " + fileName);
                throw new IllegalArgumentException("Resource is null!");
            }
            properties.load(new FileReader(fileName));
        } catch (IOException e) {
            logger.log(Level.ERROR, "File properties exception: " + e.getMessage());
            throw new RuntimeException("File properties exception." + e.getMessage());
        }
        POOL_SIZE = Integer.parseInt((String) properties.get("poolsize"));
        freeConnections = new LinkedBlockingDeque<>(POOL_SIZE);
        givenConnections = new LinkedBlockingDeque<>();
    }

    public Connection getConnection() {
        ProxyConnection connection = null;
        try {
            connection = freeConnections.take();
            givenConnections.offer(connection);
        } catch (InterruptedException e) {
            StringWriter stacktraceWriter = new StringWriter();
            e.printStackTrace(new PrintWriter(stacktraceWriter));
            logger.log(Level.ERROR, "There is no way to get a connection" + stacktraceWriter.toString());
        }
        return connection;
    }

    public void releaseConnection(Connection connection) throws InvalidConnectionTypeException {
        if (!(connection instanceof ProxyConnection)) {
            logger.log(Level.ERROR, connection + " not ProxyConnection");
            throw new InvalidConnectionTypeException(connection + " not ProxyConnection");
        }
        givenConnections.remove(connection);
        freeConnections.offer((ProxyConnection) connection);
    }

    public void destroyPool() {
        for (int i = 0; i < POOL_SIZE; i++) {
            try {
                ProxyConnection connection = freeConnections.take();
                connection.reallyClose();
            } catch (InterruptedException e) {
                StringWriter stacktraceWriter = new StringWriter();
                e.printStackTrace(new PrintWriter(stacktraceWriter));
                logger.log(Level.ERROR, "Some problems with pool destroying" + stacktraceWriter.toString());
            }
        }
        deregisterDrivers();
    }

    private void deregisterDrivers() {
        DriverManager.getDrivers().asIterator().forEachRemaining(driver -> {
            try {
                DriverManager.deregisterDriver(driver);
            } catch (SQLException e) {
                StringWriter stacktraceWriter = new StringWriter();
                e.printStackTrace(new PrintWriter(stacktraceWriter));
                logger.log(Level.ERROR, "Some problems with deregister drivers in pool" + stacktraceWriter.toString());
            }
        });
    }
}
