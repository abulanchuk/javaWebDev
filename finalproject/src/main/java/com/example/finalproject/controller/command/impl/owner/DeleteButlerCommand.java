package com.example.finalproject.controller.command.impl.owner;

import com.example.finalproject.controller.ErrorType;
import com.example.finalproject.controller.QueryNamedArguments;
import com.example.finalproject.controller.command.Command;
import com.example.finalproject.controller.command.PagePath;
import com.example.finalproject.controller.command.Router;
import com.example.finalproject.exception.ServiceException;
import com.example.finalproject.model.service.ButlerService;
import com.example.finalproject.model.service.impl.ButlerServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

public class DeleteButlerCommand implements Command {
    ButlerService butlerService = new ButlerServiceImpl();
    @Override
    public Router execute(HttpServletRequest request) {
        String login = request.getParameter(QueryNamedArguments.LOGIN);
        try {
            butlerService.deleteByLogin(login);
            return new Router(PagePath.HOME, Router.RouterType.REDIRECT);
        } catch (ServiceException e) {
            request.setAttribute(ErrorType.EXCEPTION.name(), e);
            return new Router(PagePath.ERROR_500_PAGE, Router.RouterType.FORWARD);
        }
    }
}
