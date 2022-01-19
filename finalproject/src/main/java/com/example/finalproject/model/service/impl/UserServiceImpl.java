package com.example.finalproject.model.service.impl;

import com.example.finalproject.exception.DaoException;
import com.example.finalproject.exception.ServiceException;
import com.example.finalproject.model.dao.UserDao;
import com.example.finalproject.model.dao.impl.UserDaoImpl;
import com.example.finalproject.model.entity.CustomEntity;
import com.example.finalproject.model.entity.User;
import com.example.finalproject.model.entity.UserRole;
import com.example.finalproject.model.service.UserService;
import com.example.finalproject.util.PasswordEncryptor;

import java.util.List;
import java.util.Optional;


public class UserServiceImpl implements UserService{
    private static UserServiceImpl instance;
    private final UserDao userDao = UserDaoImpl.getInstance();

    public UserServiceImpl() {
    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserServiceImpl();
        }
        return instance;
    }

    @Override
    public List findAll() throws ServiceException {
        return null;
    }

    @Override
    public Optional findById(Long id) throws ServiceException {
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) throws ServiceException {
        return false;
    }

    @Override
    public CustomEntity insertNewEntity(CustomEntity... entities) throws ServiceException {
        return null;
    }

    @Override
    public boolean updatePasswordByLogin(String login, String oldPassword, String newPassword) throws ServiceException {
        return false;
    }

    @Override
    public boolean updateLogin(String currentLogin, String newLogin, Long id) throws ServiceException {
        return false;
    }

    @Override
    public List<User> findAllUsersByRole(UserRole role) throws ServiceException {
        return null;
    }

    @Override
    public List<User> findAllUsersWithSuchSurname(String surname) throws ServiceException {
        return null;
    }

    @Override
    public boolean updateSurname(Long id, String newSurname) throws ServiceException {
        return false;
    }

    @Override
    public boolean updateName(String newName, Long id) throws ServiceException {
        return false;
    }

    @Override
    public boolean updatePhoneNumber(String newPhoneNumber, Long id) throws ServiceException {
        return false;
    }

    @Override
    public Optional<User> findUserByPhoneNumber(String phone) throws ServiceException {
        return Optional.empty();
    }

    @Override
    public Optional<User> findUserByLoginAndPassword(String login, String password) throws ServiceException {
        Optional<User> foundUser;
        try {
            foundUser = userDao.findUserByLogin(login);
        } catch (DaoException e) {
            throw new ServiceException("login() - Failed to find user by login: ", e);
        }

        if (!foundUser.isPresent()) {
            return Optional.empty();
        }

        String passwordToCheck = foundUser.get().getPassword();
        if (!passwordToCheck.equals(PasswordEncryptor.encrypt(password))) {
            return Optional.empty();
        }
        return foundUser;
    }

    @Override
    public Optional<User> findUserByLogin(String login) throws ServiceException {
        Optional<User> foundUser;
        try {
            foundUser = userDao.findUserByLogin(login);
        } catch (DaoException e) {
            throw new ServiceException("login() - Failed to find user by login: ", e);
        }

        if (!foundUser.isPresent()) {
            return Optional.empty();
        }
        return foundUser;
    }
}
