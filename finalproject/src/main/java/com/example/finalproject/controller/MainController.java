package com.example.finalproject.controller;

import java.io.*;
import java.util.Locale;

import com.example.finalproject.controller.command.Command;
import com.example.finalproject.controller.command.CommandProvider;
import com.example.finalproject.controller.command.PagePath;
import com.example.finalproject.controller.command.Router;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.Level;

@WebServlet(name = "mainController", value = "/controller")
public class MainController extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(MainController.class);
    public void init() {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doRequest(request, response);
    }

    private void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String commandName = request.getParameter(QueryNamedArguments.COMMAND_NAME.name().toLowerCase());
        CommandProvider provider = CommandProvider.getInstance();

        Command command = provider.getCommand(CommandType.valueOf(commandName.toUpperCase()));
        Router router = command.execute(request);

        switch (router.getRouterType()) {
            case FORWARD:
                request.getRequestDispatcher(router.getPagePath()).forward(request, response);
                logger.log(Level.DEBUG, "forward to " + router.getPagePath());
                break;
            case REDIRECT:
                response.sendRedirect(router.getPagePath());
                logger.log(Level.DEBUG, "redirect to " + router.getPagePath());
                break;
            default:
                logger.log(Level.ERROR, "incorrect router type: " + router.getRouterType());
                response.sendRedirect(PagePath.ERROR_500_PAGE);
                logger.log(Level.DEBUG, "redirect to " + router.getPagePath());
                break;
        }
    }

    public void destroy() {
    }
}