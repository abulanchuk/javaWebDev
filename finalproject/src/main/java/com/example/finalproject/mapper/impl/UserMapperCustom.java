package com.example.finalproject.mapper.impl;

import com.example.finalproject.entity.User;
import com.example.finalproject.exception.DaoException;
import com.example.finalproject.mapper.CustomRowMapper;

import java.sql.ResultSet;
import java.util.List;

public class UserMapperCustom implements CustomRowMapper {
    @Override
    public List<User> mapRow(ResultSet resultSet) throws DaoException {
        User user = new User();
try {
//todo

} catch (Exception e) {
    e.printStackTrace();
}
        return null;
    }
}
