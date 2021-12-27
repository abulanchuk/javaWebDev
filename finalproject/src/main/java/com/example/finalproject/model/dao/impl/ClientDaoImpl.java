package com.example.finalproject.model.dao.impl;

import com.example.finalproject.model.dao.ClientDao;
import com.example.finalproject.model.entity.Butler;
import com.example.finalproject.model.entity.Client;
import com.example.finalproject.exception.DaoException;
import com.example.finalproject.model.mapper.impl.ButlerCreator;
import com.example.finalproject.model.mapper.impl.ClientCreator;
import com.example.finalproject.model.pool.ConnectionPool;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientDaoImpl implements ClientDao {
    static final Logger logger = LogManager.getLogger(ClientDaoImpl.class);
    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final String SQL_SELECT_ALL_CLIENTS = """
            SELECT clients.id_client, clients.id_user, clients.password_number, clients.email, clients.bank_account
            FROM clients""";
    private static final String SQL_SELECT_CLIENT_BY_ID = """
            SELECT clients.id_client, clients.id_user, clients.password_number, clients.email, clients.bank_account
            FROM clients 
            WHERE id_client =?""";
    private static final String SQL_DELETE_CLIENT_BY_ID = """
            DELETE users, clients, orders FROM users 
            INNER JOIN clients ON users.id_user = clients.id_user 
            INNER JOIN orders ON orders.order_id_client = clients.id_client WHERE clients.id_client = ?""";
    private static final String SQL_INSERT_NEW_CLIENT = """
            """;//todo
    private static final String SQL_UPDATE_EMAIL = """
            UPDATE clients SET email = ? WHERE id_client = ?""";
    private static final String SQL_SELECT_BANK_ACCOUNT_BY_ID = """
            SELECT bank_account FROM clients WHERE clients.id_client = ?""";
    private static final String SQL_UPDATE_CASH_IN_BANK_ACCOUNT = """
            UPDATE clients SET bank_account = bank_account + ? WHERE clients.id_client = ?""";
    private static final String SQL_UPDATE_PASSWORD_NUMBER = """
            UPDATE clients SET password_number = ? WHERE password_number = ?""";

    @Override
    public List<Client> findAll() throws DaoException {
        try (Connection connection = connectionPool.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_CLIENTS)) {
            List<Client> clients = new ArrayList<>();
            while (resultSet.next()) {
                Client client = ClientCreator.create(resultSet);
                clients.add(client);
            }
            logger.log(Level.DEBUG, "findAll method by clients was completed successfully. " + clients.size() + " were found");
            return clients;
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Impossible to find clients. Database access error:", e);
            throw new DaoException("Impossible to find clients. Database access error:", e);
        }
    }

    @Override
    public Optional<Client> findById(Long id) throws DaoException { //todo
        Optional<Client> clientOptional = Optional.empty();
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_CLIENT_BY_ID)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Client client = ClientCreator.create(resultSet);
                clientOptional = Optional.of(client);
            }
            logger.log(Level.DEBUG, "findById method from ClientDao was completed successfully."
                    + ((clientOptional.isPresent()) ? " Client with id " + id + " was found" : " Client with id " + id + " don't exist"));
            return clientOptional;
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Impossible to find client by id. Database access error:", e);
            throw new DaoException("Impossible to find client by id. Database access error:", e);
        }
    }

    @Override
    public boolean deleteById(Long id) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_DELETE_CLIENT_BY_ID)) {
            statement.setLong(1, id);
            return statement.executeUpdate() != 0;
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Impossible to delete client with such id: " + id, e);
            throw new DaoException("Impossible to delete client with such id: " + id, e);
        }
    }

    @Override
    public long insertNewEntity(Client entity) throws DaoException {
        return 0; //todo
    }

    @Override
    public boolean updateEmail(Long id, String newEmail) throws DaoException {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_EMAIL)) {
            statement.setString(1, newEmail);
            statement.setLong(2, id);
            boolean isUpdated = statement.executeUpdate() == 1;
            if (!isUpdated) {
                logger.log(Level.INFO, "Client's email didn't update with id " + id);
                return false;
            }
            logger.log(Level.DEBUG, "Result of update email for client with id " + id + " is " + newEmail);
            return true;
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Impossible to update client's email. Database access error:", e);
            throw new DaoException("Impossible to update client's email. Database access error:", e);
        }
    }

    @Override
    public BigDecimal checkCashInBankAccount(long idClient) throws DaoException {
        return null;
    }

    @Override
    public boolean updateCashInBankAccount(Long id, BigDecimal howMuchToAdd) throws DaoException {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_EMAIL)) {
            statement.setBigDecimal(1, howMuchToAdd);
            statement.setLong(2, id);
            boolean isUpdated = statement.executeUpdate() == 1;
            if (!isUpdated) {
                logger.log(Level.INFO, "Client's cash in bank account didn't update with id " + id);
                return false;
            }
            logger.log(Level.DEBUG, "Result of update cash in bank account for client with id " + id + "and new total sum= " ); //todo add total sum
            return true;
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Impossible to update client's cash in bank account. Database access error:", e);
            throw new DaoException("Impossible to update client's cash in bank account. Database access error:", e);
        }
    }

    @Override
    public boolean updatePasswordNumber(String oldPasswordNumber, String newPasswordNumber) throws DaoException {
        return false;
    }
}