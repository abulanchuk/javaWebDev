package com.example.finalproject.model.service;

import com.example.finalproject.exception.ServiceException;
import com.example.finalproject.model.entity.Room;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface RoomService {
    List<Room> showAllRooms() throws ServiceException;

    Room insertNewEntity(Map<String, String> room) throws ServiceException;
    Optional<Room> findById(Long id) throws ServiceException;
}
