package com.example.finalproject.controller.command.impl.common;

import com.example.finalproject.controller.command.Command;
import com.example.finalproject.controller.command.PagePath;
import com.example.finalproject.controller.command.Router;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class SignOutCommand implements Command {
    private static final Logger logger = LogManager.getLogger(SignOutCommand.class);
    @Override
    public Router execute(HttpServletRequest request) {
        logger.log(Level.DEBUG, "Session has finished");
        request.getSession().invalidate();
        return new Router(PagePath.INDEX, Router.RouterType.REDIRECT);
    }
}
