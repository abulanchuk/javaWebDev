package com.example.finalproject.model.dao.impl;

import com.example.finalproject.model.entity.Butler;
import com.example.finalproject.exception.DaoException;
import com.example.finalproject.model.dao.ButlerDao;
import com.example.finalproject.model.mapper.impl.ButlerCreator;
import com.example.finalproject.model.pool.ConnectionPool;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.Level;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ButlerDaoImpl implements ButlerDao {
    static final Logger logger = LogManager.getLogger(ButlerDaoImpl.class);
    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final String SQL_SELECT_ALL_BUTLERS = """
            SELECT butlers.id_butler, users.name, users.surname, users.phone_number, butlers.rating
            FROM butlers
            INNER JOIN users ON users.id_user = butlers.id_user""";
    private static final String SQL_SELECT_BUTLER_BY_ID = """
            SELECT butlers.id_butler, users.name, users.surname, users.phone_number, butlers.rating
            FROM butlers
            INNER JOIN users ON users.id_user = butlers.id_user WHERE id_butler =?""";
    private static final String SQL_DELETE_BUTLER_BY_ID = """
            DELETE users, butlers, orders FROM users 
            INNER JOIN butlers ON users.id_user = butlers.id_user 
            INNER JOIN orders ON orders.id_butler = butlers.id_butler WHERE butlers.id_butler = ?""";
    private static final String SQL_INSERT_NEW_BUTLER = """
            INSERT INTO butlers (id_butler, id_user, rating) """;//todo
    private static final String SQL_UPDATE_RATING = """
            UPDATE butlers SET rating = ? WHERE id_butler = ?""";

    @Override
    public List<Butler> findAll() throws DaoException {
        try (Connection connection = connectionPool.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_BUTLERS)) {
            List<Butler> butlers = new ArrayList<>();
            while (resultSet.next()) {
                Butler user = ButlerCreator.create(resultSet);
                butlers.add(user);
            }
            logger.log(Level.DEBUG, "findAll (Butlers) method was completed successfully. " + butlers.size() + " were found");
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
                Butler butler = ButlerCreator.create(resultSet);
                butlerOptional = Optional.of(butler);
            }
            logger.log(Level.DEBUG, "findById (Butler) method was completed successfully."
                    + ((butlerOptional.isPresent()) ? " Butler with id " + id + " was found" : " Butler with id " + id + " don't exist"));
            return butlerOptional;
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Impossible to find butler by id. Database access error:", e);
            throw new DaoException("Impossible to find butler by id. Database access error:", e);
        }
    }

    @Override
    public boolean deleteById(Butler user) throws DaoException {
        return false;
    }

    @Override
    public long insertNewEntity(Butler entity) throws DaoException {
        return 0;
    }

    @Override
    public boolean updateRating(byte newRating) throws DaoException {
        return false;
    }

}
