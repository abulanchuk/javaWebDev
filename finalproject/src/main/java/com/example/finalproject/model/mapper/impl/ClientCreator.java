package com.example.finalproject.model.mapper.impl;

import com.example.finalproject.model.entity.Client;
import com.example.finalproject.model.entity.CustomEntity;
import com.example.finalproject.model.mapper.RowCreator;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.example.finalproject.model.mapper.ColumnTableName.*;

public class ClientCreator implements RowCreator {
    public ClientCreator() {
    }

    @Override
   public Client create(ResultSet resultSet) throws SQLException{
        Client client = new Client();
        client.setIdClient(resultSet.getLong(CLIENTS_ID_CLIENT));
        client.setPasswordNumber(resultSet.getString(CLIENTS_PASSWORD_NUMBER));
        client.setEmail(resultSet.getString(CLIENTS_EMAIL));
        client.setBankAccount(resultSet.getBigDecimal(CLIENTS_BANK_ACCOUNT));
        client.setIdUser(resultSet.getLong(CLIENTS_ID_USER));
        return client;
    }
}
