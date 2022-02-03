package com.example.finalproject.controller.command.impl.client;

import com.example.finalproject.controller.QueryNamedArguments;
import com.example.finalproject.controller.command.Command;
import com.example.finalproject.controller.command.Router;
import com.example.finalproject.exception.ServiceException;
import com.example.finalproject.model.service.OrderService;
import com.example.finalproject.model.service.impl.OrderServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;

public class CreateOrderCommand implements Command {
    OrderService orderService = new OrderServiceImpl();
    @Override
    public Router execute(HttpServletRequest request) {
        Map<String, String> newOder = new HashMap<>();
        newOder.put(QueryNamedArguments.START_DATE, request.getParameter(QueryNamedArguments.START_DATE));
        newOder.put(QueryNamedArguments.FINISH_DATE, request.getParameter(QueryNamedArguments.FINISH_DATE));
        try {
            orderService.insertNewEntity(newOder);
        } catch (ServiceException e) {
            e.printStackTrace();//todo
        }
        return null;
    }
}
