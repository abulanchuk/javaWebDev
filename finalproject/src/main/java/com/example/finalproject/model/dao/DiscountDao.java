package com.example.finalproject.model.dao;

import com.example.finalproject.entity.Discount;
import com.example.finalproject.exception.DaoException;

import java.util.Optional;

public interface DiscountDao extends BaseDao<Discount> {
    boolean updateDiscount(byte newDiscount) throws DaoException;
    Optional<Discount> findDiscountByPercent(byte percent) throws DaoException;
}
