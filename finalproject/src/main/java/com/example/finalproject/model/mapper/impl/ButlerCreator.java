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
        butler.setIdButler(resultSet.getLong(BUTLERS_ID_BUTLER));
        butler.setIdUser(resultSet.getLong(BUTLERS_ID_USER));
        butler.setRating(resultSet.getByte(BUTLERS_RATING));
        return butler;
    }
}
