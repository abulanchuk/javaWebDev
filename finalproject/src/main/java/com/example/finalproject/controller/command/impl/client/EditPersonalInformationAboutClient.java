package com.example.finalproject.controller.command.impl.client;

import com.example.finalproject.controller.QueryNamedArguments;
import com.example.finalproject.controller.SessionAttribute;
import com.example.finalproject.controller.command.Command;
import com.example.finalproject.controller.command.PagePath;
import com.example.finalproject.controller.command.Router;
import com.example.finalproject.controller.command.impl.EditPersonalInformationCommand;
import com.example.finalproject.exception.ServiceException;
import com.example.finalproject.model.service.ClientService;
import com.example.finalproject.model.service.impl.ClientServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class EditPersonalInformationAboutClient implements Command {
    private static final Logger logger = LogManager.getLogger(EditPersonalInformationCommand.class);
    ClientService userService = new ClientServiceImpl();

    @Override
    public Router execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String currentPage = (String) session.getAttribute(SessionAttribute.CURRENT_PAGE);

        String password = request.getParameter(QueryNamedArguments.PASSWORD);
        String name = request.getParameter(QueryNamedArguments.NAME);
        String surname = request.getParameter(QueryNamedArguments.SURNAME);
        String phoneNumber = request.getParameter(QueryNamedArguments.PHONE_NUMBER);
        String email = request.getParameter(QueryNamedArguments.EMAIL);
        String passportNumber = request.getParameter(QueryNamedArguments.PASSPORT_NUMBER);

        try {
            userService.updateClient((Long) session.getAttribute(SessionAttribute.USER_ID), password, name, surname, phoneNumber, email, passportNumber);
        } catch (ServiceException e) {
            e.printStackTrace();//todo
        }
        return new Router(PagePath.HOME, Router.RouterType.FORWARD);
    }
}
