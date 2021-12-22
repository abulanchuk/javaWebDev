package com.example.finalproject.model.dao.impl;

import com.example.finalproject.entity.Butler;
import com.example.finalproject.exception.DaoException;
import com.example.finalproject.model.dao.ButlerDao;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class ButlerDaoImpl implements ButlerDao {
    static final Logger logger = LogManager.getLogger(ButlerDaoImpl.class);
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
    private static final String SQL_UPDATE_RATING = """
            UPDATE butlers SET rating = ? WHERE id_butler = ?""";

    @Override
    public List<Butler> findAll() throws DaoException {
        return null;
    }

    @Override
    public Optional<Butler> findById(Butler id) throws DaoException {
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Butler user) throws DaoException {
        return false;
    }

    @Override
    public boolean updateRating(byte newRating) throws DaoException {
        return false;
    }
}
