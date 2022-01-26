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
            throw new ServiceException(e);
        }
    }

    @Override
    public Room insertNewEntity(Map<String, String> room) throws ServiceException {
        boolean resultFromValidate = validator.isPriceOfRoomValid(room.get(QueryNamedArguments.PRICE)) &&
                validator.isRoomTypeValid(room.get(QueryNamedArguments.ROOM_TYPE)) &&
                validator.isFloorValid(room.get(QueryNamedArguments.FLOOR)) &&
                validator.isRoomNumberValid(room.get(QueryNamedArguments.ROOM_NUMBER)) &&
                validator.isIdDiscountValid(room.get(QueryNamedArguments.ID_DISCOUNT));
        if (resultFromValidate) {
            BigDecimal priceRoom = new BigDecimal(room.get(QueryNamedArguments.PRICE));
            RoomType roomType = RoomType.valueOf(room.get(QueryNamedArguments.ROOM_TYPE.toUpperCase(Locale.ROOT)));
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
            Room newRoom = new Room(priceRoom, roomType, floor, roomNumber, idDiscount, imagePath);
            try {
                roomDao.insertNewEntity(newRoom);
            } catch (DaoException e) {
                logger.log(Level.ERROR, "Impossible to add new room to database:", e);
                throw new ServiceException("Impossible to add new room to database", e);
            }
        }
        return null;
    }

}
