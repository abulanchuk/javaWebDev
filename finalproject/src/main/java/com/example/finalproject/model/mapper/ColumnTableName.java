package com.example.finalproject.model.mapper;

public final class ColumnTableName {
    /* users table */
    public static final String USERS_ID_USER = "users.id_user";
    public static final String USERS_LOGIN = "users.login";
    public static final String USERS_PASSWORD = "users.password";
    public static final String USERS_ROLE = "users.role";
    public static final String USERS_NAME = "users.name";
    public static final String USERS_SURNAME = "users.surname";
    public static final String USERS_PHONE_NUMBER = "users.phone_number";
    /* butlers table */
    public static final String BUTLERS_ID_BUTLER = "butlers.id_butler";
    public static final String BUTLERS_ID_USER = "butlers.id_user";
    public static final String BUTLERS_RATING = "butlers.rating";
    /* clients table */
    public static final String CLIENTS_ID_CLIENT = "clients.id_client";
    public static final String CLIENTS_PASSWORD_NUMBER = "clients.password_number";
    public static final String CLIENTS_EMAIL = "clients.email";
    public static final String CLIENTS_BANK_ACCOUNT = "clients.bank_account";
    public static final String CLIENTS_ID_USER = "clients.id_user";
    /* comments table */
    public static final String COMMENTS_ID_COMMENT = "comments.id_comment";
    public static final String COMMENTS_CONTENT = "comments.content";
    public static final String COMMENTS_ID_BUTLER = "comments.id_butler";
    /* rooms table */
    public static final String ROOMS_ID_ROOM = "rooms.id_room";
    public static final String ROOMS_PRICE = "rooms.price";
    public static final String ROOMS_ROOM_TYPE = "rooms.room_type";
    public static final String ROOMS_FLOOR = "rooms.floor";
    public static final String ROOMS_ROOM_NUMBER = "rooms.room_number";
    public static final String ROOMS_IMAGE_URL = "rooms.image_url";
    public static final String ROOMS_ID_DISCOUNT = "rooms.id_discount";
    /* discounts table */
    public static final String DISCOUNTS_ID_DISCOUNT = "discounts.id_discount";
    public static final String DISCOUNTS_PERCENT = "discounts.percent";
    /* orders table */
    public static final String ORDERS_ID_ORDER = "orders.id_order";
    public static final String ORDERS_START_DATE = "orders.start_date";
    public static final String ORDERS_FINISH_DATE = "orders.finish_date";
    public static final String ORDERS_IS_PAID = "orders.is_paid";
    public static final String ORDERS_IS_ACTIVE = "orders.is_active";
    public static final String ORDERS_ID_BUTLER = "orders.id_butler";
    public static final String ORDERS_ID_CLIENT = "orders.order_id_client";
    public static final String ORDERS_TOTAL_PRICE = "orders.total_price";

    private ColumnTableName() {
    }
 }
