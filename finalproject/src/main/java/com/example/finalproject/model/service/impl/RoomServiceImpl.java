package com.example.finalproject.model.service.impl;

import com.example.finalproject.exception.DaoException;
import com.example.finalproject.exception.ServiceException;
import com.example.finalproject.model.dao.BaseDao;
import com.example.finalproject.model.dao.RoomDao;
import com.example.finalproject.model.dao.impl.RoomDaoImpl;
import com.example.finalproject.model.entity.Room;
import com.example.finalproject.model.service.RoomService;

import java.util.List;

public class RoomServiceImpl implements RoomService {
    private static RoomServiceImpl instance;

    public RoomServiceImpl() {
    }

    public static RoomServiceImpl getInstance(){
        if(instance == null){
            instance = new RoomServiceImpl();
        }
        return instance;
    }

    @Override
    public List<Room> showAllRooms() throws ServiceException {
        RoomDao catalogDao = new RoomDaoImpl();
        try {
            List<Room> catalog = catalogDao.findAll();
            return catalog;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

}
