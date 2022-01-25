package com.example.finalproject.controller.command.impl.common;

import com.example.finalproject.controller.command.Command;
import com.example.finalproject.controller.command.PagePath;
import com.example.finalproject.controller.command.Router;
import jakarta.servlet.http.HttpServletRequest;

public class DefaultCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) {
        return new Router(PagePath.ERROR_404_PAGE, Router.RouterType.REDIRECT);
    }
}
