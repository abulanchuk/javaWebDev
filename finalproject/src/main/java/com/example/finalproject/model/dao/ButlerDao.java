package com.example.finalproject.model.dao;

import com.example.finalproject.model.entity.Butler;
import com.example.finalproject.exception.DaoException;

public interface ButlerDao extends BaseDao<Butler> {
    boolean updateRatingById(Long id, byte newRating) throws DaoException;
}
