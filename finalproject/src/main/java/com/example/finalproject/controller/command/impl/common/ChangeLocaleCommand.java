package com.example.finalproject.controller.command.impl.common;

import com.example.finalproject.controller.QueryNamedArguments;
import com.example.finalproject.controller.SessionAttribute;
import com.example.finalproject.controller.command.Command;
import com.example.finalproject.controller.command.PagePath;
import com.example.finalproject.controller.command.Router;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.Locale;

public class ChangeLocaleCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) {
        String locale = request.getParameter(QueryNamedArguments.LOCALE);
        HttpSession session = request.getSession();
        session.setAttribute(SessionAttribute.LOCALE.toLowerCase(Locale.ROOT), locale);
        if (session.getAttribute(SessionAttribute.CURRENT_PAGE) == null) {
            return new Router(PagePath.INDEX, Router.RouterType.FORWARD);
        }

        return new Router((String) session.getAttribute(SessionAttribute.CURRENT_PAGE), Router.RouterType.FORWARD);

    }
}
