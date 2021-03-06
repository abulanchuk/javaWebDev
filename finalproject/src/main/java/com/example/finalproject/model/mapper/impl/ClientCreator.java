package com.example.finalproject.model.mapper.impl;

import com.example.finalproject.model.entity.Client;
import com.example.finalproject.model.entity.User;
import com.example.finalproject.model.mapper.RowCreator;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.example.finalproject.model.mapper.ColumnTableName.*;

public class ClientCreator implements RowCreator {
    UserCreator userCreator = new UserCreator();

    @Override
    public Client create(ResultSet resultSet) throws SQLException {
        User user = userCreator.create(resultSet);

        Client client = new Client(user);
        client.setIdClient(resultSet.getLong(CLIENTS_ID_CLIENT));
        client.setPasswordNumber(resultSet.getString(CLIENTS_PASSWORD_NUMBER));
        client.setEmail(resultSet.getString(CLIENTS_EMAIL));
        client.setBankAccount(resultSet.getBigDecimal(CLIENTS_BANK_ACCOUNT));
        return client;
    }
}
