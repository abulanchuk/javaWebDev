package com.example.finalproject.controller.command.impl;

import com.example.finalproject.controller.ErrorType;
import com.example.finalproject.controller.QueryNamedArguments;
import com.example.finalproject.controller.command.Command;
import com.example.finalproject.controller.command.PagePath;
import com.example.finalproject.controller.command.Router;
import com.example.finalproject.exception.ServiceException;
import com.example.finalproject.model.entity.Client;
import com.example.finalproject.model.entity.User;
import com.example.finalproject.model.entity.UserRole;
import com.example.finalproject.model.service.ClientService;
import com.example.finalproject.model.service.UserService;
import com.example.finalproject.model.service.impl.ClientServiceImpl;
import com.example.finalproject.model.service.impl.UserServiceImpl;
import com.example.finalproject.util.MailSender;
import com.example.finalproject.util.PasswordEncryptor;
import com.example.finalproject.validator.Validator;
import com.example.finalproject.validator.impl.ValidatorImpl;
import jakarta.servlet.http.HttpServletRequest;

import javax.mail.MessagingException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.example.finalproject.controller.ErrorType.*;

public class SignUpCommand implements Command {
    Validator validator = new ValidatorImpl();
    UserService userService = new UserServiceImpl();
    ClientService clientService = new ClientServiceImpl();

    @Override
    public Router execute(HttpServletRequest request) {
        String login = request.getParameter(QueryNamedArguments.LOGIN);
        String password = request.getParameter(QueryNamedArguments.PASSWORD);
        String name = request.getParameter(QueryNamedArguments.NAME);
        String surname = request.getParameter(QueryNamedArguments.SURNAME);
        String phoneNumber = request.getParameter(QueryNamedArguments.PHONE_NUMBER);
        String passportNumber = request.getParameter(QueryNamedArguments.PASSPORT_NUMBER);
        String email = request.getParameter(QueryNamedArguments.EMAIL);

        Map<String, String> formRegistration = new HashMap<>();
        formRegistration.put(QueryNamedArguments.LOGIN, login);
        formRegistration.put(QueryNamedArguments.PASSWORD, password);
        formRegistration.put(QueryNamedArguments.NAME, name);
        formRegistration.put(QueryNamedArguments.SURNAME, surname);
        formRegistration.put(QueryNamedArguments.PHONE_NUMBER, phoneNumber);
        formRegistration.put(QueryNamedArguments.PASSPORT_NUMBER, passportNumber);
        formRegistration.put(QueryNamedArguments.EMAIL, email);

        boolean isDataValid = validator.checkRegistration(formRegistration);
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
            Optional<Client> clientOptional = clientService.findByEmail(formRegistration.get(QueryNamedArguments.EMAIL));
            if (clientOptional.isPresent()) {
                formRegistration.put(QueryNamedArguments.EMAIL, EMPTY_STRING.name());
                request.setAttribute(QueryNamedArguments.FORM_REGISTRATION, formRegistration);
                request.setAttribute(String.valueOf(ErrorType.ERROR_MESSAGE), EMAIL_IS_NOT_FREE);
                return new Router(PagePath.REGISTRATION, Router.RouterType.FORWARD);
            }
            String encryptedPassword = PasswordEncryptor.encrypt(password);
            User userFieldsForNewClient = new User(login, encryptedPassword, UserRole.CLIENT, name, surname, phoneNumber);
            Client clientFieldsForNewClient = new Client(passportNumber, email, new BigDecimal("0"));
            Client created = (Client) clientService.insertNewEntity(userFieldsForNewClient, clientFieldsForNewClient);
            MailSender.sentEmail(email,"WELCOME TO FUSHIFARU",name+" thank you for registering on the site! We wish you an unforgettable holiday");
            return new Router(PagePath.AUTHORIZATION, Router.RouterType.REDIRECT);
        } catch (ServiceException e) {
            request.setAttribute(ErrorType.EXCEPTION.name(), e);
            return new Router(PagePath.ERROR_500_PAGE, Router.RouterType.FORWARD);
        } catch (MessagingException e) {
            request.setAttribute(ErrorType.EXCEPTION.name(), e);
            return new Router(PagePath.ERROR_500_PAGE, Router.RouterType.FORWARD);
        } catch (IOException e) {
            request.setAttribute(ErrorType.EXCEPTION.name(), e);
            return new Router(PagePath.ERROR_500_PAGE, Router.RouterType.FORWARD);
        }
    }
}
