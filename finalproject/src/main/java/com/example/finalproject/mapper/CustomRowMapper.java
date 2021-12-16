package com.example.finalproject.mapper;


import com.example.finalproject.exception.DaoException;

import java.sql.ResultSet;
import java.util.List;


@FunctionalInterface
public interface CustomRowMapper<T> {
    List<T> mapRow(ResultSet resultSet) throws DaoException;
}

