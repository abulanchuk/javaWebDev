package com.example.finalproject.model.service.impl;

import com.example.finalproject.exception.DaoException;
import com.example.finalproject.exception.ServiceException;
import com.example.finalproject.model.dao.ClientDao;
import com.example.finalproject.model.dao.impl.ClientDaoImpl;
import com.example.finalproject.model.entity.Client;
import com.example.finalproject.model.entity.CustomEntity;
import com.example.finalproject.model.service.ClientService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class ClientServiceImpl implements ClientService {
    private static ClientServiceImpl instance;
    private final ClientDao clientDao = ClientDaoImpl.getInstance();

    private ClientServiceImpl() {
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
        return null;
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
}
