package com.example.finalproject.controller.filter;

import com.example.finalproject.controller.CommandType;
import com.example.finalproject.controller.QueryNamedArguments;
import com.example.finalproject.controller.SessionAttribute;
import com.example.finalproject.controller.command.PagePath;
import com.example.finalproject.model.entity.UserRole;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.EnumMap;
import java.util.EnumSet;

import static com.example.finalproject.controller.CommandType.*;

@WebFilter(urlPatterns = {"/controller"})
public class CommandSecurityFilter implements Filter {
    private final EnumMap<UserRole, EnumSet<CommandType>> roleMap =
            new EnumMap<>(UserRole.class);
    private final EnumSet<CommandType> guestCommands = EnumSet.of(
            CHANGE_LOCALE,
            SIGN_IN,
            SHOW_ALL_ROOMS,
            SIGN_UP,
            SIGN_OUT
    );

    private final EnumSet<CommandType> ownerCommands = EnumSet.of(
            EDIT_PERSONAL_INFORMATION,
            CHANGE_LOCALE,
            ADD_BUTLER,
            ADD_OWNER,
            ADD_ROOM,
            SHOW_ALL_ROOMS,
            DELETE_BUTLER,
            DELETE_CLIENT,
            SHOW_ACTIVE_OR_NOT_ORDERS,
            SHOW_ALL_BUTLERS,
            SHOW_ALL_CLIENTS,
            SIGN_OUT);

    private final EnumSet<CommandType> clientCommands = EnumSet.of(
            SIGN_OUT,
            CHANGE_LOCALE,
            SHOW_ALL_ROOMS,
            EDIT_PERSONAL_INFORMATION_ABOUT_CLIENT,
            UPDATE_CASH,
            CREATE_ORDER,
            SELECT_BOOKING_DATES,
            CHANGE_PASSWORD
    );

    private final EnumSet<CommandType> butlerCommands = EnumSet.of(
            EDIT_PERSONAL_INFORMATION,
            CHANGE_LOCALE,
            SIGN_OUT,
            SHOW_ALL_ROOMS,
            SHOW_BUTLERS_ORDERS
    );

    @Override
    public void init(FilterConfig filterConfig) {
        roleMap.put(UserRole.GUEST, guestCommands);
        roleMap.put(UserRole.OWNER, ownerCommands);
        roleMap.put(UserRole.CLIENT, clientCommands);
        roleMap.put(UserRole.BUTLER, butlerCommands);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        UserRole userRole = (UserRole) session.getAttribute(SessionAttribute.USER_ROLE);
        if (userRole == null) {
            userRole = UserRole.GUEST;
        }

        String commandParameter = request.getParameter(QueryNamedArguments.COMMAND_NAME);
        CommandType command = CommandType.valueOf(commandParameter.toUpperCase());

        boolean hasAccess = roleMap.get(userRole)
                .stream()
                .anyMatch(c -> c == command);

        if (!hasAccess) {
            response.sendRedirect(request.getContextPath() + "/" + PagePath.HOME);
        } else {
            filterChain.doFilter(request, response);
        }
    }
}
