package com.example.finalproject.model.service;

import com.example.finalproject.exception.ServiceException;
import com.example.finalproject.model.entity.Order;

import java.util.List;
import java.util.Map;

public interface OrderService {
    Order insertNewEntity(Map<String, String> order) throws ServiceException;
    Long findIdButlerWithMinNumbersOfOrders() throws ServiceException;
    List<Order> showActiveOrders(boolean isActive) throws ServiceException;
    List<Order> showOrdersByButler (Long id_butler) throws ServiceException;
}
