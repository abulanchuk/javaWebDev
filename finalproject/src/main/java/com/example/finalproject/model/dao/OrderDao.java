package com.example.finalproject.model.dao;

import com.example.finalproject.model.entity.Order;
import com.example.finalproject.exception.DaoException;

import java.time.LocalDate;
import java.util.List;

public interface OrderDao extends BaseDao<Order> {
    boolean updateStartDate(LocalDate currentStartDate, LocalDate newStartDate) throws DaoException;
    boolean updateFinishDate(LocalDate currentFinishDate, LocalDate newFinishDate) throws DaoException;
    boolean updatePaymentStatus (boolean status) throws DaoException;
    boolean updateActiveStatus (boolean status) throws DaoException;
    List<Order> showPaidOrders (boolean status) throws DaoException;
    List<Order> showNotPaidOrders (boolean status) throws DaoException;
}
