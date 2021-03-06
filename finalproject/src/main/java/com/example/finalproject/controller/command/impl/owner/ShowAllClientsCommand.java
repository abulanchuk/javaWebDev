package com.example.finalproject.controller.command.impl.owner;

import com.example.finalproject.controller.QueryNamedArguments;
import com.example.finalproject.controller.command.Command;
import com.example.finalproject.controller.command.PagePath;
import com.example.finalproject.controller.command.Router;
import com.example.finalproject.exception.ServiceException;
import com.example.finalproject.model.entity.Client;
import com.example.finalproject.model.service.ClientService;
import com.example.finalproject.model.service.impl.ClientServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;

import static com.example.finalproject.controller.QueryNamedArguments.CLIENTS_LIST;

public class ShowAllClientsCommand implements Command {
    private static final Logger logger = LogManager.getLogger(ShowAllClientsCommand.class);
    ClientService clientService = new ClientServiceImpl();
    @Override
    public Router execute(HttpServletRequest request) {
        try {
            List<Client> clientList = clientService.findAll();
            request.setAttribute(CLIENTS_LIST, clientList);
            return new Router(PagePath.LIST_CLIENTS, Router.RouterType.FORWARD);
        } catch (ServiceException e) {
            logger.log(Level.ERROR, "Failed to execute ShowAllClientsCommand:", e);
            return new Router(PagePath.ERROR_500_PAGE, Router.RouterType.FORWARD);
        }
    }
}
