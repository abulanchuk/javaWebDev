package com.example.finalproject.controller.command.impl.client;

import com.example.finalproject.controller.QueryNamedArguments;
import com.example.finalproject.controller.command.Command;
import com.example.finalproject.controller.command.PagePath;
import com.example.finalproject.controller.command.Router;
import com.example.finalproject.exception.ServiceException;
import com.example.finalproject.model.service.OrderService;
import com.example.finalproject.model.service.impl.OrderServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CreateOrderCommand implements Command {
    private static final Logger logger = LogManager.getLogger(CreateOrderCommand.class);
    OrderService orderService = new OrderServiceImpl();
    @Override
    public Router execute(HttpServletRequest request) {
        Map<String, String> newOder = new HashMap<>();
        newOder.put(QueryNamedArguments.START_DATE, request.getParameter(QueryNamedArguments.START_DATE));
        newOder.put(QueryNamedArguments.FINISH_DATE, request.getParameter(QueryNamedArguments.FINISH_DATE));
        try {
            orderService.insertNewEntity(newOder);
        } catch (ServiceException e) {
            logger.log(Level.ERROR, "Failed to insert new order:", e);
            return new Router(PagePath.ERROR_500_PAGE, Router.RouterType.FORWARD);
        }
        return null;
    }
}
