package com.example.finalproject.model.mapper.impl;

import com.example.finalproject.model.entity.Butler;
import com.example.finalproject.model.entity.User;
import com.example.finalproject.model.mapper.RowCreator;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.example.finalproject.model.mapper.ColumnTableName.*;

public class ButlerCreator implements RowCreator {
    UserCreator userCreator = new UserCreator();

    @Override
    public Butler create(ResultSet resultSet) throws SQLException{
        User user = userCreator.create(resultSet);

        Butler butler = new Butler(user);
        butler.setIdButler(resultSet.getLong(BUTLERS_ID_BUTLER));
        butler.setRating(resultSet.getByte(BUTLERS_RATING));
        return butler;
    }
}
