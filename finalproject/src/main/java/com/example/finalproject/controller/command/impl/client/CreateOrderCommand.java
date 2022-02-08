package com.example.finalproject.controller.command.impl.client;

import com.example.finalproject.controller.QueryNamedArguments;
import com.example.finalproject.controller.SessionAttribute;
import com.example.finalproject.controller.command.Command;
import com.example.finalproject.controller.command.PagePath;
import com.example.finalproject.controller.command.Router;
import com.example.finalproject.exception.ServiceException;
import com.example.finalproject.model.entity.Client;
import com.example.finalproject.model.service.ClientService;
import com.example.finalproject.model.service.OrderService;
import com.example.finalproject.model.service.impl.ClientServiceImpl;
import com.example.finalproject.model.service.impl.OrderServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CreateOrderCommand implements Command {
    private static final Logger logger = LogManager.getLogger(CreateOrderCommand.class);
    OrderService orderService = new OrderServiceImpl();
    ClientService clientService = new ClientServiceImpl();

    @Override
    public Router execute(HttpServletRequest request) {
        Map<String, String> newOrder = new HashMap<>();
        HttpSession session = request.getSession();
        newOrder.put(QueryNamedArguments.START_DATE, request.getParameter(QueryNamedArguments.START_DATE));
        newOrder.put(QueryNamedArguments.LEAVE_DATE, request.getParameter(QueryNamedArguments.LEAVE_DATE));
        newOrder.put(QueryNamedArguments.TOTAL, request.getParameter(QueryNamedArguments.TOTAL));
        newOrder.put(SessionAttribute.BANK_ACCOUNT, session.getAttribute(SessionAttribute.BANK_ACCOUNT).toString());
        newOrder.put(SessionAttribute.USER_ID, session.getAttribute(SessionAttribute.USER_ID).toString());
        try {
            orderService.insertNewEntity(newOrder);
        } catch (ServiceException e) {
            logger.log(Level.ERROR, "Failed to insert new order:", e);
            return new Router(PagePath.ERROR_500_PAGE, Router.RouterType.FORWARD);
        }
        try {
            clientService.withdrawalCashFromBankAccount((Long) session.getAttribute(SessionAttribute.USER_ID), request.getParameter(QueryNamedArguments.TOTAL));
        } catch (ServiceException e) {
            logger.log(Level.ERROR, "Failed to withdrawal cash from BankAccount:", e);
            return new Router(PagePath.ERROR_500_PAGE, Router.RouterType.FORWARD);
        }
        Client client = new Client();
        session.setAttribute(SessionAttribute.BANK_ACCOUNT, client.getBankAccount());
        return new Router(PagePath.HOME, Router.RouterType.FORWARD);
    }
}
