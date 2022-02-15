package com.example.finalproject.model.mapper;

import com.example.finalproject.model.entity.CustomEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The interface Row creator.
 */
public interface RowCreator {
     /**
      * Create custom entity.
      *
      * @param resultSet the result set
      * @return the custom entity
      * @throws SQLException the sql exception
      */
     CustomEntity create(ResultSet resultSet) throws SQLException;
}
