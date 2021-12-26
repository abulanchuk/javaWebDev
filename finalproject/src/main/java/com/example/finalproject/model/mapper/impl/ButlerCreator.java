package com.example.finalproject.model.mapper.impl;

import com.example.finalproject.model.entity.Butler;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.example.finalproject.model.mapper.ColumnTableName.*;

public class ButlerCreator {
    public ButlerCreator() {
    }
    public static Butler create(ResultSet resultSet) throws SQLException{
        Butler butler = new Butler();
        butler.setIdButler(resultSet.getLong(ID_BUTLER));
        butler.setRating(resultSet.getByte(RATING));
        return butler;
    }
}
