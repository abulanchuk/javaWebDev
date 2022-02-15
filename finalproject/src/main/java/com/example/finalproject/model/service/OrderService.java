package com.example.finalproject.model.service;

import com.example.finalproject.exception.ServiceException;
import com.example.finalproject.model.entity.Order;

import java.util.List;
import java.util.Map;

/**
 * The interface Order service.
 */
public interface OrderService {
    /**
     * Insert new entity order.
     *
     * @param order the params for order
     * @return the order
     * @throws ServiceException the service exception
     */
    Order insertNewEntity(Map<String, String> order) throws ServiceException;

    /**
     * Find id butler with min numbers of orders long.
     *
     * @return the long id butler's
     * @throws ServiceException the service exception
     */
    Long findIdButlerWithMinNumbersOfOrders() throws ServiceException;

    /**
     * Show active orders list.
     *
     * @param isActive the is active
     * @return the list of active orders
     * @throws ServiceException the service exception
     */
    List<Order> showActiveOrders(boolean isActive) throws ServiceException;

    /**
     * Show orders by butler list.
     *
     * @param id_butler the id butler
     * @return the list of orders selected by butlers
     * @throws ServiceException the service exception
     */
    List<Order> showOrdersByButler (Long id_butler) throws ServiceException;
}
