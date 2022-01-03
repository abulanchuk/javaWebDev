package com.example.finalproject.model.mapper.impl;

import com.example.finalproject.model.entity.Butler;
import com.example.finalproject.model.mapper.RowCreator;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.example.finalproject.model.mapper.ColumnTableName.*;

public class ButlerCreator implements RowCreator {
    public ButlerCreator() {
    }

    @Override
    public Butler create(ResultSet resultSet) throws SQLException{
        Butler butler = new Butler();
        butler.setIdButler(resultSet.getLong(BUTLERS_ID_BUTLER));
        butler.setIdUser(resultSet.getLong(BUTLERS_ID_USER));
        butler.setRating(resultSet.getByte(BUTLERS_RATING));
        return butler;
    }
}
