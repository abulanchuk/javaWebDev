package com.example.finalproject.model.dao;

import com.example.finalproject.model.entity.Discount;
import com.example.finalproject.exception.DaoException;

import java.util.Optional;

/**
 * The interface Discount dao.
 */
public interface DiscountDao extends BaseDao<Discount> {
    /**
     * Find discount by percent optional.
     *
     * @param percent the percent of discount
     * @return the optional discount
     * @throws DaoException the dao exception
     */
    Optional<Discount> findDiscountByPercent(byte percent) throws DaoException;
}
