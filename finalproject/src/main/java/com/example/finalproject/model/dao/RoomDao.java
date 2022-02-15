package com.example.finalproject.model.dao;

import com.example.finalproject.model.entity.Room;
import com.example.finalproject.model.entity.RoomType;
import com.example.finalproject.exception.DaoException;

import java.math.BigDecimal;
import java.util.List;

/**
 * The interface Room dao.
 */
public interface RoomDao extends BaseDao<Room>{
    /**
     * Update price boolean.
     *
     * @param newPrice   the new price
     * @param roomNumber the room number
     * @return the successful result or not (boolean)
     * @throws DaoException the dao exception
     */
    boolean updatePrice(BigDecimal newPrice, int roomNumber) throws DaoException;

    /**
     * Find all rooms in this floor list.
     *
     * @param floor the floor
     * @return the list with all rooms
     * @throws DaoException the dao exception
     */
    List<Room> findAllRoomsInThisFloor (int floor) throws DaoException;

    /**
     * Find rooms by type on the floor list.
     *
     * @param floor    the floor
     * @param roomType the room type
     * @return the list of rooms by type and selected floor
     * @throws DaoException the dao exception
     */
    List<Room> findRoomsByTypeOnTheFloor (int floor, RoomType roomType) throws DaoException;

    /**
     * Find floor where the room int.
     *
     * @param numberOfRoom the number of room
     * @return the floor where the room staying
     * @throws DaoException the dao exception
     */
    int findFloorWhereTheRoom (int numberOfRoom) throws DaoException;

    /**
     * Find rooms whose price lower than specified list.
     *
     * @param price the price
     * @return list of rooms whose price is lower than indicated
     * @throws DaoException the dao exception
     */
    List<Room> findRoomsWhosePriceLowerThanSpecified (BigDecimal price) throws DaoException;

}
