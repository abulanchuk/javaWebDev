package com.example.finalproject.dao;

import com.example.finalproject.entity.Discount;
import com.example.finalproject.exception.DaoException;

public interface DiscountDao extends BaseDao<Discount> {
    boolean updateDiscount(String newDiscount) throws DaoException;
}
