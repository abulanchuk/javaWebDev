package com.example.finalproject.controller.command.impl.owner;

import com.example.finalproject.controller.QueryNamedArguments;
import com.example.finalproject.controller.command.Command;
import com.example.finalproject.controller.command.PagePath;
import com.example.finalproject.controller.command.Router;
import com.example.finalproject.exception.ServiceException;
import com.example.finalproject.model.entity.Order;

import com.example.finalproject.model.service.OrderService;
import com.example.finalproject.model.service.impl.OrderServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;

public class ShowAllActiveOrdersOrNotCommand implements Command {
    private static final Logger logger = LogManager.getLogger(ShowAllActiveOrdersOrNotCommand.class);
    OrderService orderService = new OrderServiceImpl();
    @Override
    public Router execute(HttpServletRequest request) {
        try {
            List<Order> allOrders = orderService.showActiveOrders(Boolean.parseBoolean(request.getParameter(QueryNamedArguments.IS_ACTIVE_ORDER)));
        request.setAttribute(QueryNamedArguments.ORDERS, allOrders);
        } catch (ServiceException e) {
            logger.log(Level.ERROR, "Failed to execute ShowAllActiveOrdersCommand:", e);
            return new Router(PagePath.ERROR_500_PAGE, Router.RouterType.FORWARD);
        }
        return null;
    }
}
