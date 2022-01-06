package com.example.finalproject.model.mapper.impl;


import com.example.finalproject.model.entity.User;
import com.example.finalproject.model.entity.UserRole;
import com.example.finalproject.model.mapper.RowCreator;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.example.finalproject.model.mapper.ColumnTableName.*;


public class UserCreator implements RowCreator {
    public UserCreator() {
    }

    @Override
    public User create(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setIdUser(resultSet.getLong(USERS_ID_USER));
        user.setLogin(resultSet.getString(USERS_LOGIN));
        user.setPassword(resultSet.getString(USERS_PASSWORD));
        user.setRole(UserRole.valueOf(resultSet.getString(USERS_ROLE).trim().toUpperCase()));
        user.setName(resultSet.getString(USERS_NAME));
        user.setSurname(resultSet.getString(USERS_SURNAME));
        user.setPhoneNumber(resultSet.getString(USERS_PHONE_NUMBER));
        return user;
    }
}
