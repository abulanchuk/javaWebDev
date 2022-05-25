package com.example.finalproject.model.dao.impl;

import com.example.finalproject.model.entity.CustomEntity;
import com.example.finalproject.model.entity.Room;
import com.example.finalproject.model.entity.RoomType;
import com.example.finalproject.exception.DaoException;
import com.example.finalproject.model.dao.RoomDao;
import com.example.finalproject.model.mapper.ColumnTableName;
import com.example.finalproject.model.mapper.impl.RoomCreator;
import com.example.finalproject.model.pool.ConnectionPool;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RoomDaoImpl implements RoomDao {
    private static final Logger logger = LogManager.getLogger(RoomDaoImpl.class);
    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final String SQL_SELECT_ALL_ROOMS = "SELECT id_room, price, room_type, floor, room_number, image_url FROM rooms";
    private static final String SQL_SELECT_ROOM_BY_ID = "SELECT id_room, price, room_type, floor, room_number, image_url FROM rooms WHERE id_room = ?";
    private static final String SQL_DELETE_ROOM_BY_ID = " DELETE FROM rooms WHERE id_room = ?";
    private static final String SQL_INSERT_ROOM = "INSERT INTO rooms (price, room_type, floor, room_number, id_discount, image_url) VALUES (?,?,?,?,?,?)";
    private static final String SQL_UPDATE_ROOM_PRICE_BY_NUMBER_OF_ROOM = "UPDATE rooms SET price = ? WHERE room_number = ?";
    private static final String SQL_SELECT_ROOM_BY_FLOOR = "SELECT id_room, price,floor, room_type, room_number, image_url FROM rooms WHERE floor = ?";
    private static final String SQL_SELECT_ROOM_BY_FLOOR_AND_TYPE = "SELECT id_room, price,floor, room_type, room_number,id_discount, image_url FROM rooms WHERE floor = ? AND room_type = ?";
    private static final String SQL_SELECT_FLOOR_BY_NUMBER_OF_ROOM = "SELECT floor FROM rooms WHERE room_number = ?";
    private static final String SQL_SELECT_ALL_ROOMS_BY_PRICE = "SELECT id_room, price, room_type, floor, room_number, id_discount, image_url FROM rooms WHERE price < ?";
    private RoomCreator roomCreator = new RoomCreator();

    @Override
    public List<Room> findAll() throws DaoException {
        try (Connection connection = connectionPool.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_ROOMS)) {
            List<Room> rooms = new ArrayList<>();
            while (resultSet.next()) {
                Room room = roomCreator.create(resultSet);
                rooms.add(room);
            }
            logger.log(Level.DEBUG, "findAll method by rooms was completed successfully. " + rooms.size() + " were found");
            return rooms;
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Impossible to find rooms. Database access error:", e);
            throw new DaoException("Impossible to find rooms. Database access error:", e);
        }
    }

    @Override
    public Optional<Room> findById(Long id) throws DaoException {
        Optional<Room> roomOptional = Optional.empty();
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ROOM_BY_ID)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Room room = roomCreator.create(resultSet);
                    roomOptional = Optional.of(room);
                }
            }
            logger.log(Level.DEBUG, "findById method from RoomDaoImpl was completed successfully."
                    + ((roomOptional.isPresent()) ? " Room with id " + id + " was found" : " Room with id " + id + " don't exist"));
            return roomOptional;
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Impossible to find room by id. Database access error:", e);
            throw new DaoException("Impossible to find room by id. Database access error:", e);
        }
    }

    @Override
    public boolean deleteById(Long id) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_DELETE_ROOM_BY_ID)) {
            statement.setLong(1, id);
            return statement.executeUpdate() != 0;
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Impossible to delete room with such id: " + id, e);
            throw new DaoException("Impossible to delete room with such id: " + id, e);
        }
    }

    @Override
    public Room insertNewEntity(CustomEntity entity) throws DaoException {
        if (!(entity instanceof Room)) {
            logger.log(Level.ERROR, "Expected type Room, got " + entity.getClass());
            throw new DaoException("Expected type Room, got " + entity.getClass());
        }
        Room room = (Room) entity;
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_INSERT_ROOM)) {

            statement.setBigDecimal(1, room.getPrice());
            statement.setString(2, room.getRoomType().toString());
            statement.setInt(3, room.getFloor());
            statement.setInt(4, room.getRoomNumber());
            statement.setLong(5, room.getIdDiscount());
            statement.setString(6, room.getImageUrl());
            statement.executeUpdate();

        } catch (SQLException e) {
            logger.log(Level.DEBUG, "Failed to create room", e);
            throw new DaoException("Failed to create room: ", e);
        }
        return room;
    }

    @Override
    public boolean updatePrice(BigDecimal newPrice, int roomNumber) throws DaoException {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_ROOM_PRICE_BY_NUMBER_OF_ROOM)) {
            statement.setBigDecimal(1, newPrice);
            statement.setInt(2, roomNumber);
            boolean isUpdated = statement.executeUpdate() == 1;
            if (!isUpdated) {
                logger.log(Level.INFO, "Price of room didn't update with room's number " + roomNumber);
                return false;
            }
            logger.log(Level.DEBUG, "Price of room updated with room's number " + roomNumber + "and new price is " + newPrice);
            return true;
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Impossible to update price of room. Database access error:", e);
            throw new DaoException("Impossible to update price of room. Database access error:", e);
        }
    }

    @Override
    public List<Room> findAllRoomsInThisFloor(int floor) throws DaoException {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ROOM_BY_FLOOR)) {
            statement.setInt(1, floor);
            List<Room> rooms = new ArrayList<>();
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Room room = roomCreator.create(resultSet);
                    rooms.add(room);
                }
            }
            logger.log(Level.DEBUG, "findAllRoomsInThisFloor method by rooms was completed successfully. " + rooms.size() + " were found");
            return rooms;
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Impossible to find rooms by floor. Database access error:", e);
            throw new DaoException("Impossible to find rooms by floor. Database access error:", e);
        }
    }

    @Override
    public List<Room> findRoomsByTypeOnTheFloor(int floor, RoomType roomType) throws DaoException {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ROOM_BY_FLOOR_AND_TYPE)) {
            statement.setInt(1, floor);
            statement.setString(2, roomType.name());
            ResultSet resultSet = statement.executeQuery();
            List<Room> rooms = new ArrayList<>();
            while (resultSet.next()) {
                Room room = roomCreator.create(resultSet);
                rooms.add(room);
            }
            logger.log(Level.DEBUG, "findRoomsByTypeOnTheFloor method by rooms was completed successfully. " + rooms.size() + " were found");
            return rooms;
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Impossible to find rooms by floor and type. Database access error:", e);
            throw new DaoException("Impossible to find rooms by floor and type. Database access error:", e);
        }
    }

    @Override
    public int findFloorWhereTheRoom(int numberOfRoom) throws DaoException {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_FLOOR_BY_NUMBER_OF_ROOM)) {
            statement.setInt(1, numberOfRoom);
            try (ResultSet resultSet = statement.executeQuery()) {
                boolean hasNext = resultSet.next();
                if (!hasNext) {
                    logger.log(Level.ERROR, "Impossible to find rooms with number " + numberOfRoom);
                    throw new DaoException("Impossible to find rooms with number " + numberOfRoom);
                }
                return resultSet.getInt(ColumnTableName.ROOMS_FLOOR);
            }
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Impossible to find rooms by floor and type. Database access error:", e);
            throw new DaoException("Impossible to find rooms by floor and type. Database access error:", e);
        }
    }

    @Override
    public List<Room> findRoomsWhosePriceLowerThanSpecified(BigDecimal price) throws DaoException {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL_ROOMS_BY_PRICE)) {
            statement.setBigDecimal(1, price);
            List<Room> rooms = new ArrayList<>();
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Room room = roomCreator.create(resultSet);
                    rooms.add(room);
                }
            }
            logger.log(Level.DEBUG, "findRoomsWhosePriceLowerThanSpecified method was completed successfully. \" + rooms.size() + \" were found");
            return rooms;
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Impossible to find rooms with price less than " + price + ". Database access error: ", e);
            throw new DaoException("Impossible to find rooms with price less than " + price + ". Database access error: ", e);
        }
    }
}
