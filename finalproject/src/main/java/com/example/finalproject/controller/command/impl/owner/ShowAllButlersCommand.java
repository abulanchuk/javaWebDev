package com.example.finalproject.controller.command.impl.owner;

import com.example.finalproject.controller.QueryNamedArguments;
import com.example.finalproject.controller.command.Command;
import com.example.finalproject.controller.command.PagePath;
import com.example.finalproject.controller.command.Router;
import com.example.finalproject.exception.ServiceException;
import com.example.finalproject.model.entity.Butler;
import com.example.finalproject.model.entity.Client;
import com.example.finalproject.model.service.ButlerService;
import com.example.finalproject.model.service.impl.ButlerServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;

import static com.example.finalproject.controller.QueryNamedArguments.BUTLERS_LIST;

public class ShowAllButlersCommand implements Command {
    private static final Logger logger = LogManager.getLogger(ShowAllButlersCommand.class);
    ButlerService butlerService = new ButlerServiceImpl();
    @Override
    public Router execute(HttpServletRequest request) {
        try {
            List<Butler> butlerList = butlerService.findAll();
            request.setAttribute(BUTLERS_LIST, butlerList);
            return new Router(PagePath.LIST_BUTLERS, Router.RouterType.FORWARD);
        } catch (ServiceException e) {
            logger.log(Level.ERROR, "Failed to execute ShowAllButlersCommand:", e);
            return new Router(PagePath.ERROR_500_PAGE, Router.RouterType.FORWARD);
        }
    }
}
