package com.example.finalproject.model.service;

import com.example.finalproject.exception.ServiceException;
import com.example.finalproject.model.entity.Room;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * The interface Room service.
 */
public interface RoomService {
    /**
     * Show all rooms list.
     *
     * @return the list of rooms
     * @throws ServiceException the service exception
     */
    List<Room> showAllRooms() throws ServiceException;

    /**
     * Insert new entity room.
     *
     * @param room the room's params
     * @return the new room
     * @throws ServiceException the service exception
     */
    Room insertNewEntity(Map<String, String> room) throws ServiceException;

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional room
     * @throws ServiceException the service exception
     */
    Optional<Room> findById(Long id) throws ServiceException;
}
