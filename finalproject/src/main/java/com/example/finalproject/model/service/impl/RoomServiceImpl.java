package com.example.finalproject.model.service.impl;

import com.example.finalproject.controller.QueryNamedArguments;
import com.example.finalproject.exception.DaoException;
import com.example.finalproject.exception.ServiceException;
import com.example.finalproject.model.dao.RoomDao;
import com.example.finalproject.model.dao.impl.RoomDaoImpl;
import com.example.finalproject.model.entity.Room;
import com.example.finalproject.model.entity.RoomType;
import com.example.finalproject.model.service.RoomService;
import com.example.finalproject.validator.Validator;
import com.example.finalproject.validator.impl.ValidatorImpl;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

public class RoomServiceImpl implements RoomService {
    private static final Logger logger = LogManager.getLogger(RoomServiceImpl.class);
    RoomDao roomDao = new RoomDaoImpl();
    Validator validator = new ValidatorImpl();
    private static final String pathToPhoto = "/images/no_photo.png";
    private static RoomServiceImpl instance;

    public RoomServiceImpl() {
    }

    public static RoomServiceImpl getInstance() {
        if (instance == null) {
            instance = new RoomServiceImpl();
        }
        return instance;
    }

    @Override
    public List<Room> showAllRooms() throws ServiceException {
        try {
            List<Room> catalog = roomDao.findAll();
            return catalog;
        } catch (DaoException e) {
            logger.log(Level.ERROR, "Impossible to show all rooms:", e);
            throw new ServiceException("Some problems in method showAllRooms(): " + e);
        }
    }

    @Override
    public Room insertNewEntity(Map<String, String> room) throws ServiceException {
        Room newRoom = null;
        boolean resultFromValidate = validator.isPriceOfRoomValid(room.get(QueryNamedArguments.PRICE)) &&
                validator.isRoomTypeValid(room.get(QueryNamedArguments.ROOM_TYPE)) &&
                validator.isFloorValid(room.get(QueryNamedArguments.FLOOR)) &&
                validator.isRoomNumberValid(room.get(QueryNamedArguments.ROOM_NUMBER)) &&
                validator.isIdDiscountValid(room.get(QueryNamedArguments.ID_DISCOUNT));
        if (resultFromValidate) {
            BigDecimal priceRoom = new BigDecimal(room.get(QueryNamedArguments.PRICE));
            String roomTypeValue = room.get(QueryNamedArguments.ROOM_TYPE.toLowerCase(Locale.ROOT));
            RoomType roomType = RoomType.valueOf(roomTypeValue.toUpperCase(Locale.ROOT));
            int floor = Integer.parseInt(room.get(QueryNamedArguments.FLOOR));
            int roomNumber = Integer.parseInt(room.get(QueryNamedArguments.ROOM_NUMBER));
            long idDiscount = Long.valueOf(room.get(QueryNamedArguments.ID_DISCOUNT));

            String imagePath = room.get(QueryNamedArguments.IMAGE_URL);
            if (imagePath == null) {
                throw new ServiceException("Input map contains no key " + QueryNamedArguments.IMAGE_URL);
            }

            File file = new File(imagePath);
            if (!file.exists()) {
                imagePath = pathToPhoto;
            }
            newRoom = new Room(priceRoom, roomType, floor, roomNumber, idDiscount, imagePath);
            try {
                roomDao.insertNewEntity(newRoom);
            } catch (DaoException e) {
                logger.log(Level.ERROR, "Impossible to add new room to database:", e);
                throw new ServiceException("Impossible to add new room to database", e);
            }
        }
        return newRoom;
    }

    @Override
    public Optional<Room> findById(Long id) throws ServiceException {
        Optional<Room> room;
        try {
            room = roomDao.findById(id);
        } catch (DaoException e) {
            logger.log(Level.ERROR, "Impossible to find room from database:", e);
            throw new ServiceException("Impossible to find room from database", e);
        }
        return room;
    }

}
