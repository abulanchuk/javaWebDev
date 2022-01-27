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
import com.example.finalproject.util.MailSender;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.mail.MessagingException;
import java.io.IOException;

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
            MailSender.sentEmail(email,"UPDATED INFORMATION FUSHIFARU","Your personal information was successfully updated!\nThanks for staying with us.\n Yours dreamy FUSHIFARU islands");
        } catch (ServiceException e) {
            e.printStackTrace();//todo
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Router(PagePath.HOME, Router.RouterType.FORWARD);
    }
}
