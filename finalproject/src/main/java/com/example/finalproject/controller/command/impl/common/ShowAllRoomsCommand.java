package com.example.finalproject.controller.command.impl.common;

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
import org.apache.log4j.Level;

import java.util.List;

import static com.example.finalproject.controller.QueryNamedArguments.CATALOG;

public class ShowAllRoomsCommand implements Command {
    private static final Logger logger = LogManager.getLogger(ShowAllRoomsCommand.class);
    private static final RoomService roomService = RoomServiceImpl.getInstance();

    @Override
    public Router execute(HttpServletRequest request){
        String page = request.getParameter(QueryNamedArguments.PAGE);
        int currentPageNumber = page != null ? Integer.parseInt(page) : 1;//todo

        try {
            List<Room> allRooms = roomService.showAllRooms();
            request.setAttribute(CATALOG, allRooms);
            request.setAttribute(QueryNamedArguments.PAGE, currentPageNumber);
            return new Router(PagePath.CATALOG, Router.RouterType.FORWARD);
        } catch (ServiceException e) {
            logger.log(Level.ERROR, "Failed to execute ShowAllRoomsCommand:", e);
            return new Router(PagePath.ERROR_500_PAGE, Router.RouterType.FORWARD);
        }
    }
}
