package com.example.finalproject.model.dao.impl;

import com.example.finalproject.model.dao.ClientDao;
import com.example.finalproject.model.entity.Client;
import com.example.finalproject.exception.DaoException;
import com.example.finalproject.model.entity.CustomEntity;
import com.example.finalproject.model.entity.User;
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
    private static final Logger logger = LogManager.getLogger(ClientDaoImpl.class);
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
    private static final String SQL_INSERT_USER = """
            INSERT INTO users (login, password, role, name, surname, phone_number) VALUES (?,?,?,?,?,?)""";
    private static final String SQL_INSERT_NEW_CLIENT = """
            INSERT INTO clients (password_number, email, bank_account, id_user) VALUES (?,?,?,?)""";
    private static final String SQL_UPDATE_EMAIL = """
            UPDATE clients SET email = ? WHERE id_client = ?""";
    private static final String SQL_UPDATE_CASH_IN_BANK_ACCOUNT = """
            UPDATE clients SET bank_account = bank_account + ? WHERE clients.id_client = ?""";
    private static final String SQL_UPDATE_PASSPORT_NUMBER = """
            UPDATE clients SET password_number = ? WHERE password_number = ?""";
    private ClientCreator clientCreator = new ClientCreator();

    @Override
    public List<Client> findAll() throws DaoException {
        try (Connection connection = connectionPool.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_CLIENTS)) {
            List<Client> clients = new ArrayList<>();
            while (resultSet.next()) {
                Client client = clientCreator.create(resultSet);
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
    public Optional<Client> findById(Long id) throws DaoException {
        Optional<Client> clientOptional = Optional.empty();
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_CLIENT_BY_ID)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Client client = clientCreator.create(resultSet);
                clientOptional = Optional.of(client);
            }
            logger.log(Level.DEBUG, "findById method from ClientDaoImpl was completed successfully."
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
    public Client insertNewEntity(CustomEntity... entities) throws DaoException {
        if (entities.length != 2) {
            throw new DaoException("Expected 2 argument, got " + entities.length);
        }

        if (!(entities[0] instanceof User)) {
            throw new DaoException("Expected type User, got " + entities[0].getClass());
        }
        if (!(entities[1] instanceof Client)) {
            throw new DaoException("Expected type Client, got " + entities[1].getClass());
        }
        User user = (User) entities[0];
        Client client = (Client) entities[1];

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement userStatement = connection.prepareStatement(SQL_INSERT_USER,
                     Statement.RETURN_GENERATED_KEYS);
             PreparedStatement clientStatement = connection.prepareStatement(SQL_INSERT_NEW_CLIENT,
                     Statement.RETURN_GENERATED_KEYS)) {

            try {
                connection.setAutoCommit(false);
                userStatement.setString(1, user.getLogin());
                userStatement.setString(2, user.getPassword());
                userStatement.setString(3, user.getRole().toString());
                userStatement.setString(4, user.getName());
                userStatement.setString(5, user.getSurname());
                userStatement.setString(6, user.getPhoneNumber());

                userStatement.executeUpdate();
                try (ResultSet userResultSet = userStatement.getGeneratedKeys()) {
                    if (userResultSet.next()) {
                        long idUser = userResultSet.getLong(1);
                        client.setIdUser(idUser);
                    }

                    clientStatement.setString(1, client.getPasswordNumber());
                    clientStatement.setString(2, client.getEmail());
                    clientStatement.setBigDecimal(3, client.getBankAccount());
                    clientStatement.setLong(4, client.getIdUser());
                    clientStatement.executeUpdate();

                    try (ResultSet clientResultSet = clientStatement.getGeneratedKeys()) {
                        if (clientResultSet.next()) {
                            long idClient = clientResultSet.getLong(1);
                            client.setIdClient(idClient);
                        }
                    }
                    connection.commit();
                }
            } catch (SQLException e) {
                connection.rollback();
                logger.log(Level.DEBUG, "Failed to create client",e);
                throw new DaoException("Failed to create client: " + client, e);
            } finally {
                connection.setAutoCommit(true);
            }
        } catch (SQLException e) {
            throw new DaoException("Failed to create client: " + client, e);
        }
        logger.log(Level.DEBUG, "Client successfully created: " + client);
        return client;
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
    public boolean updateCashInBankAccount(Long id, BigDecimal howMuchToAdd) throws DaoException {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_CASH_IN_BANK_ACCOUNT)) {
            statement.setBigDecimal(1, howMuchToAdd);
            statement.setLong(2, id);
            boolean isUpdated = statement.executeUpdate() == 1;
            if (!isUpdated) {
                logger.log(Level.INFO, "Client's cash in bank account didn't update with id " + id);
                return false;
            }
            logger.log(Level.DEBUG, "Add "+ howMuchToAdd +" money in bank account for client with id " + id);
            return true;
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Impossible to update client's cash in bank account. Database access error:", e);
            throw new DaoException("Impossible to update client's cash in bank account. Database access error:", e);
        }
    }

    @Override
    public boolean updatePassportNumber(String oldPassportNumber, String newPassportNumber) throws DaoException {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_PASSPORT_NUMBER)) {
            statement.setString(1, newPassportNumber);
            statement.setString(2, oldPassportNumber);
            boolean isUpdated = statement.executeUpdate() == 1;
            if (!isUpdated) {
                logger.log(Level.INFO, "Client's passport number didn't update");
                return false;
            }
            logger.log(Level.DEBUG, "Result of update passport number is success");
            return true;
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Impossible to update client's passport number. Database access error:", e);
            throw new DaoException("Impossible to update client's passport number. Database access error:", e);
        }
    }
}
