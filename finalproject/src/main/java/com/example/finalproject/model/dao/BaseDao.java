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

/**
 * The interface Base dao.
 *
 * @param <T> the type parameter
 */
public interface BaseDao<T extends CustomEntity> {
    /**
     * The constant logger.
     */
    static Logger logger = LogManager.getLogger(BaseDao.class);

    /**
     * Find all list.
     *
     * @return the list of entities
     * @throws DaoException the dao exception
     */
    List<T> findAll() throws DaoException;

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional after finding by id
     * @throws DaoException the dao exception
     */
    Optional<T> findById(Long id) throws DaoException;

    /**
     * Delete by id boolean.
     *
     * @param id the id
     * @return the successful result or not (boolean)
     * @throws DaoException the dao exception
     */
    boolean deleteById(Long id) throws DaoException;

    /**
     * Insert new entity t.
     *
     * @param entity the entity
     * @return created entity
     * @throws DaoException the dao exception
     */
    T insertNewEntity(CustomEntity entity) throws DaoException;

    /**
     * Close.
     *
     * @param connection the connection
     * @throws DaoException the dao exception
     */
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

    /**
     * Close.
     *
     * @param statement the statement
     * @throws DaoException the dao exception
     */
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
