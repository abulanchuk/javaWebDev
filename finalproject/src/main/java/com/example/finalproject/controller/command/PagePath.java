package com.example.finalproject.controller.command;

public class PagePath {
    public static final String ERROR_404_PAGE = "jsp/errors/error404.jsp";
    public static final String ERROR_500_PAGE = "jsp/errors/error500.jsp";

    public static final String INDEX = "index.jsp";
    public static final String HOME ="jsp/navigation/main.jsp";
    public static final String AUTHORIZATION ="jsp/navigation/authorization.jsp";
    public static final String REGISTRATION ="jsp/navigation/registration.jsp";
    public static final String CATALOG ="jsp/navigation/rooms.jsp";
    public static final String UPDATE_PERSONAL_INFORMATION ="jsp/navigation/updatePersonalInformation.jsp";
    public static final String WORKING_ADMIN_PANEL ="jsp/navigation/owner/workingpanel.jsp";
    public static final String PERSONAL_PAGE = "jsp/navigation/client/personalClientPage.jsp";
    public static final String BASKET = "jsp/navigation/client/basket.jsp";
    public static final String LIST_BUTLERS_ORDERS = "jsp/navigation/butler/ordersWhereButlerWorking.jsp";
    public static final String LIST_CLIENTS = "jsp/navigation/owner/allClients.jsp";
    public static final String LIST_BUTLERS = "jsp/navigation/owner/allButlers.jsp";
    public static final String ALL_ORDERS = "jsp/navigation/owner/allOrders.jsp";
    private PagePath() {
    }
}
