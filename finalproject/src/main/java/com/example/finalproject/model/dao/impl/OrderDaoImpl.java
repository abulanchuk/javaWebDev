package com.example.finalproject.model.dao.impl;

import com.example.finalproject.model.entity.Order;
import com.example.finalproject.exception.DaoException;
import com.example.finalproject.model.dao.OrderDao;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class OrderDaoImpl implements OrderDao {
    static final Logger logger = LogManager.getLogger(OrderDaoImpl.class);
    private static final String SQL_SELECT_ALL_ORDERS = """
            SELECT name, surname, phone_number, email, password_number, start_date, finish_date, is_paid, is_active FROM orders
            INNER JOIN clients ON orders.order_id_client = clients.id_client
            INNER JOIN users ON clients.id_user = users.id_user""";
    private static final String SQL_SELECT_ORDER_BY_ID = """
            SELECT name, surname, phone_number, email, password_number, start_date, finish_date, is_paid, is_active FROM orders
            INNER JOIN clients ON orders.order_id_client = clients.id_client
            INNER JOIN users ON clients.id_user = users.id_user WHERE orders.id_order = ?""";
    private static final String SQL_DELETE_ORDER_BY_ID = """
            DELETE FROM orders WHERE orders.id_order = ?""";
    private static final String SQL_INSERT_ORDER = """
            INSERT INTO orders (id_order, id_butler, start_date, finish_date, is_paid, is_active, order_id_client) VALUES (?,?,?,?,?,?,?)""";
    private static final String SQL_UPDATE_START_TIME = """
            UPDATE start_date = ? WHERE start_date = ?""";
    private static final String SQL_UPDATE_FINISH_TIME = """
            UPDATE finish_date = ? WHERE finish_date = ?""";
    private static final String SQL_UPDATE_PAYMENT_STATUS = """
            UPDATE is_paid = ? WHERE is_paid = ?""";
    private static final String SQL_UPDATE_ACTIVE_STATUS = """
            UPDATE is_active = ? WHERE is_active = ?""";
    private static final String SQL_SELECT_PAID_ORDERS = """
           SELECT name, surname, phone_number, email, password_number, start_date, finish_date, is_paid, is_active FROM orders
            INNER JOIN clients ON orders.order_id_client = clients.id_client
            INNER JOIN users ON clients.id_user = users.id_user WHERE orders.is_paid >0 """; //TODO
    private static final String SQL_SELECT_NOT_PAID_ORDERS = """
           SELECT name, surname, phone_number, email, password_number, start_date, finish_date, is_paid, is_active FROM orders
            INNER JOIN clients ON orders.order_id_client = clients.id_client
            INNER JOIN users ON clients.id_user = users.id_user WHERE orders.is_paid <1 """;

    @Override
    public List<Order> findAll() throws DaoException {
        return null;
    }

    @Override
    public Optional<Order> findById(Long id) throws DaoException {
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) throws DaoException {
        return false;
    }

    @Override
    public long insertNewEntity(Order entity) throws DaoException {
        return 0;
    }

    @Override
    public boolean updateStartDate(LocalDate currentStartDate, LocalDate newStartDate) throws DaoException {
        return false;
    }

    @Override
    public boolean updateFinishDate(LocalDate currentFinishDate, LocalDate newFinishDate) throws DaoException {
        return false;
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
