package com.example.finalproject.model.service.impl;

import com.example.finalproject.exception.DaoException;
import com.example.finalproject.exception.ServiceException;
import com.example.finalproject.model.dao.UserDao;
import com.example.finalproject.model.dao.impl.UserDaoImpl;
import com.example.finalproject.model.entity.Client;
import com.example.finalproject.model.entity.CustomEntity;
import com.example.finalproject.model.entity.User;
import com.example.finalproject.model.entity.UserRole;
import com.example.finalproject.model.service.UserService;
import com.example.finalproject.util.PasswordEncryptor;
import com.example.finalproject.validator.Validator;
import com.example.finalproject.validator.impl.ValidatorImpl;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Optional;


public class UserServiceImpl implements UserService {
    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);
    private static UserServiceImpl instance;
    private final UserDao userDao = UserDaoImpl.getInstance();
    Validator validator = new ValidatorImpl();

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
        User user;
        try {
            user = userDao.insertNewEntity(entities);
        } catch (DaoException e) {
            throw new ServiceException("Failed to create new user ", e);
        }
        return user;
    }

    @Override
    public boolean updatePasswordByLogin(String login, String oldPassword, String newPassword) throws ServiceException {
        try {
            String encryptedPassword = PasswordEncryptor.encrypt(newPassword);
            return validator.isCorrectPassword(newPassword) && userDao.updatePasswordByLogin(login, oldPassword, encryptedPassword);
        } catch (DaoException e) {
            logger.log(Level.ERROR, "Impossible to change password:", e);
            throw new ServiceException("Impossible to change password:", e);
        }
    }

    @Override
    public boolean updateLogin(String currentLogin, String newLogin, Long id) throws ServiceException {
        try {
            return validator.isCorrectLogin(newLogin) && userDao.updateLogin(currentLogin, newLogin, id);
        } catch (DaoException e) {
            logger.log(Level.ERROR, "Impossible to change login:", e);
            throw new ServiceException("Impossible to change login:", e);
        }
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
        try {
            return validator.isCorrectSurname(newSurname) && userDao.updateSurname(id, newSurname);
        } catch (DaoException e) {
            logger.log(Level.ERROR, "Impossible to change user surname:", e);
            throw new ServiceException("Impossible to change user surname:", e);
        }
    }

    @Override
    public boolean updateName(String newName, Long id) throws ServiceException {
        try {
            return validator.isCorrectName(newName) && userDao.updateName(newName, id);
        } catch (DaoException e) {
            logger.log(Level.ERROR, "Impossible to change user name:", e);
            throw new ServiceException("Impossible to change user name:", e);
        }
    }

    @Override
    public boolean updatePhoneNumber(String newPhoneNumber, Long id) throws ServiceException {
        try {
            return validator.isCorrectPhoneNumber(newPhoneNumber) && userDao.updatePhoneNumber(newPhoneNumber, id);
        } catch (DaoException e) {
            logger.log(Level.ERROR, "Impossible to change user's phone number:", e);
            throw new ServiceException("Impossible to change user's phone number:", e);
        }
    }

    @Override
    public boolean updateUser(Long id, String newLogin, String newPassword, String newName, String newSurname, String newPhoneNumber) throws ServiceException {
        try {
            boolean isCorrectNewFields = validator.isCorrectLogin(newLogin) && validator.isCorrectPassword(newPassword) && validator.isCorrectName(newName) && validator.isCorrectSurname(newSurname) && validator.isCorrectPhoneNumber(newPhoneNumber);
            String newEncryptedPassword = null;
            if (isCorrectNewFields) {
                newEncryptedPassword = PasswordEncryptor.encrypt(newPassword);
            }
            return isCorrectNewFields && userDao.updateUser(id, newLogin, newEncryptedPassword, newName, newSurname, newPhoneNumber);
        } catch (DaoException e) {
            logger.log(Level.ERROR, "Impossible to change user's fields:", e);
            throw new ServiceException("Impossible to change user's fields:", e);
        }
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
