package com.example.finalproject.model.mapper.impl;

import com.example.finalproject.model.entity.Client;
import com.example.finalproject.model.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.example.finalproject.model.mapper.ColumnTableName.*;

public class ClientCreator {
    public ClientCreator() {
    }
   public static Client create(ResultSet resultSet) throws SQLException{
        Client client = new Client();
        User user = new User();
        client.setIdClient(resultSet.getLong(CLIENTS_ID_CLIENT));
        client.setPasswordNumber(resultSet.getString(CLIENTS_PASSWORD_NUMBER));
        client.setEmail(resultSet.getString(CLIENTS_EMAIL));
        client.setBankAccount(resultSet.getBigDecimal(CLIENTS_BANK_ACCOUNT));
        client.setIdUser(resultSet.getLong(CLIENTS_ID_USER));
       //todo how to add fields from user
        return client;
    }
}