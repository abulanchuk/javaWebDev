package com.example.finalproject.controller.command.impl.client;

import com.example.finalproject.controller.QueryNamedArguments;
import com.example.finalproject.controller.SessionAttribute;
import com.example.finalproject.controller.command.Command;
import com.example.finalproject.controller.command.PagePath;
import com.example.finalproject.controller.command.Router;
import com.example.finalproject.exception.ServiceException;
import com.example.finalproject.model.service.ClientService;
import com.example.finalproject.model.service.impl.ClientServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ChangePasswordCommand implements Command {
    private static final Logger logger = LogManager.getLogger(ChangePasswordCommand.class);
    ClientService clientService = new ClientServiceImpl();

    @Override
    public Router execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Long id = (Long) session.getAttribute(SessionAttribute.USER_ID);
        String oldPassword = request.getParameter(QueryNamedArguments.OLD_PASSWORD);
        String newPassword = request.getParameter(QueryNamedArguments.NEW_PASSWORD);
        try {
            boolean resultFromUpdating = clientService.updatePassword(id, oldPassword, newPassword);
        } catch (ServiceException e) {
            logger.log(Level.ERROR, "Failed to execute updatePassword:", e);
            return new Router(PagePath.ERROR_500_PAGE, Router.RouterType.FORWARD);
        }
        return new Router(PagePath.PERSONAL_PAGE, Router.RouterType.FORWARD);
    }
}
