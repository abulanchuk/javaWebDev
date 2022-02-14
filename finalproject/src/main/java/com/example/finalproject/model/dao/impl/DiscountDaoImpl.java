package com.example.finalproject.model.dao.impl;

import com.example.finalproject.model.entity.CustomEntity;
import com.example.finalproject.model.entity.Discount;
import com.example.finalproject.exception.DaoException;
import com.example.finalproject.model.dao.DiscountDao;
import com.example.finalproject.model.mapper.impl.DiscountCreator;
import com.example.finalproject.model.pool.ConnectionPool;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DiscountDaoImpl implements DiscountDao {
    static final Logger logger = LogManager.getLogger(DiscountDaoImpl.class);
    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final String SQL_SELECT_ALL_DISCOUNTS = """
            SELECT id_discount, percent FROM discounts""";
    private static final String SQL_SELECT_DISCOUNT_BY_ID = """
            SELECT id_discount, percent FROM discounts WHERE id_discount = ?""";
    private static final String SQL_DELETE_DISCOUNT_BY_ID = """
            DELETE FROM discounts WHERE id_discount = ?""";
    private static final String SQL_INSERT_DISCOUNT = """
            INSERT INTO discounts (percent) VALUES (?)""";
    private static final String SQL_UPDATE_DISCOUNT_BY_ID = """
            UPDATE discounts SET percent = ? WHERE percent = ?""";
    private static final String SQL_SELECT_DISCOUNTS_BY_PERCENT = """
            SELECT id_discount, percent FROM discounts WHERE percent = ?""";
    private DiscountCreator discountCreator = new DiscountCreator();

    @Override
    public List<Discount> findAll() throws DaoException {
        try (Connection connection = connectionPool.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_DISCOUNTS)) {
            List<Discount> discounts = new ArrayList<>();
            while (resultSet.next()) {
                Discount discount = discountCreator.create(resultSet);
                discounts.add(discount);
            }
            logger.log(Level.DEBUG, "findAll method from DiscountDaoImpl was completed successfully. " + discounts.size() + " were found");
            return discounts;
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Impossible to find discounts. Database access error: ", e);
            throw new DaoException("Impossible to find discounts. Database access error: ", e);
        }
    }

    @Override
    public Optional<Discount> findById(Long id) throws DaoException {
        Optional<Discount> discountOptional = Optional.empty();
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_DISCOUNT_BY_ID)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Discount discount = discountCreator.create(resultSet);
                    discountOptional = Optional.of(discount);
                }
            }
            logger.log(Level.DEBUG, "findById method from DiscountDaoImpl was completed successfully."
                    + ((discountOptional.isPresent()) ? " Discount with id " + id + " was found" : " Discount with id " + id + " don't exist"));
            return discountOptional;
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Impossible to find discount by id. Database access error:", e);
            throw new DaoException("Impossible to find discount by id. Database access error:", e);
        }
    }

    @Override
    public boolean deleteById(Long id) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_DELETE_DISCOUNT_BY_ID)) {
            statement.setLong(1, id);
            return statement.executeUpdate() != 0;
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Impossible to delete discount with such id: " + id, e);
            throw new DaoException("Impossible to delete discount with such id: " + id, e);
        }
    }

    @Override
    public Discount insertNewEntity(CustomEntity entity) throws DaoException {
        if (!(entity instanceof Discount)) {
            logger.log(Level.ERROR, "Expected type Discount, got " + entity.getClass());
            throw new DaoException("Expected type Discount, got " + entity.getClass());
        }
        Discount comment = (Discount) entity;
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_INSERT_DISCOUNT)) {

            statement.setByte(1, comment.getPercent());
            statement.executeUpdate();

        } catch (SQLException e) {
            logger.log(Level.DEBUG, "Failed to create discount", e);
            throw new DaoException("Failed to create discount: ", e);
        }
        return comment;
    }

    @Override
    public Optional<Discount> findDiscountByPercent(byte percent) throws DaoException {
        Optional<Discount> discountOptional = Optional.empty();
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_DISCOUNTS_BY_PERCENT)) {
            statement.setLong(1, percent);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Discount discount = discountCreator.create(resultSet);
                    discountOptional = Optional.of(discount);
                }
            }
            logger.log(Level.DEBUG, "findById method from DiscountDaoImpl was completed successfully."
                    + ((discountOptional.isPresent()) ? " Discount with percent " + percent + " was found" : " Discount with percent " + percent + " don't exist"));
            return discountOptional;
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Impossible to find discount by percent. Database access error:", e);
            throw new DaoException("Impossible to find discount by percent. Database access error:", e);
        }
    }
}
