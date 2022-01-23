package com.example.finalproject.model.service;

import com.example.finalproject.exception.ServiceException;
import com.example.finalproject.model.entity.Room;

import java.util.List;

public interface RoomService {
    List<Room> showAllRooms() throws ServiceException;
}
