package com.example.finalproject.controller.command.impl;

import com.example.finalproject.controller.ErrorType;
import com.example.finalproject.controller.QueryNamedArguments;
import com.example.finalproject.controller.SessionAttribute;
import com.example.finalproject.controller.command.Command;
import com.example.finalproject.controller.command.PagePath;
import com.example.finalproject.controller.command.Router;
import com.example.finalproject.exception.ServiceException;
import com.example.finalproject.model.entity.Butler;
import com.example.finalproject.model.entity.Client;
import com.example.finalproject.model.entity.User;
import com.example.finalproject.model.service.ButlerService;
import com.example.finalproject.model.service.ClientService;
import com.example.finalproject.model.service.UserService;
import com.example.finalproject.model.service.impl.ButlerServiceImpl;
import com.example.finalproject.model.service.impl.ClientServiceImpl;
import com.example.finalproject.model.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.Level;

import java.util.Locale;
import java.util.Optional;


public class SignInCommand implements Command {
    private static final Logger logger = LogManager.getLogger(SignInCommand.class);
    private final UserService<User> userService = UserServiceImpl.getInstance();
    private final ClientService<Client> clientService = ClientServiceImpl.getInstance();
    private final ButlerService<Butler> butlerService = ButlerServiceImpl.getInstance();
    private final String BANK_ACCOUNT = "balance";

    @Override
    public Router execute(HttpServletRequest request) {
        String login = request.getParameter(QueryNamedArguments.LOGIN);
        String password = request.getParameter(QueryNamedArguments.PASSWORD);

        HttpSession session = request.getSession();
        String currentPage = (String) session.getAttribute(SessionAttribute.CURRENT_PAGE);

        Optional<User> optionalUser = null;
        try {
            optionalUser = userService.findUserByLoginAndPassword(login, password);

            if (!optionalUser.isPresent()) {
                logger.log(Level.ERROR, "Failed to execute request LoginUserCommand: Invalid login or password");
                request.setAttribute(ErrorType.ERROR_MESSAGE.name().toLowerCase(Locale.ROOT), "wrong.login.or.password");
                return new Router(currentPage, Router.RouterType.FORWARD);
            }

            User user = optionalUser.get();

            session.setAttribute(SessionAttribute.AUTHORIZATION, Boolean.TRUE);
            session.setAttribute(SessionAttribute.USER_ID, user.getIdUser());
            session.setAttribute(SessionAttribute.USER_LOGIN, user.getLogin());
            session.setAttribute(SessionAttribute.USER_NAME, user.getName());
            session.setAttribute(SessionAttribute.USER_SURNAME, user.getSurname());
            session.setAttribute(SessionAttribute.USER_ROLE, user.getRole());
            session.setAttribute(SessionAttribute.USER_PHONE_NUMBER, user.getPhoneNumber());
            switch (user.getRole()) {
                case OWNER -> {
                    return new Router(PagePath.HOME, Router.RouterType.REDIRECT);
                }
                case CLIENT -> {
                    Optional<Client> client = clientService.findByIdUser(user.getIdUser());
                    if (!client.isPresent()) {
                        logger.log(Level.ERROR, "Client can't find in database");
                    }
                    session.setAttribute(BANK_ACCOUNT, client.get().getBankAccount());
                    return new Router(PagePath.HOME, Router.RouterType.REDIRECT);
                }
                case BUTLER -> {
                    Optional butler = butlerService.findByIdUser(user.getIdUser());
                    if (!butler.isPresent()) {
                        logger.log(Level.ERROR, "Butler can't find in database");
                    }
                    return new Router(PagePath.HOME, Router.RouterType.REDIRECT);
                }
                default -> {
                    logger.log(Level.ERROR, "Failed to sign in by user with unknown role");
                    return new Router(PagePath.ERROR_404_PAGE, Router.RouterType.FORWARD);
                }
            }

        } catch (ServiceException e) {
            logger.log(Level.ERROR, "Failed to execute request SignInCommand: ", e);
            request.setAttribute(ErrorType.EXCEPTION.name().toLowerCase(Locale.ROOT), e);
            return new Router(PagePath.ERROR_500_PAGE, Router.RouterType.FORWARD);
        }
    }
}
