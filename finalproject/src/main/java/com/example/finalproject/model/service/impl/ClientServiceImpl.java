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
        try {
            List<Client> clientList = clientDao.findAll();
            return clientList;
        } catch (DaoException e) {
            logger.log(Level.ERROR, "Impossible to show all clients:", e);
            throw new ServiceException("Some problems in method findAll(): " + e);
        }
    }

    @Override
    public Optional findById(Long id) throws ServiceException {
        Optional<Client> client;
        try {
            client = clientDao.findById(id);
        } catch (DaoException e) {
            logger.log(Level.ERROR, "Failed to find client by id " + id, e);
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
            logger.log(Level.ERROR, "Failed to find client by email " + email, e);
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
            logger.log(Level.ERROR, "Failed to find client by id ", e);
            throw new ServiceException("Failed to find client by id " + id, e);
        }
        return client;
    }

    @Override
    public boolean deleteById(Long id) throws ServiceException {
        return false;
    }

    @Override
    public void deleteByLogin(String login) throws ServiceException {
        try {
            if (!validator.isCorrectLogin(login)) {
                throw new ServiceException("Invalid login for deleting " + login);
            }
            boolean result = clientDao.deleteByLogin(login);
        } catch (DaoException e) {
            logger.log(Level.ERROR, "Failed to delete client by login", e);
            throw new ServiceException("Failed to delete client by login " + login, e);
        }

    }

    @Override
    public CustomEntity insertNewEntity(CustomEntity entity) throws ServiceException {
        Client client;
        try {
            client = clientDao.insertNewEntity(entity);
        } catch (DaoException e) {
            logger.log(Level.ERROR, "Failed to create new client ", e);
            throw new ServiceException("Failed to create new client ", e);
        }
        return client;
    }

    @Override
    public boolean updateEmail(Long id, String newEmail) throws ServiceException {
        return false;
    }

    @Override
    public boolean updatePassword(Long id, String oldPassword, String newPassword) throws ServiceException {
        if(!validator.isCorrectPassword(newPassword)){
            return false;
        }
        boolean resultFromUpdating;
        try {
            String encryptedOldPassword = PasswordEncryptor.encrypt(oldPassword);
            String encryptedNewPassword = PasswordEncryptor.encrypt(newPassword);
           resultFromUpdating = clientDao.updatePassword(id,encryptedOldPassword,encryptedNewPassword);
        } catch (DaoException e) {
            logger.log(Level.ERROR, "Impossible to update password:", e);
            throw new ServiceException("Impossible to update password:", e);
        }
        return resultFromUpdating;
    }

    @Override
    public boolean updateCashInBankAccount(Long id, String howMuchToAdd) throws ServiceException {
        if (!validator.isDepositAnAccountValid(howMuchToAdd)) {
            logger.log(Level.ERROR, "Impossible to update cash, because \" + howMuchToAdd + \" has got invalid type ");
            throw new ServiceException("Impossible to update cash, because " + howMuchToAdd + " has got invalid type ");
        }
        BigDecimal moneyForAdding = new BigDecimal(howMuchToAdd);
        boolean resultFromUpdating;
        try {
             resultFromUpdating = clientDao.updateCashInBankAccount(id,moneyForAdding);
        } catch (DaoException e) {
            logger.log(Level.ERROR, "Impossible to update bank account:", e);
            throw new ServiceException("Impossible to update bank account:", e);
        }
        return resultFromUpdating;
    }

    @Override
    public boolean withdrawalCashFromBankAccount(Long id, String howMuchToWithdrawal) throws ServiceException {
        if (!validator.isDepositAnAccountValid(howMuchToWithdrawal)) {
            logger.log(Level.ERROR, "Impossible to change user's fields:");
            throw new ServiceException("Impossible to update cash, because " + howMuchToWithdrawal + " has got invalid type ");
        }
        BigDecimal howMuchCostsRoom = new BigDecimal(howMuchToWithdrawal);
        boolean resultFromUpdating;
        try {
            resultFromUpdating = clientDao.withdrawalCashFromBankAccount(id,howMuchCostsRoom);
        } catch (DaoException e) {
            logger.log(Level.ERROR, "Impossible to update bank account:", e);
            throw new ServiceException("Impossible to update bank account:", e);
        }
        return resultFromUpdating;
    }

    @Override
    public boolean updatePassportNumber(String oldPasswordNumber, String newPasswordNumber) throws ServiceException {
        return false;
    }

    @Override
    public boolean updateClient(Long idUser, String newName, String newSurname, String newPhoneNumber, String email, String passportNumber) throws ServiceException {
        try {
            boolean isCorrectNewFields =  validator.isCorrectName(newName) && validator.isCorrectSurname(newSurname) && validator.isCorrectPhoneNumber(newPhoneNumber) && validator.isEmailValid(email) && validator.isPasswordNumberValid(passportNumber);

            return isCorrectNewFields && clientDao.updateClient(idUser, newName, newSurname, newPhoneNumber, email, passportNumber);
        } catch (DaoException e) {
            logger.log(Level.ERROR, "Impossible to change user's fields:", e);
            throw new ServiceException("Impossible to change user's fields:", e);
        }
    }
}
