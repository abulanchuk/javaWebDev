package com.example.finalproject.model.dao.impl;

import com.example.finalproject.model.entity.Order;
import com.example.finalproject.exception.DaoException;
import com.example.finalproject.model.dao.OrderDao;
import com.example.finalproject.model.mapper.impl.OrderCreator;
import com.example.finalproject.model.pool.ConnectionPool;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderDaoImpl implements OrderDao {
    static final Logger logger = LogManager.getLogger(OrderDaoImpl.class);
    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final String SQL_SELECT_ALL_ORDERS = """
            SELECT id_order, name, surname, phone_number, email, password_number, start_date, finish_date, is_paid, is_active, orders.order_id_client  FROM orders
            INNER JOIN clients ON orders.order_id_client = clients.id_client
            INNER JOIN users ON clients.id_user = users.id_user""";
    private static final String SQL_SELECT_ORDER_BY_ID = """
            SELECT id_order, name, surname, phone_number, email, password_number, start_date, finish_date, is_paid, is_active FROM orders
            INNER JOIN clients ON orders.order_id_client = clients.id_client
            INNER JOIN users ON clients.id_user = users.id_user WHERE orders.id_order = ?""";
    private static final String SQL_DELETE_ORDER_BY_ID = """
            DELETE FROM orders WHERE orders.id_order = ?""";
    private static final String SQL_INSERT_ORDER = """
            INSERT INTO orders (id_order, id_butler, start_date, finish_date, is_paid, is_active, order_id_client) VALUES (?,?,?,?,?,?,?)""";
    private static final String SQL_UPDATE_START_TIME = """
            UPDATE orders SET start_date = ? WHERE start_date = ?""";
    private static final String SQL_UPDATE_FINISH_TIME = """
            UPDATE orders SET finish_date = ? WHERE finish_date = ?""";
    private static final String SQL_UPDATE_PAYMENT_STATUS = """
            UPDATE orders SET is_paid = ? WHERE is_paid = ?""";
    private static final String SQL_UPDATE_ACTIVE_STATUS = """
            UPDATE orders SET is_active = ? WHERE is_active = ?""";
    private static final String SQL_SELECT_PAID_ORDERS = """
            SELECT id_order, name, surname, phone_number, email, password_number, start_date, finish_date, is_paid, is_active FROM orders
             INNER JOIN clients ON orders.order_id_client = clients.id_client
             INNER JOIN users ON clients.id_user = users.id_user WHERE orders.is_paid >0 """; //TODO
    private static final String SQL_SELECT_NOT_PAID_ORDERS = """
            SELECT id_order,name, surname, phone_number, email, password_number, start_date, finish_date, is_paid, is_active FROM orders
             INNER JOIN clients ON orders.order_id_client = clients.id_client
             INNER JOIN users ON clients.id_user = users.id_user WHERE orders.is_paid <1 """;
    OrderCreator orderCreator = new OrderCreator();

    @Override
    public List<Order> findAll() throws DaoException {
        try (Connection connection = connectionPool.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_ORDERS)) {
            List<Order> orders = new ArrayList<>();
            while (resultSet.next()) {
                Order order = orderCreator.create(resultSet);
                orders.add(order);
            }
            logger.log(Level.DEBUG, "findAll method from OrdersDaoImpl was completed successfully. " + orders.size() + " were found");
            return orders;
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Impossible to find orders. Database access error: ", e);
            throw new DaoException("Impossible to find orders. Database access error: ", e);
        }
    }

    @Override
    public Optional<Order> findById(Long id) throws DaoException {
        Optional<Order> orderOptional = Optional.empty();
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ORDER_BY_ID)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Order order = orderCreator.create(resultSet);
                orderOptional = Optional.of(order);
            }
            logger.log(Level.DEBUG, "findById method from OrderDaoImpl was completed successfully."
                    + ((orderOptional.isPresent()) ? " Discount with id " + id + " was found" : " Discount with id " + id + " don't exist"));
            return orderOptional;
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Impossible to find order by id. Database access error:", e);
            throw new DaoException("Impossible to find order by id. Database access error:", e);
        }
    }

    @Override
    public boolean deleteById(Long id) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_DELETE_ORDER_BY_ID)) {
            statement.setLong(1, id);
            logger.log(Level.DEBUG, "The order was successfully deleted by id " + id);
            return statement.executeUpdate() != 0;
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Impossible to delete order with such id: " + id, e);
            throw new DaoException("Impossible to delete order with such id: " + id, e);
        }
    }

    @Override
    public long insertNewEntity(Order entity) throws DaoException {
        return 0; //todo
    }

    @Override
    public boolean updateStartDate(LocalDate currentStartDate, LocalDate newStartDate) throws DaoException {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_START_TIME)) {
            statement.setObject(1, newStartDate);
            statement.setObject(2, currentStartDate);
            boolean isUpdated = statement.executeUpdate() == 1;
            if (!isUpdated) {
                logger.log(Level.INFO, "Start date didn't update " + newStartDate);
                return false;
            }
            logger.log(Level.DEBUG, "Successfully replaced " + currentStartDate + " with " + newStartDate);
            return true;
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Impossible to update start date. Database access error:", e);
            throw new DaoException("Impossible to update start date. Database access error:", e);
        }
    }

    @Override
    public boolean updateFinishDate(LocalDate currentFinishDate, LocalDate newFinishDate) throws DaoException {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_START_TIME)) {
            statement.setObject(1, newFinishDate);
            statement.setObject(2, currentFinishDate);
            boolean isUpdated = statement.executeUpdate() == 1;
            if (!isUpdated) {
                logger.log(Level.INFO, "Finish date didn't update " + newFinishDate);
                return false;
            }
            logger.log(Level.DEBUG, "Successfully replaced " + currentFinishDate + " with " + newFinishDate);
            return true;
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Impossible to update finish date. Database access error:", e);
            throw new DaoException("Impossible to update finish date. Database access error:", e);
        }
    }

    @Override
    public boolean updatePaymentStatus(boolean status) throws DaoException {
        return false;
    }

    @Override
    public boolean updateActiveStatus(boolean status) throws DaoException {
        return false;
    }

    @Override
    public List<Order> showPaidOrders(boolean status) throws DaoException {
        return null;
    }

    @Override
    public List<Order> showNotPaidOrders(boolean status) throws DaoException {
        return null;
    }
}
