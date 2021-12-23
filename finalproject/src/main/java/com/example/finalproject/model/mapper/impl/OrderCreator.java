package com.example.finalproject.model.mapper.impl;

import com.example.finalproject.model.entity.Order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.example.finalproject.model.mapper.ColumnTableName.*;

public class OrderCreator {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public OrderCreator() {
    }
    static Order create (ResultSet resultSet) throws SQLException{
        Order order = new Order();
        order.setIdOrder(resultSet.getLong(ID_ORDER));
        order.setStartDate(LocalDate.parse(resultSet.getString(START_DATE), FORMATTER));
        order.setFinishDate(LocalDate.parse(resultSet.getString(FINISH_DATE), FORMATTER));
        order.setPaid(resultSet.getBoolean(ID_PAID));
        order.setActive(resultSet.getBoolean(IS_ACTIVE));
        return order;
    }
}
