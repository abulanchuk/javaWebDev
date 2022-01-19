package com.example.finalproject.controller;

public enum ErrorType {
    ERROR_MESSAGE,
    INVALID_NAME,
    INVALID_SURNAME,
    INVALID_LOGIN,
    INVALID_PASSWORD,
    INVALID_EMAIL,
    INVALID_PHONE_NUMBER,
    INVALID_PASSWORD_NUMBER,
    INVALID_INPUT,
    EMAIL_IS_NOT_FREE,
    EMPTY_STRING,
    LOGIN_IS_NOT_FREE,
    EXCEPTION;

    private ErrorType(){}
}
