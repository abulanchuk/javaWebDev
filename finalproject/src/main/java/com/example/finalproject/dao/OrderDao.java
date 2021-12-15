package com.example.finalproject.dao;

import com.example.finalproject.entity.Order;
import com.example.finalproject.exception.DaoException;

import java.time.LocalDate;

public interface OrderDao extends BaseDao<Order> {
    boolean updateStartDate(LocalDate newStartDate) throws DaoException;
    boolean updateFinishDate(LocalDate newFinishDate) throws DaoException;
    boolean updatePaymentStatus (boolean status) throws DaoException; //todo
    boolean updateActiveStatus (boolean status) throws DaoException;
}
