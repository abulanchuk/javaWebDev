package com.example.finalproject.controller.command.impl;

import com.example.finalproject.controller.QueryNamedArguments;
import com.example.finalproject.controller.SessionAttribute;
import com.example.finalproject.controller.command.Command;
import com.example.finalproject.controller.command.PagePath;
import com.example.finalproject.controller.command.Router;
import com.example.finalproject.exception.ServiceException;
import com.example.finalproject.model.entity.User;
import com.example.finalproject.model.service.UserService;
import com.example.finalproject.model.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class EditPersonalInformationCommand implements Command {
    private static final Logger logger = LogManager.getLogger(EditPersonalInformationCommand.class);
    UserService userService = new UserServiceImpl();

    @Override
    public Router execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String currentPage = (String) session.getAttribute(SessionAttribute.CURRENT_PAGE);

        String login = request.getParameter(QueryNamedArguments.LOGIN);
        String password = request.getParameter(QueryNamedArguments.PASSWORD);
        String name = request.getParameter(QueryNamedArguments.NAME);
        String surname = request.getParameter(QueryNamedArguments.SURNAME);
        String phoneNumber = request.getParameter(QueryNamedArguments.PHONE_NUMBER);


        try {
            userService.updateUser((Long) session.getAttribute(SessionAttribute.USER_ID),login,password,name,surname,phoneNumber);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return new Router(PagePath.HOME, Router.RouterType.FORWARD);
    }
}
