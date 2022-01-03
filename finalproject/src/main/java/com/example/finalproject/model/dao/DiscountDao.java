package com.example.finalproject.model.dao;

import com.example.finalproject.model.entity.Discount;
import com.example.finalproject.exception.DaoException;

import java.util.Optional;

public interface DiscountDao extends BaseDao<Discount> {
    Optional<Discount> findDiscountByPercent(byte percent) throws DaoException;
}
