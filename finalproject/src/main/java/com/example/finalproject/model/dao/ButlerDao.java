package com.example.finalproject.model.dao;

import com.example.finalproject.model.entity.Butler;
import com.example.finalproject.exception.DaoException;

import java.util.Optional;

public interface ButlerDao extends BaseDao<Butler> {
    boolean updateRatingById(Long id, byte newRating) throws DaoException;
    Optional<Butler> findByIdUser(Long id) throws DaoException;
    boolean deleteByLogin(String login) throws DaoException;
}
