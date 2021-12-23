package com.example.finalproject.model.mapper;

public final class ColumnTableName {
    /* users table */
    public static final String ID_USER = "id_user";
    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    public static final String ROLE = "role";
    public static final String NAME = "name";
    public static final String SURNAME = "surname";
    public static final String PHONE_NUMBER = "phone_number";
    /* butlers table */
    public static final String ID_BUTLER = "id_butler";
    public static final String RATING  = "rating";
    /* clients table */
    public static final String ID_CLIENT = "id_client";
    public static final String PASSWORD_NUMBER = "password_number";
    public static final String EMAIL = "email";
    public static final String BANK_ACCOUNT = "bank_account";
    /* comments table */
    public static final String ID_COMMENT = "id_comment";
    public static final String CONTENT = "content";
    /* rooms table */
    public static final String ID_ROOM = "id_room";
    public static final String PRICE = "price";
    public static final String ROOM_TYPE = "room_type";
    public static final String FLOOR = "floor";
    public static final String ROOM_NUMBER = "room_number";
    public static final String IMAGE_URL = "image_url";
    /* discounts table */
    public static final String ID_DISCOUNT = "id_discount";
    public static final String PERCENT = "percent";
    /* orders table */
    public static final String ID_ORDER = "id_order";
    public static final String START_DATE = "start_date";
    public static final String FINISH_DATE = "finish_date";
    public static final String ID_PAID = "is_paid";
    public static final String IS_ACTIVE = "is_active";

    private ColumnTableName() {
    }
 }
