package com.example.finalproject.controller.command.impl;

import com.example.finalproject.controller.QueryNamedArguments;
import com.example.finalproject.controller.SessionAttributes;
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
import com.example.finalproject.validator.impl.ValidatorImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.Level;

import java.util.Locale;
import java.util.Optional;


public class SignInCommand implements Command {


//    @Override
    // public Router execute(HttpServletRequest request) {
      /*  // Login, Password
        String login = request.getParameter(QueryNamedArguments.LOGIN.name().toLowerCase(Locale.ROOT));
        String password = request.getParameter(QueryNamedArguments.PASSWORD.name().toLowerCase(Locale.ROOT));

        if (!validator.isCorrectLogin(login) || !validator.isCorrectPassword(password)) {
            request.setAttribute(QueryNamedArguments.ERROR_MESSAGE.name().toLowerCase(Locale.ROOT), "login.or.password.is.not.valid");
            return new Router(currentPage, Router.RouterType.FORWARD);
        }


        HttpSession session = request.getSession();
        String currentPage = (String) session.getAttribute(SessionAttributes.CURRENT_PAGE);

        request.setAttribute(QueryNamedArguments.ERROR_MESSAGE.name(), login + password);
        return new

                Router(currentPage, Router.RouterType.FORWARD);
    }*/

    private static final Logger logger = LogManager.getLogger(SignInCommand.class);
    private final UserService<User> userService = UserServiceImpl.getInstance();
    private final ClientService<Client> clientService = ClientServiceImpl.getInstance();
    private final ButlerService<Butler> butlerService = ButlerServiceImpl.getInstance();
    private static final String keyBankAccountToJsp = "balance";

    @Override
    public Router execute(HttpServletRequest request) {
        String login = request.getParameter(QueryNamedArguments.LOGIN.name().toLowerCase(Locale.ROOT));
        String password = request.getParameter(QueryNamedArguments.PASSWORD.name().toLowerCase(Locale.ROOT));

        HttpSession session = request.getSession();
        String currentPage = (String) session.getAttribute(SessionAttributes.CURRENT_PAGE);

        Optional<User> optionalUser = null;
        try {
            optionalUser = userService.findUserByLoginAndPassword(login, password);

            if (optionalUser.isPresent()) {
                User user = optionalUser.get();

                session.setAttribute(SessionAttributes.AUTHORIZATION, Boolean.TRUE);
                session.setAttribute(SessionAttributes.USER_ID, user.getIdUser());
                session.setAttribute(SessionAttributes.USER_LOGIN, user.getLogin());
                session.setAttribute(SessionAttributes.USER_NAME, user.getName());
                session.setAttribute(SessionAttributes.USER_SURNAME, user.getSurname());
                session.setAttribute(SessionAttributes.USER_ROLE, user.getRole());
                session.setAttribute(SessionAttributes.USER_PHONE_NUMBER, user.getPhoneNumber());
                switch (user.getRole()) {
                    case OWNER -> {
                        return new Router(PagePath.HOME, Router.RouterType.REDIRECT);
                    }
                    case CLIENT -> {
                        Optional<Client> client = clientService.findByIdUser(user.getIdUser());
                        if (!client.isPresent()) {
                            logger.log(Level.ERROR, "User can't find in database");
                        }
                        session.setAttribute(keyBankAccountToJsp, client.get().getBankAccount());
                        return new Router(PagePath.HOME, Router.RouterType.REDIRECT);
                    }
                    case BUTLER -> {
                        Optional butler = butlerService.findById(user.getIdUser());
                        return new Router(PagePath.HOME, Router.RouterType.REDIRECT);
                    }
                    default -> {
                        logger.log(Level.ERROR, "Failed to sign in by user with unknown role");
                        return new Router(PagePath.ERROR_404_PAGE, Router.RouterType.FORWARD);
                    }
                }
            } else {
                logger.log(Level.ERROR, "Failed to execute request LoginUserCommand: Invalid login or password");
                request.setAttribute(QueryNamedArguments.ERROR_MESSAGE.name().toLowerCase(Locale.ROOT), "wrong.login.or.password");
                return new Router(currentPage, Router.RouterType.FORWARD);
            }

        } catch (ServiceException e) {
            logger.log(Level.ERROR, "Failed to execute request SignInCommand: ", e);
            request.setAttribute(QueryNamedArguments.EXCEPTION.name().toLowerCase(Locale.ROOT), e);
            return new Router(PagePath.ERROR_500_PAGE, Router.RouterType.FORWARD);
        }

    }
}
