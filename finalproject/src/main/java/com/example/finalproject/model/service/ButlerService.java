package com.example.finalproject.model.service;

import com.example.finalproject.exception.ServiceException;
import com.example.finalproject.model.entity.Butler;
import com.example.finalproject.model.entity.CustomEntity;

import java.util.List;
import java.util.Optional;

/**
 * The interface Butler service.
 *
 * @param <T> the type parameter
 */
public interface ButlerService<T extends CustomEntity> {
    /**
     * Find all list.
     *
     * @return the list of butlers
     * @throws ServiceException the service exception
     */
    List<T> findAll() throws ServiceException;

    /**
     * Find by id optional.
     *
     * @param id the butler's id
     * @return the optional butler
     * @throws ServiceException the service exception
     */
    Optional<T> findById(Long id) throws ServiceException;

    /**
     * Find by id user optional.
     *
     * @param id the user's id
     * @return the optional butler
     * @throws ServiceException the service exception
     */
    Optional<T> findByIdUser(Long id) throws ServiceException;

    /**
     * Delete by id boolean.
     *
     * @param id the id
     * @return the successful result or not (boolean)
     * @throws ServiceException the service exception
     */
    boolean deleteById(Long id) throws ServiceException;

    /**
     * Delete by login.
     *
     * @param login the butler's login
     * @throws ServiceException the service exception
     */
    void deleteByLogin(String login) throws ServiceException;

    /**
     * Insert new entity t.
     *
     * @param entity the entity
     * @return the created butler
     * @throws ServiceException the service exception
     */
    T insertNewEntity(CustomEntity entity) throws ServiceException;

    /**
     * Update rating by id boolean.
     *
     * @param id        the butler's id
     * @param newRating the new rating
     * @return the successful result or not (boolean)
     * @throws ServiceException the service exception
     */
    boolean updateRatingById(Long id, byte newRating) throws ServiceException;
}
