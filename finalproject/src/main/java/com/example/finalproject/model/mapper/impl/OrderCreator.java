package com.example.finalproject.model.mapper.impl;

import com.example.finalproject.model.entity.Order;
import com.example.finalproject.model.mapper.RowCreator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.example.finalproject.model.mapper.ColumnTableName.*;

public class OrderCreator implements RowCreator {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public OrderCreator() {
    }

    @Override
    public Order create (ResultSet resultSet) throws SQLException{
        Order order = new Order();
        order.setIdOrder(resultSet.getLong(ORDERS_ID_ORDER));
        String startDateAsString = resultSet.getString(ORDERS_START_DATE);

        order.setStartDate(LocalDate.parse(startDateAsString, FORMATTER));
        order.setFinishDate(LocalDate.parse(resultSet.getString(ORDERS_FINISH_DATE), FORMATTER));
        order.setPaid(resultSet.getBoolean(ORDERS_IS_PAID));
        order.setActive(resultSet.getBoolean(ORDERS_IS_ACTIVE));
        return order;
    }
}
