package com.example.finalproject.model.mapper;

public final class ColumnTableName {
    /* users table */
    public static final String ID_USER = "users.id_user";
    public static final String LOGIN = "users.login";
    public static final String PASSWORD = "users.password";
    public static final String ROLE = "users.role";
    public static final String NAME = "users.name";
    public static final String SURNAME = "users.surname";
    public static final String PHONE_NUMBER = "users.phone_number";
    /* butlers table */
    public static final String ID_BUTLER = "butlers.id_butler";
    public static final String RATING  = "butlers.rating";
    /* clients table */
    public static final String ID_CLIENT = "clients.id_client";
    public static final String PASSWORD_NUMBER = "clients.password_number";
    public static final String EMAIL = "clients.email";
    public static final String BANK_ACCOUNT = "clients.bank_account";
    /* comments table */
    public static final String ID_COMMENT = "comments.id_comment";
    public static final String CONTENT = "comments.content";
    /* rooms table */
    public static final String ID_ROOM = "rooms.id_room";
    public static final String PRICE = "rooms.price";
    public static final String ROOM_TYPE = "rooms.room_type";
    public static final String FLOOR = "rooms.floor";
    public static final String ROOM_NUMBER = "rooms.room_number";
    public static final String IMAGE_URL = "rooms.image_url";
    /* discounts table */
    public static final String ID_DISCOUNT = "discounts.id_discount";
    public static final String PERCENT = "discounts.percent";
    /* orders table */
    public static final String ID_ORDER = "orders.id_order";
    public static final String START_DATE = "orders.start_date";
    public static final String FINISH_DATE = "orders.finish_date";
    public static final String ID_PAID = "orders.is_paid";
    public static final String IS_ACTIVE = "orders.is_active";

    private ColumnTableName() {
    }
 }
