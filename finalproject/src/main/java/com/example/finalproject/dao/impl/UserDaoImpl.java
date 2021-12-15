package com.example.finalproject.dao.impl;

import com.example.finalproject.dao.UserDao;
import com.example.finalproject.entity.User;
import com.example.finalproject.entity.UserRole;
import com.example.finalproject.exception.DaoException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {
    static final Logger logger = LogManager.getLogger(UserDaoImpl.class);
    private static final String SQL_SELECT_ALL_USERS = """
            SELECT idUser, login, password, role, name, surname, phonenumber FROM users""";
    private static final String SQL_SELECT_USER_BY_ID = """
            SELECT login, password, role, name, surname, phonenumber FROM user WHERE user.idUser =(?)""";
    private static final String SQL_DELETE_BY_ID = """
            DELETE FROM users WHERE user_id = (?)""";
    private static final String SQL_UPDATE_USERS = """
            """;

    @Override
    public List<User> findAll() throws DaoException {
        List<User> allUsers = new ArrayList<>();//todo
        return allUsers;
    }

    @Override
    public User findById(User id) throws DaoException {
        return null;
    }

    @Override
    public void deleteById(User id) throws DaoException {

    }

    @Override
    public User update(User user) throws DaoException {
        return null;
    }

    @Override
    public void close(Connection connection) throws DaoException {
        UserDao.super.close(connection);
    }

    @Override
    public boolean updatePassword(String login, String oldPassword, String newPassword) throws DaoException {
        return false;
    }

    @Override
    public boolean updateLogin(String currentLogin, String newLogin) throws DaoException {
        return false;
    }

    @Override
    public List<User> findAllUsersWithRole(UserRole role) throws DaoException {
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
    public Optional<User> findUserByPhoneNumber(String phone) throws DaoException {
        return Optional.empty();
    }

    @Override
    public Optional<User> findUserByLogin(String login) throws DaoException {
        return Optional.empty();
    }
}
