package com.example.finalproject.model.dao.impl;

import com.example.finalproject.model.dao.ClientDao;
import com.example.finalproject.model.entity.Client;
import com.example.finalproject.exception.DaoException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class ClientDaoImpl implements ClientDao {
    static final Logger logger = LogManager.getLogger(ClientDaoImpl.class);
    private static final String SQL_SELECT_ALL_CLIENTS = """
            SELECT clients.id_client, users.name, users.surname, users.phone_number, clients.password_number, clients.email, clients.bank_account,
            FROM clients INNER JOIN users ON users.id_user = clients.id_user""";
    private static final String SQL_SELECT_CLIENT_BY_ID = """
            SELECT clients.id_client, users.name, users.surname, users.phone_number, clients.password_number, clients.email, clients.bank_account
            FROM clients 
            INNER JOIN users ON users.id_user = clients.id_user WHERE id_client =?""";
    private static final String SQL_DELETE_CLIENT_BY_ID = """
           DELETE users, clients, orders FROM users 
           INNER JOIN clients ON users.id_user = clients.id_user 
           INNER JOIN orders ON orders.order_id_client = clients.id_client WHERE clients.id_client = ?""";
    private static final String SQL_INSERT_NEW_BUTLER = """
            """;//todo
    private static final String SQL_UPDATE_EMAIL = """
            UPDATE clients SET email = ? WHERE email = ?""";
    private static final String SQL_SELECT_BANK_ACCOUNT_BY_ID = """
            SELECT bank_account FROM clients WHERE clients.id_client = ?""";
    private static final String SQL_UPDATE_CASH_IN_BANK_ACCOUNT = """
            UPDATE clients SET bank_account = bank_account + ? WHERE bank_account = ?""";
    private static final String SQL_UPDATE_PASSWORD_NUMBER = """
            UPDATE clients SET password_number = ? WHERE password_number = ?""";

    @Override
    public List<Client> findAll() throws DaoException {
        return null;
    }

    @Override
    public Optional<Client> findById(Client id) throws DaoException {
        return null;
    }

    @Override
    public boolean deleteById(Client user) throws DaoException {
        return false;
    }

    @Override
    public long insertNewEntity(Client entity) throws DaoException {
        return 0;
    }

    @Override
    public boolean updateEmail(String oldEmail, String newEmail) throws DaoException {
        return false;
    }

    @Override
    public BigDecimal checkCashInBankAccount(long idClient) throws DaoException {
        return null;
    }

    @Override
    public BigDecimal updateCashInBankAccount(BigDecimal howMuchToAdd) throws DaoException {
        return null;
    }

    @Override
    public boolean updatePasswordNumber(String oldPasswordNumber, String newPasswordNumber) throws DaoException {
        return false;
    }
}
