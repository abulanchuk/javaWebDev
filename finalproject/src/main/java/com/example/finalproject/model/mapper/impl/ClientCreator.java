package com.example.finalproject.model.mapper.impl;

import com.example.finalproject.model.entity.Client;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.example.finalproject.model.mapper.ColumnTableName.*;

public class ClientCreator {
    public ClientCreator() {
    }
    static Client create(ResultSet resultSet) throws SQLException{
        Client client = new Client();
        client.setIdClient(resultSet.getLong(ID_CLIENT));
        client.setPasswordNumber(resultSet.getString(PASSWORD_NUMBER));
        client.setEmail(resultSet.getString(EMAIL));
        client.setBankAccount(resultSet.getBigDecimal(BANK_ACCOUNT));
        return client;
    }
}
