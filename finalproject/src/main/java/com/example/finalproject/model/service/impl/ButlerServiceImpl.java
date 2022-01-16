package com.example.finalproject.model.service.impl;

import com.example.finalproject.exception.ServiceException;
import com.example.finalproject.model.dao.ButlerDao;
import com.example.finalproject.model.dao.ClientDao;
import com.example.finalproject.model.dao.impl.ButlerDaoImpl;
import com.example.finalproject.model.dao.impl.ClientDaoImpl;
import com.example.finalproject.model.entity.CustomEntity;
import com.example.finalproject.model.service.ButlerService;
import com.example.finalproject.model.service.ClientService;

import java.util.List;
import java.util.Optional;

public class ButlerServiceImpl implements ButlerService {
    private static ButlerServiceImpl instance;
    private final ButlerDao butlerDao = ButlerDaoImpl.getInstance();

    private ButlerServiceImpl() {
    }

    public static ButlerService getInstance() {
        if (instance == null) {
            instance = new ButlerServiceImpl();
        }
        return instance;
    }
    @Override
    public List findAll() throws ServiceException {
        return null;
    }

    @Override
    public Optional findById(Long id) throws ServiceException {
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) throws ServiceException {
        return false;
    }

    @Override
    public CustomEntity insertNewEntity(CustomEntity... entities) throws ServiceException {
        return null;
    }

    @Override
    public boolean updateRatingById(Long id, byte newRating) throws ServiceException {
        return false;
    }
}
