package com.example.finalproject.model.dao.impl;

import com.example.finalproject.model.entity.Room;
import com.example.finalproject.model.entity.RoomType;
import com.example.finalproject.exception.DaoException;
import com.example.finalproject.model.dao.RoomDao;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class RoomDaoImpl implements RoomDao {
    static final Logger logger = LogManager.getLogger(RoomDaoImpl.class);
    private static final String SQL_SELECT_ALL_ROOMS = """
    SELECT id_room, price, room_type, floor, room_number FROM rooms""";
    private static final String SQL_SELECT_ROOM_BY_ID = """
    SELECT id_room, price, room_type, floor, room_number FROM rooms WHERE id_room = ?""";
    private static final String SQL_DELETE_DISCOUNT_BY_ID = """
            DELETE FROM rooms WHERE id_room = ?""";
    private static final String SQL_INSERT_ROOM = """
            INSERT INTO rooms (id_room, price, room_type, floor, room_number, id_discount, image_url) VALUES (?,?,?,?,?,?,?)""";
    private static final String SQL_UPDATE_ROOM_PRICE_BY_NUMBER_OF_ROOM = """
            UPDATE discounts SET price = ? WHERE room_number = ?""";
    private static final String SQL_SELECT_ROOM_BY_FLOOR = """
    SELECT id_room, price, room_type, room_number FROM rooms WHERE floor = ?""";
    private static final String SQL_SELECT_ROOM_BY_FLOOR_AND_TYPE = """
    SELECT id_room, price, room_number FROM rooms WHERE floor = ? AND room_type = ?""";
    private static final String SQL_SELECT_FLOOR_BY_NUMBER_OF_ROOM = """
            SELECT floor FROM rooms WHERE room_number = ?""";
    private static final String SQL_SELECT_ALL_ROOMS_BY_PRICE = """
    SELECT id_room, price, room_type, floor, room_number FROM rooms WHERE price < ?""";

    @Override
    public List<Room> findAll() throws DaoException {
        return null;
    }

    @Override
    public Optional<Room> findById(Long id) throws DaoException {
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Room user) throws DaoException {
        return false;
    }

    @Override
    public long insertNewEntity(Room entity) throws DaoException {
        return 0;
    }

    @Override
    public boolean updatePrice(String newPrice) throws DaoException {
        return false;
    }

    @Override
    public List<Room> findAllRoomsInThisFloor(int floor) throws DaoException {
        return null;
    }

    @Override
    public List<Room> findRoomsByTypeOnTheFloor(int floor, RoomType roomType) throws DaoException {
        return null;
    }

    @Override
    public int findFloorWhereTheRoom(int numberOfRoom) throws DaoException {
        return 0;
    }

    @Override
    public List<Room> findRoomsWhosePriceLowerThanSpecified(BigDecimal price) throws DaoException {
        return null;
    }

}
