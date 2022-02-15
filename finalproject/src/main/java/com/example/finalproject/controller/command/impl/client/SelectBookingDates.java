package com.example.finalproject.controller.command.impl.client;

import com.example.finalproject.controller.QueryNamedArguments;
import com.example.finalproject.controller.command.Command;
import com.example.finalproject.controller.command.PagePath;
import com.example.finalproject.controller.command.Router;
import com.example.finalproject.exception.ServiceException;
import com.example.finalproject.model.entity.Room;
import com.example.finalproject.model.service.RoomService;
import com.example.finalproject.model.service.impl.RoomServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Optional;

public class SelectBookingDates implements Command {
    private static final Logger logger = LogManager.getLogger(SelectBookingDates.class);
    private RoomService roomService = new RoomServiceImpl();

    @Override
    public Router execute(HttpServletRequest request) {
        long roomId = Long.valueOf(request.getParameter(QueryNamedArguments.ROOM_ID));
        try {
            Optional<Room> room = roomService.findById(roomId);
            if (room.isPresent()) {
                request.setAttribute(QueryNamedArguments.ROOM, room.get());
            }
            else {
                //TODO
            }
        } catch (ServiceException e) {
            logger.log(Level.ERROR, "Failed to select room by id:" + roomId, e);
            return new Router(PagePath.ERROR_500_PAGE, Router.RouterType.FORWARD);
        }

        return new Router(PagePath.BASKET, Router.RouterType.FORWARD);
    }
}
