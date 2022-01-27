package com.example.finalproject.controller.command.impl.owner;

import com.example.finalproject.controller.ErrorType;
import com.example.finalproject.controller.QueryNamedArguments;
import com.example.finalproject.controller.command.Command;
import com.example.finalproject.controller.command.PagePath;
import com.example.finalproject.controller.command.Router;
import com.example.finalproject.exception.ServiceException;
import com.example.finalproject.model.entity.Room;
import com.example.finalproject.model.service.RoomService;
import com.example.finalproject.model.service.impl.RoomServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class AddNewRoomCommand implements Command {
    private static final Logger logger = LogManager.getLogger(AddNewRoomCommand.class);
    RoomService roomService = new RoomServiceImpl();
    @Override
    public Router execute(HttpServletRequest request) {
        Map<String,String> newRoom = new HashMap<>();
        newRoom.put(QueryNamedArguments.PRICE, request.getParameter(QueryNamedArguments.PRICE));
        newRoom.put(QueryNamedArguments.ROOM_TYPE, request.getParameter(QueryNamedArguments.ROOM_TYPE));
        newRoom.put(QueryNamedArguments.FLOOR, request.getParameter(QueryNamedArguments.FLOOR));
        newRoom.put(QueryNamedArguments.ROOM_NUMBER, request.getParameter(QueryNamedArguments.ROOM_NUMBER));
        newRoom.put(QueryNamedArguments.ID_DISCOUNT, request.getParameter(QueryNamedArguments.ID_DISCOUNT));
        newRoom.put(QueryNamedArguments.IMAGE_URL, request.getParameter(QueryNamedArguments.IMAGE_URL));

        try {
         Room room =  roomService.insertNewEntity(newRoom);
        } catch (ServiceException e) {
            request.setAttribute(ErrorType.EXCEPTION.name(), e);
            return new Router(PagePath.ERROR_500_PAGE, Router.RouterType.FORWARD);
        }
        return new Router(PagePath.WORKING_ADMIN_PANEL, Router.RouterType.FORWARD);
    }
}
