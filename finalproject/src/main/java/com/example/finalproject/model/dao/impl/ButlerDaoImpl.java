package com.example.finalproject.model.dao.impl;

import com.example.finalproject.model.entity.Butler;
import com.example.finalproject.exception.DaoException;
import com.example.finalproject.model.dao.ButlerDao;
import com.example.finalproject.model.entity.CustomEntity;
import com.example.finalproject.model.entity.User;
import com.example.finalproject.model.mapper.impl.ButlerCreator;
import com.example.finalproject.model.pool.ConnectionPool;
import com.example.finalproject.util.validator.ButlerValidator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.Level;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ButlerDaoImpl implements ButlerDao {
    private static final Logger logger = LogManager.getLogger(ButlerDaoImpl.class);
    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final String SQL_SELECT_ALL_BUTLERS = """
            SELECT butlers.id_user, butlers.id_butler, butlers.rating
            FROM butlers""";
    private static final String SQL_SELECT_BUTLER_BY_ID = """
            SELECT butlers.id_user, butlers.id_butler, butlers.rating
            FROM butlers
            WHERE id_butler =?""";
    private static final String SQL_DELETE_BUTLER_BY_ID = """
            DELETE users, butlers, orders FROM users 
            INNER JOIN butlers ON users.id_user = butlers.id_user 
            INNER JOIN orders ON orders.id_butler = butlers.id_butler WHERE butlers.id_butler = ?""";
    private static final String SQL_INSERT_USER = """
            INSERT INTO users (login, password, role, name, surname, phone_number) VALUES (?,?,?,?,?,?)""";
    private static final String SQL_INSERT_NEW_BUTLER = """
            INSERT INTO butlers (id_user, rating)
            VALUES (?, ?)""";
    private static final String SQL_UPDATE_RATING = """
            UPDATE butlers SET butlers.rating = ? WHERE butlers.id_butler = ?""";
    private ButlerCreator butlerCreator = new ButlerCreator();

    @Override
    public List<Butler> findAll() throws DaoException {
        try (Connection connection = connectionPool.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_BUTLERS)) {
            List<Butler> butlers = new ArrayList<>();
            while (resultSet.next()) {
                Butler butler = butlerCreator.create(resultSet);
                butlers.add(butler);
            }
            logger.log(Level.DEBUG, "findAll method by butlers was completed successfully. " + butlers.size() + " were found");
            return butlers;
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Impossible to find butlers. Database access error:", e);
            throw new DaoException("Impossible to find butlers. Database access error:", e);
        }
    }

    @Override
    public Optional<Butler> findById(Long id) throws DaoException {
        Optional<Butler> butlerOptional = Optional.empty();
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BUTLER_BY_ID)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Butler butler = butlerCreator.create(resultSet);
                butlerOptional = Optional.of(butler);
            }
            logger.log(Level.DEBUG, "findById method from ButlersDaoImpl was completed successfully."
                    + ((butlerOptional.isPresent()) ? " Butler with id " + id + " was found" : " Butler with id " + id + " don't exist"));
            return butlerOptional;
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Impossible to find butler by id. Database access error:", e);
            throw new DaoException("Impossible to find butler by id. Database access error:", e);
        }
    }

    @Override
    public boolean deleteById(Long id) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_DELETE_BUTLER_BY_ID)) {
            statement.setLong(1, id);
            return statement.executeUpdate() != 0;
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Impossible to delete butler with id: " + id, e);
            throw new DaoException("Impossible to delete butler with id: " + id, e);
        }
    }

    @Override
    public Butler insertNewEntity(CustomEntity... entities) throws DaoException {
        if (entities.length != 2) {
            throw new DaoException("Expected 2 argument, got " + entities.length);
        }

        if (!(entities[0] instanceof User)) {
            throw new DaoException("Expected type User, got " + entities[0].getClass());
        }
        if (!(entities[1] instanceof Butler)) {
            throw new DaoException("Expected type Butler, got " + entities[1].getClass());
        }
        User user = (User) entities[0];
        Butler butler = (Butler) entities[1];

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement userStatement = connection.prepareStatement(SQL_INSERT_USER,
                     Statement.RETURN_GENERATED_KEYS);
             PreparedStatement butlerStatement = connection.prepareStatement(SQL_INSERT_NEW_BUTLER,
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
                try (ResultSet resultSet = userStatement.getGeneratedKeys()) {
                    if (resultSet.next()) {
                        long idUser = resultSet.getLong(1);
                        butler.setIdUser(idUser);
                    }


                    butlerStatement.setLong(1, butler.getIdUser());
                    butlerStatement.setByte(2, (byte) 0);
                    butlerStatement.executeUpdate();
                    try (ResultSet butlerResultSet = butlerStatement.getGeneratedKeys()) {
                        if (butlerResultSet.next()) {
                            long idButler = butlerResultSet.getLong(1);
                            butler.setIdButler(idButler);
                        }
                    }
                    connection.commit();
                }
            } catch (SQLException e) {
                connection.rollback();
                logger.log(Level.DEBUG, "failed to create butler", e);
                throw new DaoException("Failed to create butler: " + butler, e);
            } finally {
                connection.setAutoCommit(true);
            }
        } catch (SQLException e) {
            throw new DaoException("Failed to create butler: " + butler, e);
        }
        logger.log(Level.DEBUG, "Butler successfully created: " + butler);
        return butler;
    }

    @Override
    public boolean updateRatingById(Long id, byte newRating) throws DaoException {
        if (!ButlerValidator.isRatingValid(newRating)) {
            logger.log(Level.ERROR, "Invalid rating with id " + id);
            return false;
        }
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_RATING)) {
            statement.setByte(1, newRating);
            statement.setLong(2, id);
            boolean isUpdated = statement.executeUpdate() == 1;
            if (!isUpdated) {
                logger.log(Level.INFO, "Butler's rating didn't update with id " + id);
                return false;
            }
            logger.log(Level.DEBUG, "Result of update rating for butler with id " + id + " is " + newRating);
            return true;
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Impossible to update butler's rating. Database access error:", e);
            throw new DaoException("Impossible to update butler's rating. Database access error:", e);
        }
    }

}
