package com.example.finalproject.model.dao;

import com.example.finalproject.model.entity.Order;
import com.example.finalproject.exception.DaoException;

import java.time.LocalDate;
import java.util.List;

/**
 * The interface Order dao.
 */
public interface OrderDao extends BaseDao<Order> {
    /**
     * Update start date boolean.
     *
     * @param currentStartDate the current start date
     * @param newStartDate     the new start date
     * @return the successful result or not (boolean)
     * @throws DaoException the dao exception
     */
    boolean updateStartDate(LocalDate currentStartDate, LocalDate newStartDate) throws DaoException;

    /**
     * Update finish date boolean.
     *
     * @param currentFinishDate the current finish date
     * @param newFinishDate     the new finish date
     * @return the successful result or not (boolean)
     * @throws DaoException the dao exception
     */
    boolean updateFinishDate(LocalDate currentFinishDate, LocalDate newFinishDate) throws DaoException;

    /**
     * Update payment status boolean.
     *
     * @param status the status of payment
     * @param id     the id
     * @return the successful result or not (boolean)
     * @throws DaoException the dao exception
     */
    boolean updatePaymentStatus (boolean status, long id) throws DaoException;

    /**
     * Update active status boolean.
     *
     * @param status the status (active order or not)
     * @param id     the id
     * @return the successful result or not (boolean)
     * @throws DaoException the dao exception
     */
    boolean updateActiveStatus (boolean status, long id) throws DaoException;

    /**
     * Show paid orders list.
     *
     * @return the list with paid orders
     * @throws DaoException the dao exception
     */
    List<Order> showPaidOrders () throws DaoException;

    /**
     * Show not paid orders list.
     *
     * @return the list with no paid orders
     * @throws DaoException the dao exception
     */
    List<Order> showNotPaidOrders () throws DaoException;

    /**
     * Show active orders list.
     *
     * @return the list active orders
     * @throws DaoException the dao exception
     */
    List<Order> showActiveOrders () throws DaoException;

    /**
     * Show not active orders list.
     *
     * @return the list of orders whose dates are already in the past
     * @throws DaoException the dao exception
     */
    List<Order> showNotActiveOrders () throws DaoException;

    /**
     * Show orders by butler list.
     *
     * @param id_butler the id butler
     * @return the butler's list with orders where he work
     * @throws DaoException the dao exception
     */
    List<Order> showOrdersByButler (Long id_butler) throws DaoException;

    /**
     * Select orders list.
     *
     * @param isActive the is active
     * @return the list active orders
     * @throws DaoException the dao exception
     */
    List<Order> selectOrders(boolean isActive) throws DaoException;

    /**
     * Find id butler with min numbers of orders long.
     *
     * @return id butler with min numbers of orders
     * @throws DaoException the dao exception
     */
    Long findIdButlerWithMinNumbersOfOrders() throws DaoException;
}
