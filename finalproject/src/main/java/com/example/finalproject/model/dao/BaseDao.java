package com.example.finalproject.model.dao;

import com.example.finalproject.model.entity.CustomEntity;
import com.example.finalproject.exception.DaoException;
import org.apache.log4j.Level;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

public interface BaseDao<T extends CustomEntity> {
    static Logger logger = LogManager.getLogger(BaseDao.class);

    List<T> findAll() throws DaoException;

    Optional<T> findById(T id) throws DaoException;

    boolean deleteById(T entity) throws DaoException;

    long insertNewEntity(T entity) throws DaoException;

    default void close(Connection connection) throws DaoException {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            StringWriter stacktraceWriter = new StringWriter();
            e.printStackTrace(new PrintWriter(stacktraceWriter));
            logger.log(Level.ERROR, "Some problems with closing connection " + stacktraceWriter.toString());
            throw new DaoException("Some problems with closing connection");
        }
    }

    default void close(Statement statement) throws DaoException {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            StringWriter stacktraceWriter = new StringWriter();
            e.printStackTrace(new PrintWriter(stacktraceWriter));
            logger.log(Level.ERROR, "Some problems with closing statement " + stacktraceWriter.toString());
            throw new DaoException("Some problems with closing statement");
        }
    }
}
