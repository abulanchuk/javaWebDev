package com.example.finalproject.controller.command.impl.client;

import com.example.finalproject.controller.ErrorType;
import com.example.finalproject.controller.SessionAttribute;
import com.example.finalproject.controller.command.Command;
import com.example.finalproject.controller.command.PagePath;
import com.example.finalproject.controller.command.Router;
import com.example.finalproject.exception.ServiceException;
import com.example.finalproject.model.entity.Client;
import com.example.finalproject.model.service.ClientService;
import com.example.finalproject.model.service.impl.ClientServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


import java.util.Optional;

import static com.example.finalproject.controller.QueryNamedArguments.BANK_ACCOUNT;


public class AddMoneyToBankAccountCommand implements Command {
    ClientService clientService = new ClientServiceImpl();
    Optional<Client> client;

    @Override
    public Router execute(HttpServletRequest request) {
        String moneyForAdding = request.getParameter(BANK_ACCOUNT);

        HttpSession session = request.getSession();
        Long id = (Long)session.getAttribute(SessionAttribute.USER_ID);
        try {
            clientService.updateCashInBankAccount(id, moneyForAdding);
            client = clientService.findByIdUser(id);
              Client newClient = client.get();

            session.setAttribute(SessionAttribute.BANK_ACCOUNT, newClient.getBankAccount());
        } catch (ServiceException e) {
            request.setAttribute(ErrorType.EXCEPTION.name(), e);
            return new Router(PagePath.ERROR_500_PAGE, Router.RouterType.FORWARD);
        }
        return new Router(PagePath.HOME, Router.RouterType.REDIRECT);
    }
}
