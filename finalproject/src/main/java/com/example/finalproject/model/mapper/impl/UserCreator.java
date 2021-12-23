package com.example.finalproject.model.mapper.impl;


import com.example.finalproject.model.entity.User;
import com.example.finalproject.model.entity.UserRole;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.example.finalproject.model.mapper.ColumnTableName.*;


public class UserCreator {
    public UserCreator(User user) {
    }
    static User create(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setIdUser(resultSet.getLong(ID_USER));
        user.setLogin(resultSet.getString(LOGIN));
        user.setLogin(resultSet.getString(PASSWORD));
        user.setRole(UserRole.valueOf(resultSet.getString(ROLE).trim().toUpperCase()));
        user.setLogin(resultSet.getString(NAME));
        user.setLogin(resultSet.getString(SURNAME));
        user.setLogin(resultSet.getString(PHONE_NUMBER));
        return user;
    }
}
