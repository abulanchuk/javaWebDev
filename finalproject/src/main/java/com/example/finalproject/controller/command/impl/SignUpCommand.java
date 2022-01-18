package com.example.finalproject.controller.command.impl;

import com.example.finalproject.controller.ErrorType;
import com.example.finalproject.controller.QueryNamedArguments;
import com.example.finalproject.controller.command.Command;
import com.example.finalproject.controller.command.PagePath;
import com.example.finalproject.controller.command.Router;
import com.example.finalproject.validator.Validator;
import com.example.finalproject.validator.impl.ValidatorImpl;
import jakarta.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static com.example.finalproject.controller.ErrorType.INVALID_INPUT;

public class SignUpCommand implements Command {
    Validator validator = new ValidatorImpl();

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
            request.setAttribute(QueryNamedArguments.FORM_DATA, formRegistration);
            request.setAttribute(String.valueOf(ErrorType.ERROR_MESSAGE), INVALID_INPUT);
            return new Router(PagePath.REGISTRATION, Router.RouterType.FORWARD);
        }


        return null;
    }
}
