package com.example.finalproject.controller.command.impl.client;

import com.example.finalproject.controller.ErrorType;
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

public class EditPersonalInformationAboutClientCommand implements Command {
    private static final Logger logger = LogManager.getLogger(EditPersonalInformationCommand.class);
    ClientService clientService = new ClientServiceImpl();

    @Override
    public Router execute(HttpServletRequest request) {
        HttpSession session = request.getSession();

        String name = request.getParameter(QueryNamedArguments.NAME);
        String surname = request.getParameter(QueryNamedArguments.SURNAME);
        String phoneNumber = request.getParameter(QueryNamedArguments.PHONE_NUMBER);
        String email = request.getParameter(QueryNamedArguments.EMAIL);
        String passportNumber = request.getParameter(QueryNamedArguments.PASSPORT_NUMBER);

        try {
            clientService.updateClient((Long) session.getAttribute(SessionAttribute.USER_ID), name, surname, phoneNumber, email, passportNumber);
            MailSender.sentEmail(email,"UPDATED INFORMATION FUSHIFARU","Your personal information was successfully updated!\nThanks for staying with us.\n Yours dreamy FUSHIFARU islands");
        } catch (ServiceException e) {
            request.setAttribute(ErrorType.EXCEPTION.name(), e);
            return new Router(PagePath.ERROR_500_PAGE, Router.RouterType.FORWARD);
        } catch (MessagingException e) {
            e.printStackTrace(); //todo
        } catch (IOException e) {
            e.printStackTrace(); //todo
        }
        return new Router(PagePath.HOME, Router.RouterType.FORWARD);
    }
}
