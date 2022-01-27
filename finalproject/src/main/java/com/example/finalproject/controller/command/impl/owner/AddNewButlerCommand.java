package com.example.finalproject.controller.command.impl.owner;

import com.example.finalproject.controller.ErrorType;
import com.example.finalproject.controller.QueryNamedArguments;
import com.example.finalproject.controller.command.Command;
import com.example.finalproject.controller.command.PagePath;
import com.example.finalproject.controller.command.Router;
import com.example.finalproject.exception.ServiceException;
import com.example.finalproject.model.entity.Butler;
import com.example.finalproject.model.entity.User;
import com.example.finalproject.model.entity.UserRole;
import com.example.finalproject.model.service.ButlerService;
import com.example.finalproject.model.service.UserService;
import com.example.finalproject.model.service.impl.ButlerServiceImpl;
import com.example.finalproject.model.service.impl.UserServiceImpl;
import com.example.finalproject.util.PasswordEncryptor;
import com.example.finalproject.validator.Validator;
import com.example.finalproject.validator.impl.ValidatorImpl;
import jakarta.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.example.finalproject.controller.ErrorType.*;

public class AddNewButlerCommand implements Command {
    Validator validator = new ValidatorImpl();
    UserService userService = new UserServiceImpl();
    ButlerService butlerService = new ButlerServiceImpl();

    @Override
    public Router execute(HttpServletRequest request) {
        String login = request.getParameter(QueryNamedArguments.LOGIN);
        String password = request.getParameter(QueryNamedArguments.PASSWORD);
        String name = request.getParameter(QueryNamedArguments.NAME);
        String surname = request.getParameter(QueryNamedArguments.SURNAME);
        String phoneNumber = request.getParameter(QueryNamedArguments.PHONE_NUMBER);


        Map<String, String> formRegistration = new HashMap<>();
        formRegistration.put(QueryNamedArguments.LOGIN, login);
        formRegistration.put(QueryNamedArguments.PASSWORD, password);
        formRegistration.put(QueryNamedArguments.NAME, name);
        formRegistration.put(QueryNamedArguments.SURNAME, surname);
        formRegistration.put(QueryNamedArguments.PHONE_NUMBER, phoneNumber);

        boolean isDataValid = validator.checkRegistrationButlerOrOwner(formRegistration);
        if (!isDataValid) {
            request.setAttribute(QueryNamedArguments.FORM_REGISTRATION, formRegistration);
            request.setAttribute(String.valueOf(ErrorType.ERROR_MESSAGE), INVALID_INPUT);
            return new Router(PagePath.REGISTRATION, Router.RouterType.FORWARD);
        }

        try {
            Optional<User> userByLogin = userService.findUserByLogin(formRegistration.get(QueryNamedArguments.LOGIN));
            if (userByLogin.isPresent()) {
                formRegistration.put(QueryNamedArguments.LOGIN, EMPTY_STRING.name());
                request.setAttribute(QueryNamedArguments.FORM_REGISTRATION, formRegistration);
                request.setAttribute(String.valueOf(ErrorType.ERROR_MESSAGE), LOGIN_IS_NOT_FREE);
                return new Router(PagePath.REGISTRATION, Router.RouterType.FORWARD);
            }
            String encryptedPassword = PasswordEncryptor.encrypt(password);
            User userFieldsForNewButler = new User(login, encryptedPassword, UserRole.BUTLER, name, surname, phoneNumber);
            Butler butlerFieldsForNewButler = new Butler((byte) 5);
            Butler created = (Butler) butlerService.insertNewEntity(userFieldsForNewButler, butlerFieldsForNewButler);
            return new Router(PagePath.HOME, Router.RouterType.REDIRECT);
        } catch (ServiceException e) {
            request.setAttribute(ErrorType.EXCEPTION.name(), e);
            return new Router(PagePath.ERROR_500_PAGE, Router.RouterType.FORWARD);
        }
    }
}
