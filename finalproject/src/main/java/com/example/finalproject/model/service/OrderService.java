package com.example.finalproject.model.service;

import com.example.finalproject.exception.ServiceException;
import com.example.finalproject.model.entity.Order;

import java.util.Map;

public interface OrderService {
    Order insertNewEntity(Map<String, String> order) throws ServiceException;
}
