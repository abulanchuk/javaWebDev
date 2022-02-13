package com.example.finalproject.controller.command.impl.butler;

import com.example.finalproject.controller.QueryNamedArguments;
import com.example.finalproject.controller.SessionAttribute;
import com.example.finalproject.controller.command.Command;
import com.example.finalproject.controller.command.PagePath;
import com.example.finalproject.controller.command.Router;
import com.example.finalproject.exception.ServiceException;
import com.example.finalproject.model.entity.Order;
import com.example.finalproject.model.service.OrderService;
import com.example.finalproject.model.service.impl.OrderServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;

public class ShowOrdersWhereButlerWorkingCommand implements Command {
    private static final Logger logger = LogManager.getLogger(ShowOrdersWhereButlerWorkingCommand.class);
    OrderService orderService = new OrderServiceImpl();

    @Override
    public Router execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String id_user = session.getAttribute(SessionAttribute.USER_ID).toString();
        try {
            List<Order> orders = orderService.showOrdersByButler(Long.parseLong(id_user));
            request.setAttribute(QueryNamedArguments.BUTLER_ORDERS, orders);
            return new Router(PagePath.LIST_BUTLERS_ORDERS, Router.RouterType.FORWARD);
        } catch (ServiceException e) {
            logger.log(Level.ERROR, "Failed to execute ShowAllRoomsCommand:", e);
            return new Router(PagePath.ERROR_500_PAGE, Router.RouterType.FORWARD);
        }
    }
}
