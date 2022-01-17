package com.example.finalproject.model.service;

import com.example.finalproject.exception.ServiceException;
import com.example.finalproject.model.entity.CustomEntity;

import java.util.List;
import java.util.Optional;

public interface ButlerService<T extends CustomEntity> {
    List<T> findAll() throws ServiceException;

    Optional<T> findById(Long id) throws ServiceException;

    Optional<T> findByIdUser(Long id) throws ServiceException;

    boolean deleteById(Long id) throws ServiceException;

    T insertNewEntity(CustomEntity... entities) throws ServiceException;

    boolean updateRatingById(Long id, byte newRating) throws ServiceException;
}
