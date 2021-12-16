package com.example.finalproject.dao.impl;

import com.example.finalproject.dao.ClientDao;
import com.example.finalproject.entity.Client;
import com.example.finalproject.exception.DaoException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.util.List;

public class ClientDaoImpl implements ClientDao {
    static final Logger logger = LogManager.getLogger(UserDaoImpl.class);
    private static final String SQL_SELECT_ALL_CLIENTS = """
            SELECT clients.id_client, users.name, users.surname, users.phone_number, clients.password_number, clients.email, clients.bank_account,
            FROM clients INNER JOIN users ON users.id_user = clients.id_user""";
    private static final String SQL_SELECT_CLIENT_BY_ID = """
            SELECT clients.id_client, users.name, users.surname, users.phone_number, clients.password_number, clients.email, clients.bank_account,
            FROM clients INNER JOIN users ON users.id_user = clients.id_user AND id_client =(?)""";
    private static final String SQL_DELETE_CLIENT_BY_ID = """
            DELETE FROM clients, users WHERE users.id_user = clients.id_user AND id_client = (?)""";
    private static final String SQL_UPDATE_CLIENTS = """
            UPDATE clients SET password_number = (?), email = (?), bank_account = (?)""";

    @Override
    public List<Client> findAll() throws DaoException {
        return null;
    }

    @Override
    public Client findById(Client id) throws DaoException {
        return null;
    }

    @Override
    public boolean deleteById(Client user) throws DaoException {
        return false;
    }

    @Override
    public Client update(Client client) throws DaoException {
        return null;
    }

    @Override
    public boolean updateEmail(String oldEmail, String newEmail) throws DaoException {
        return false;
    }

    @Override
    public BigDecimal checkCashInBankAccount(String passwordNumber) throws DaoException {
        return null;
    }

    @Override
    public BigDecimal updateCashInBankAccount(BigDecimal oldCash, BigDecimal howMuchToAdd) throws DaoException {
        return null;
    }

    @Override
    public boolean updatePasswordNumber(String oldPasswordNumber, String newPasswordNumber) throws DaoException {
        return false;
    }
}
