package com.example.finalproject.model.service.impl;

import com.example.finalproject.exception.DaoException;
import com.example.finalproject.exception.ServiceException;
import com.example.finalproject.model.dao.ButlerDao;
import com.example.finalproject.model.dao.ClientDao;
import com.example.finalproject.model.dao.impl.ButlerDaoImpl;
import com.example.finalproject.model.dao.impl.ClientDaoImpl;
import com.example.finalproject.model.entity.Butler;
import com.example.finalproject.model.entity.Client;
import com.example.finalproject.model.entity.CustomEntity;
import com.example.finalproject.model.service.ButlerService;
import com.example.finalproject.model.service.ClientService;
import com.example.finalproject.validator.Validator;
import com.example.finalproject.validator.impl.ValidatorImpl;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class ButlerServiceImpl implements ButlerService {
    private static final Logger logger = LogManager.getLogger(ButlerServiceImpl.class);
    Validator validator = new ValidatorImpl();
    private static ButlerServiceImpl instance;
    private final ButlerDao butlerDao = ButlerDaoImpl.getInstance();

    public ButlerServiceImpl() {

    }

    public static ButlerService getInstance() {
        if (instance == null) {
            instance = new ButlerServiceImpl();
        }
        return instance;
    }
    @Override
    public List findAll() throws ServiceException {
        try {
            List<Butler> butlerList = butlerDao.findAll();
            return butlerList;
        } catch (DaoException e) {
            logger.log(Level.ERROR, "Impossible to show all butlers:", e);
            throw new ServiceException("Some problems in method findAll(): " + e);
        }
    }

    @Override
    public Optional findById(Long id) throws ServiceException {
        Optional<Butler> butler;
        try {
            butler = butlerDao.findById(id);
        } catch (DaoException e) {
            throw new ServiceException("Failed to find butler by id " + id, e);
        }
        return butler;
    }

    @Override
    public Optional findByIdUser(Long id) throws ServiceException {
        Optional<Butler> butler;
        try {
            butler = butlerDao.findByIdUser(id);
        } catch (DaoException e) {
            throw new ServiceException("Failed to find client by id " + id, e);
        }
        return butler;
    }

    @Override
    public boolean deleteById(Long id) throws ServiceException {
        return false;
    }

    @Override
    public void deleteByLogin(String login) throws ServiceException {
        try {
            if (!validator.isCorrectLogin(login)){
                throw new ServiceException("Invalid login for deleting " + login);
            }
            boolean result = butlerDao.deleteByLogin(login);
        } catch (DaoException e) {
            throw new ServiceException("Failed to delete butler by login " + login, e);
        }
    }

    @Override
    public CustomEntity insertNewEntity(CustomEntity entity) throws ServiceException {
        Butler butler;
        try {
            butler = butlerDao.insertNewEntity(entity);
        } catch (DaoException e) {
            throw new ServiceException("Failed to create new butler ", e);
        }
        return butler;
    }

    @Override
    public boolean updateRatingById(Long id, byte newRating) throws ServiceException {
        return false;
    }
}
