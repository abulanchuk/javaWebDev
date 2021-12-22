package com.example.finalproject.testMain;

import com.example.finalproject.model.pool.ConnectionPool;

import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        ConnectionPool connectionPool = new ConnectionPool();
        connectionPool.getConnection();
        try {
            Statement statement = connectionPool.getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
