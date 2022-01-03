package com.example.finalproject.model.mapper.impl;

import com.example.finalproject.model.entity.Discount;
import com.example.finalproject.model.mapper.RowCreator;

import java.sql.ResultSet;
import java.sql.SQLException;
import static com.example.finalproject.model.mapper.ColumnTableName.*;


public class DiscountCreator implements RowCreator {
    public DiscountCreator() {
    }

    @Override
    public Discount create(ResultSet resultSet) throws SQLException {
        Discount discount = new Discount();
        discount.setIdDiscount(resultSet.getInt(DISCOUNTS_ID_DISCOUNT));
        discount.setPercent(resultSet.getByte(DISCOUNTS_PERCENT));
        return discount;
    }
}
