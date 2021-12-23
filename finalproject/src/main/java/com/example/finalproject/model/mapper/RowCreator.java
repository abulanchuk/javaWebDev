package com.example.finalproject.model.mapper;

import com.example.finalproject.model.entity.CustomEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowCreator {
    CustomEntity create(ResultSet resultSet) throws SQLException;
}
