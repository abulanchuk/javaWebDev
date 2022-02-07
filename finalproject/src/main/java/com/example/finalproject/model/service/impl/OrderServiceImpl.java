package com.example.finalproject.model.service.impl;

import com.example.finalproject.controller.QueryNamedArguments;
import com.example.finalproject.controller.SessionAttribute;
import com.example.finalproject.exception.DaoException;
import com.example.finalproject.exception.ServiceException;
import com.example.finalproject.model.dao.ClientDao;
import com.example.finalproject.model.dao.OrderDao;
import com.example.finalproject.model.dao.impl.ClientDaoImpl;
import com.example.finalproject.model.dao.impl.OrderDaoImpl;
import com.example.finalproject.model.entity.Butler;
import com.example.finalproject.model.entity.Client;
import com.example.finalproject.model.entity.Order;
import com.example.finalproject.model.service.OrderService;
import com.example.finalproject.validator.Validator;
import com.example.finalproject.validator.impl.ValidatorImpl;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

public class OrderServiceImpl implements OrderService {
    private static final Logger logger = LogManager.getLogger(OrderServiceImpl.class);
    Validator validator = new ValidatorImpl();
    OrderDao orderDao = new OrderDaoImpl();

    @Override
    public Order insertNewEntity(Map<String, String> order) throws ServiceException {
        Order newOrder = null;
        if (!validator.checkDatesFromOrders(order)) {
            logger.log(Level.ERROR, "Impossible to insert new order because dates have invalid type");
            throw new ServiceException("Impossible to insert new order because dates have invalid type");
        }
        if (Integer.parseInt(order.get(SessionAttribute.BANK_ACCOUNT)) < Integer.parseInt(order.get(QueryNamedArguments.TOTAL))) {
            logger.log(Level.ERROR, "Impossible to insert new order because room costs more than you have in bank account");
            throw new ServiceException("Impossible to insert new order because room costs more than you have in bank account");
        }
        long idButler = findIdButlerWithMinNumbersOfOrders();
        LocalDate startDate = LocalDate.parse(order.get(QueryNamedArguments.START_DATE));
        LocalDate finishDate = LocalDate.parse(order.get(QueryNamedArguments.LEAVE_DATE));
        long idUser = Long.parseLong(order.get(SessionAttribute.USER_ID));
        BigDecimal totalPrice = new BigDecimal(order.get(QueryNamedArguments.TOTAL));
        ClientDao clientDao = new ClientDaoImpl();
        Order orderToDao;
        long idClient;
        try {
            Optional<Client> clientFoundedByIdUser = clientDao.findByIdUser(idUser);
            idClient = clientFoundedByIdUser.get().getIdClient();
        } catch (DaoException e) {
            logger.log(Level.ERROR, "Failed to find id client by is user ", e);
            throw new ServiceException("Failed to find id client by is user ", e);
        }
        orderToDao = new Order(idButler, startDate, finishDate, true, true, idClient, totalPrice);
        try {
            orderDao.insertNewEntity(orderToDao);
        } catch (DaoException e) {
            logger.log(Level.ERROR, "Failed to insert new order ", e);
            throw new ServiceException("Failed to insert new order ", e);
        }
        return newOrder;
    }

    @Override
    public Long findIdButlerWithMinNumbersOfOrders() throws ServiceException {
        Long idButler;
        try {
            idButler = orderDao.findIdButlerWithMinNumbersOfOrders();
        } catch (DaoException e) {
            logger.log(Level.ERROR, "Failed to find butler's id with min numbers of orders ", e);
            throw new ServiceException("Failed to find butler's id with min numbers of orders ", e);
        }
        return idButler;
    }
}
