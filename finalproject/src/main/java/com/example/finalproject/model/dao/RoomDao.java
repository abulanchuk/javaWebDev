package com.example.finalproject.model.dao;

import com.example.finalproject.entity.Room;
import com.example.finalproject.entity.RoomType;
import com.example.finalproject.exception.DaoException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface RoomDao extends BaseDao<Room>{
    boolean updatePrice(String newPrice) throws DaoException;
    List<Room> findAllRoomsInThisFloor (int floor) throws DaoException;
    List<Room> findRoomsByTypeOnTheFloor (int floor, RoomType roomType) throws DaoException;
    int findFloorWhereTheRoom (int numberOfRoom) throws DaoException;
    List<Room> findRoomsWhosePriceLowerThanSpecified (BigDecimal price) throws DaoException;
}
