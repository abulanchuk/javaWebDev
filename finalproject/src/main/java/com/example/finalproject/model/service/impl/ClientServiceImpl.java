package com.example.finalproject.model.service.impl;

import com.example.finalproject.exception.DaoException;
import com.example.finalproject.exception.ServiceException;
import com.example.finalproject.model.dao.ClientDao;
import com.example.finalproject.model.dao.impl.ClientDaoImpl;
import com.example.finalproject.model.entity.Client;
import com.example.finalproject.model.entity.CustomEntity;
import com.example.finalproject.model.service.ClientService;
import com.example.finalproject.util.PasswordEncryptor;
import com.example.finalproject.validator.Validator;
import com.example.finalproject.validator.impl.ValidatorImpl;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class ClientServiceImpl implements ClientService {
    private static final Logger logger = LogManager.getLogger(ClientServiceImpl.class);
    Validator validator = new ValidatorImpl();
    private static ClientServiceImpl instance;
    private final ClientDao clientDao = ClientDaoImpl.getInstance();

    public ClientServiceImpl() {
    }

    public static ClientService getInstance() {
        if (instance == null) {
            instance = new ClientServiceImpl();
        }
        return instance;
    }

    @Override
    public List findAll() throws ServiceException {
        return null;
    }

    @Override
    public Optional findById(Long id) throws ServiceException {
        Optional<Client> client;
        try {
            client = clientDao.findById(id);
        } catch (DaoException e) {
            throw new ServiceException("Failed to find client by id " + id, e);
        }
        return client;
    }

    @Override
    public Optional<Client> findByEmail(String email) throws ServiceException {
        Optional<Client> client;
        try {
            client = clientDao.findByEmail(email);
        } catch (DaoException e) {
            throw new ServiceException("Failed to find client by email " + email, e);
        }
        return client;
    }

    @Override
    public Optional findByIdUser(Long id) throws ServiceException {
        Optional<Client> client;
        try {
            client = clientDao.findByIdUser(id);
        } catch (DaoException e) {
            throw new ServiceException("Failed to find client by id " + id, e);
        }
        return client;
    }

    @Override
    public boolean deleteById(Long id) throws ServiceException {
        return false;
    }

    @Override
    public CustomEntity insertNewEntity(CustomEntity... entities) throws ServiceException {
        Client client;
        try {
            client = clientDao.insertNewEntity(entities);
        } catch (DaoException e) {
            throw new ServiceException("Failed to create new client ", e);
        }
        return client;
    }

    @Override
    public boolean updateEmail(Long id, String newEmail) throws ServiceException {
        return false;
    }

    @Override
    public boolean updateCashInBankAccount(Long id, BigDecimal howMuchToAdd) throws ServiceException {
        return false;
    }

    @Override
    public boolean updatePassportNumber(String oldPasswordNumber, String newPasswordNumber) throws ServiceException {
        return false;
    }

    @Override
    public boolean updateClient(Long idUser, String newPassword, String newName, String newSurname, String newPhoneNumber, String email, String passportNumber) throws ServiceException {
        try {
            boolean isCorrectNewFields = validator.isCorrectPassword(newPassword) && validator.isCorrectName(newName) && validator.isCorrectSurname(newSurname) && validator.isCorrectPhoneNumber(newPhoneNumber) && validator.isEmailValid(email) && validator.isPasswordNumberValid(passportNumber);
            String newEncryptedPassword = null;
            if (isCorrectNewFields) {
                newEncryptedPassword = PasswordEncryptor.encrypt(newPassword);
            }
            return isCorrectNewFields && clientDao.updateClient(idUser, newEncryptedPassword, newName, newSurname, newPhoneNumber,email, passportNumber);
        } catch (DaoException e) {
            logger.log(Level.ERROR, "Impossible to change user's fields:", e);
            throw new ServiceException("Impossible to change user's fields:", e);
        }
    }
}
