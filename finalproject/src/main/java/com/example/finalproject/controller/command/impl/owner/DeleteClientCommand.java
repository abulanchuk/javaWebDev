package com.example.finalproject.controller.command.impl.owner;

import com.example.finalproject.controller.ErrorType;
import com.example.finalproject.controller.QueryNamedArguments;
import com.example.finalproject.controller.command.Command;
import com.example.finalproject.controller.command.PagePath;
import com.example.finalproject.controller.command.Router;
import com.example.finalproject.exception.ServiceException;
import com.example.finalproject.model.entity.Client;
import com.example.finalproject.model.entity.User;
import com.example.finalproject.model.service.ClientService;
import com.example.finalproject.model.service.impl.ClientServiceImpl;
import com.example.finalproject.validator.Validator;
import com.example.finalproject.validator.impl.ValidatorImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import static com.example.finalproject.controller.ErrorType.INVALID_LOGIN;
import static com.example.finalproject.controller.SessionAttribute.USER_ROLE;

public class DeleteClientCommand implements Command {
    private static final Logger logger = LogManager.getLogger(DeleteClientCommand.class);
    Validator validator = new ValidatorImpl();
    ClientService clientService = new ClientServiceImpl();
User user = new User();
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
