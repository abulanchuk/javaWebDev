package com.example.finalproject.model.dao.impl;

import com.example.finalproject.entity.Discount;
import com.example.finalproject.exception.DaoException;
import com.example.finalproject.model.dao.DiscountDao;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class DiscountDaoImpl implements DiscountDao {
    static final Logger logger = LogManager.getLogger(DiscountDaoImpl.class);
    private static final String SQL_SELECT_ALL_DISCOUNTS = """
    SELECT id_discount, percent FROM discounts""";
    private static final String SQL_SELECT_DISCOUNT_BY_ID = """
    SELECT id_discount, percent FROM discounts WHERE id_discount = ?""";
    private static final String SQL_DELETE_DISCOUNT_BY_ID = """
            DELETE FROM discounts WHERE id_discount = ?""";
    private static final String SQL_UPDATE_DISCOUNT_BY_ID = """
            UPDATE discounts SET percent = ? WHERE percent = ?""";
    private static final String SQL_SELECT_DISCOUNTS_BY_PERCENT = """
    SELECT id_discount, percent FROM discounts WHERE percent = ?""";
    @Override
    public List<Discount> findAll() throws DaoException {
        return null;
    }

    @Override
    public Optional<Discount> findById(Discount id) throws DaoException {
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Discount user) throws DaoException {
        return false;
    }

    @Override
    public boolean updateDiscount(String newDiscount) throws DaoException {
        return false;
    }

    @Override
    public Optional<Discount> findDiscountByPercent(byte percent) throws DaoException {
        return Optional.empty();
    }
}
