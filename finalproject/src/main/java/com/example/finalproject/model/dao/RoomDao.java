package com.example.finalproject.model.dao;

import com.example.finalproject.model.entity.Room;
import com.example.finalproject.model.entity.RoomType;
import com.example.finalproject.exception.DaoException;

import java.math.BigDecimal;
import java.util.List;

public interface RoomDao extends BaseDao<Room>{
    boolean updatePrice(BigDecimal newPrice, int roomNumber) throws DaoException;
    List<Room> findAllRoomsInThisFloor (int floor) throws DaoException;
    List<Room> findRoomsByTypeOnTheFloor (int floor, RoomType roomType) throws DaoException;
    int findFloorWhereTheRoom (int numberOfRoom) throws DaoException;
    List<Room> findRoomsWhosePriceLowerThanSpecified (BigDecimal price) throws DaoException;

}
