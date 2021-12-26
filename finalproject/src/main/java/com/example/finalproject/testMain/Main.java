package com.example.finalproject.testMain;

import com.example.finalproject.exception.DaoException;
import com.example.finalproject.model.dao.impl.ButlerDaoImpl;
import com.example.finalproject.model.entity.Butler;
import com.example.finalproject.model.pool.ConnectionPool;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ConnectionPool connectionPool = new ConnectionPool();
        connectionPool.getConnection();
        try {
            Statement statement = connectionPool.getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ButlerDaoImpl butlerDao = new ButlerDaoImpl();
        List<Butler> butlers = new ArrayList<>();
        try {
            butlers = butlerDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        System.out.println(butlers);
        System.out.println();
        try {
            System.out.println(butlerDao.findById(1L));
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}
