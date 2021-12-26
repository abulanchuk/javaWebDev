package com.example.finalproject.model.dao.impl;

import com.example.finalproject.model.dao.UserDao;
import com.example.finalproject.model.entity.User;
import com.example.finalproject.model.entity.UserRole;
import com.example.finalproject.exception.DaoException;
import com.example.finalproject.model.pool.ConnectionPool;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {
    static final Logger logger = LogManager.getLogger(UserDaoImpl.class);
    private static final String SQL_SELECT_ALL_USERS = """
            SELECT id_user, login, password, role, name, surname, phone_number FROM users""";
    private static final String SQL_SELECT_USER_BY_ID = """
            SELECT login, password, role, name, surname, phone_number FROM users WHERE id_user =?""";
    private static final String SQL_DELETE_USER_BY_ID = """
            DELETE users, clients, orders FROM users 
            INNER JOIN clients ON users.id_user = clients.id_user 
            INNER JOIN orders ON orders.order_id_client = clients.id_client WHERE users.id_user = ?""";
    private static final String SQL_INSERT_USER = """
            INSERT INTO users (id_user, login, password, role, name, surname, phone_number) VALUES (?,?,?,?,?,?,?)""";
    private static final String SQL_UPDATE_USERS = """
            UPDATE users SET login = ?, password = ?, role = ?, name = ?, surname=?, phone_number = ?""";
    private static final String SQL_UPDATE_PASSWORD_BY_LOGIN = """
            UPDATE users SET password = ? WHERE login = ?""";
    private static final String SQL_UPDATE_LOGIN = """
            UPDATE users SET login = ? WHERE login = ?""";
    private static final String SQL_SELECT_USERS_BY_ROLE = """
            SELECT name, surname, phone_number WHERE role = ?""";
    private static final String SQL_SELECT_USERS_BY_NAME = """
            SELECT name, surname, phone_number WHERE name = ?""";
    private static final String SQL_SELECT_USERS_BY_SURNAME = """
            SELECT name, surname, phone_number WHERE surname = ?""";
    private static final String SQL_UPDATE_SURNAME = """
            UPDATE users SET surname = ? WHERE surname = ?""";
    private static final String SQL_UPDATE_NAME = """
            UPDATE users SET name = ? WHERE name = ?""";
    private static final String SQL_SELECT_USER_BY_PHONE_NUMBER = """
            SELECT name, surname, role WHERE phone_number = ?""";
    private static final String SQL_SELECT_USER_BY_LOGIN = """
            SELECT name, surname, role, phone_number WHERE login = ?""";
    private static final String SQL_UPDATE_PHONE_NUMBER = """
            UPDATE users SET phone_number = ? WHERE phone_number = ?""";


    @Override
    public List<User> findAll() throws DaoException {
        return null;
    }


    @Override
    public Optional<User> findById(Long id) throws DaoException {
        return null;
    }

    @Override
    public boolean deleteById(User user) throws DaoException {
        return false;
    }

    @Override
    public long insertNewEntity(User entity) throws DaoException {
        return 0;
    }

    @Override
    public void close(Connection connection) throws DaoException {
        UserDao.super.close(connection);
    }

    @Override
    public boolean updatePasswordByLogin(String login, String oldPassword, String newPassword) throws DaoException {
        return false;
    }

    @Override
    public boolean updateLogin(String currentLogin, String newLogin) throws DaoException {
        return false;
    }

    @Override
    public List<User> findAllUsersByRole(UserRole role) throws DaoException {
        return null;
    }

    @Override
    public List<User> findAllUsersByName(String name) throws DaoException {
        return null;
    }


    @Override
    public List<User> findAllUsersWithSuchSurname(String surname) throws DaoException {
        return null;
    }

    @Override
    public boolean updateSurname(String currentSurname, String newSurname) throws DaoException {
        return false;
    }

    @Override
    public boolean updateName(String currentName, String newName) throws DaoException {
        return false;
    }

    @Override
    public boolean updatePhoneNumber(String newPhoneNumber) throws DaoException {
        return false;
    }

    @Override
    public Optional<User> findUserByPhoneNumber(String phone) throws DaoException {
        return Optional.empty();
    }

    @Override
    public Optional<User> findUserByLogin(String login) throws DaoException {
        return Optional.empty();
    }
}
