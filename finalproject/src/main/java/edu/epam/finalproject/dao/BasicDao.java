package edu.epam.finalproject.dao;

import edu.epam.finalproject.entity.User;
import edu.epam.finalproject.exception.DaoException;

import java.util.List;

public interface BasicDao < T extends User>{
    public abstract List<T> findAll() throws DaoException;
    T findById(T id) throws DaoException;
    void deleteById(T id) throws DaoException;
    T update(T t) throws DaoException;
}
