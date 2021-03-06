package com.example.finalproject.controller.command.impl.owner;

import com.example.finalproject.controller.ErrorType;
import com.example.finalproject.controller.QueryNamedArguments;
import com.example.finalproject.controller.command.Command;
import com.example.finalproject.controller.command.PagePath;
import com.example.finalproject.controller.command.Router;
import com.example.finalproject.exception.ServiceException;
import com.example.finalproject.model.service.ClientService;
import com.example.finalproject.model.service.impl.ClientServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class DeleteClientCommand implements Command {
    private static final Logger logger = LogManager.getLogger(DeleteClientCommand.class);
    ClientService clientService = new ClientServiceImpl();
    @Override
    public Router execute(HttpServletRequest request) {
        String login = request.getParameter(QueryNamedArguments.LOGIN);
        try {
            clientService.deleteByLogin(login);
            return new Router(PagePath.HOME, Router.RouterType.REDIRECT);
        } catch (ServiceException e) {
            request.setAttribute(ErrorType.EXCEPTION.name(), e);
            return new Router(PagePath.ERROR_500_PAGE, Router.RouterType.FORWARD);
        }

    }
}
