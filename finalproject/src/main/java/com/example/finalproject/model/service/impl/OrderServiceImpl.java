package com.example.finalproject.model.service.impl;

import com.example.finalproject.exception.ServiceException;
import com.example.finalproject.model.entity.Order;
import com.example.finalproject.model.service.OrderService;

import java.util.Map;

public class OrderServiceImpl implements OrderService {
    @Override
    public Order insertNewEntity(Map<String, String> order) throws ServiceException {
        Order newOrder = null;

        return newOrder;
    }
}
