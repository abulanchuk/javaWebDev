package com.example.finalproject.model.dao;

import com.example.finalproject.model.entity.Butler;
import com.example.finalproject.exception.DaoException;

import java.util.Optional;

/**
 * The interface Butler dao.
 */
public interface ButlerDao extends BaseDao<Butler> {
    /**
     * Update rating by id boolean.
     *
     * @param id        the butler's personal id
     * @param newRating the new rating
     * @return the successful result or not (boolean)
     * @throws DaoException the dao exception
     */
    boolean updateRatingById(Long id, byte newRating) throws DaoException;

    /**
     * Find by id user optional.
     *
     * @param id the butler's personal id
     * @return the optional butler
     * @throws DaoException the dao exception
     */
    Optional<Butler> findByIdUser(Long id) throws DaoException;

    /**
     * Delete by login boolean.
     *
     * @param login the butler's login for deleting
     * @return the successful result or not (boolean)
     * @throws DaoException the dao exception
     */
    boolean deleteByLogin(String login) throws DaoException;
}
