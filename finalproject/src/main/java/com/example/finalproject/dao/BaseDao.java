package com.example.finalproject.dao;

import com.example.finalproject.entity.CustomEntity;
import com.example.finalproject.exception.DaoException;
import com.example.finalproject.pool.ConnectionPool;
import org.apache.log4j.Level;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface BaseDao<T extends CustomEntity>{
    static Logger logger = LogManager.getLogger(BaseDao.class);

    List<T> findAll() throws DaoException;
    T findById(T id) throws DaoException;
    boolean deleteById(T user) throws DaoException;
    T update(T t) throws DaoException;

    default void close (Connection connection) throws DaoException {
        try{
            if(connection!=null){
                connection.close();
            }
        } catch (SQLException e){
            StringWriter stacktraceWriter = new StringWriter();
            e.printStackTrace(new PrintWriter(stacktraceWriter));
            logger.log(Level.ERROR, "Some problems with closing connection " + stacktraceWriter.toString());
            throw new DaoException("Some problems with closing connection");
        }
    }
    default void close (Statement statement)throws DaoException{
        try{
            if(statement!=null){
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
