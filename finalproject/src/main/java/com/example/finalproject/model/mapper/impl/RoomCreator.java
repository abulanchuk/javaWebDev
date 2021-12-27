package com.example.finalproject.model.mapper.impl;

import com.example.finalproject.model.entity.Room;
import com.example.finalproject.model.entity.RoomType;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.example.finalproject.model.mapper.ColumnTableName.*;

public class RoomCreator {
    public RoomCreator() {
    }
    static Room create (ResultSet resultSet) throws SQLException {
        Room room = new Room();
        room.setIdRoom(resultSet.getLong(ROOMS_ID_ROOM));
        room.setPrice(resultSet.getBigDecimal(ROOMS_PRICE));
        room.setRoomType(RoomType.valueOf(resultSet.getString(ROOMS_ROOM_TYPE).trim().toUpperCase()));
        room.setFloor(resultSet.getInt(ROOMS_FLOOR));
        room.setRoomNumber(resultSet.getInt(ROOMS_ROOM_NUMBER));
        room.setImageUrl(resultSet.getString(ROOMS_IMAGE_URL));
        return room;
    }
}
