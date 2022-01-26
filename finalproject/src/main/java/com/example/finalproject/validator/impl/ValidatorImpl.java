package com.example.finalproject.validator.impl;

import com.example.finalproject.validator.Validator;


import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.example.finalproject.controller.ErrorType.*;
import static com.example.finalproject.controller.QueryNamedArguments.*;


public class ValidatorImpl implements Validator {
    private static final String STRING_PASSPORT_NUMBER_PATTERN = "[A-Z]{2}[0-9]{7}";
    private static final String STRING_EMAIL_PATTERN = "^[A-Za-z0-9-.]{1,30}@[a-z]{2,7}\\.[a-z]{2,4}$";
   private static final String NAME_PATTERN = "^[A-ZА-Я][a-zа-я]{1,30}$";
    private static final String SURNAME_PATTERN = "^[A-ZА-Я][a-zа-я]{2,50}$";
    private static final String LOGIN_PATTERN = "[A-Za-z]{8,30}";
    private static final String USER_PASSWORD_PATTERN = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";
    private static final String MOBILE_NUMBER_PATTERN = "(25|29|33|44)\\d{7}";
    private static final String NUMBER_OF_ROOM_PATTERN = "\\d+";
    private static final String NUMBER_OF_FLOOR_PATTERN = "[1-3]";
    private static final String PRICE_OF_ROOM_PATTERN = "\\d{1,3}(?:[.,]\\d{3})*(?:[.,]\\d{2})";
    private static final String ID_DISCOUNT_PATTERN = "^[+]?[1-9]+(\\d+)?$";
    private static ValidatorImpl instance;

    public ValidatorImpl() {
    }

    public static ValidatorImpl getInstance() {
        if (instance == null) {
            instance = new ValidatorImpl();
        }
        return instance;
    }

    public boolean isRatingValid(byte rating) {
        return rating >= 0 && rating <= 10;
    }

    public boolean isPasswordNumberValid(String line) {
        Pattern pattern = Pattern.compile(STRING_PASSPORT_NUMBER_PATTERN);
        Matcher matcher = pattern.matcher(line);
        boolean isValid = matcher.matches();

        return isValid;
    }

    public boolean isEmailValid(String line) {
        Pattern pattern = Pattern.compile(STRING_EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(line);
        boolean isValid = matcher.matches();
        return isValid;
    }

    public boolean isCorrectLogin(String login) {
        return isNotNullOrEmpty(login) && login.matches(LOGIN_PATTERN);
    }

    public boolean isCorrectPassword(String password) {
        return isNotNullOrEmpty(password) && password.matches(USER_PASSWORD_PATTERN);
    }

    public boolean isCorrectPhoneNumber(String phoneNumber) {
        return isNotNullOrEmpty(phoneNumber) && phoneNumber.matches(MOBILE_NUMBER_PATTERN);
    }

    public boolean isPercentValid(byte percent) {
        return percent >= 0 && percent <= 100;
    }

    @Override
    public boolean isRoomNumberValid(String numberOfRoom) {
        return isNotNullOrEmpty(numberOfRoom) && numberOfRoom.matches(NUMBER_OF_ROOM_PATTERN);
    }

    @Override
    public boolean isPriceOfRoomValid(String priceRoom) {
        return isNotNullOrEmpty(priceRoom) && priceRoom.matches(PRICE_OF_ROOM_PATTERN);
    }

    @Override
    public boolean isFloorValid(String floor) {
        return isNotNullOrEmpty(floor) && floor.matches(NUMBER_OF_FLOOR_PATTERN);
    }

    @Override
    public boolean isRoomTypeValid(String roomType) {
        return roomType.equals("CLIENT") || roomType.equals("OWNER") || roomType.equals("BUTLER");
    }

    @Override
    public boolean isIdDiscountValid(String idDiscount) {
        return isNotNullOrEmpty(idDiscount) && idDiscount.matches(ID_DISCOUNT_PATTERN);
    }

    public boolean isCorrectName(String name) {
        return isNotNullOrEmpty(name) && name.matches(NAME_PATTERN);
    }

    public boolean isCorrectSurname(String surname) {
        return isNotNullOrEmpty(surname) && surname.matches(SURNAME_PATTERN);
    }

    private boolean isNotNullOrEmpty(String line) {
        return line != null && !line.isEmpty();
    }


    @Override
    public boolean checkRegistration(Map<String, String> map) {
        boolean result = true;
        String login = map.get(LOGIN);
        String password = map.get(PASSWORD);
        String name = map.get(NAME);
        String surname = map.get(SURNAME);
        String phone = map.get(PHONE_NUMBER);
        String passwordNumber = map.get(PASSPORT_NUMBER);
        String email = map.get(EMAIL);

        if (!isCorrectName(name)) {
            map.put(NAME, INVALID_NAME.name().toLowerCase(Locale.ROOT));
            result = false;
        }
        if (!isCorrectName(surname)) {
            map.put(SURNAME, INVALID_SURNAME.name().toLowerCase(Locale.ROOT));
            result = false;
        }
        if (!isCorrectLogin(login)) {
            map.put(LOGIN, INVALID_LOGIN.name().toLowerCase(Locale.ROOT));
            result = false;
        }
        if (!isCorrectPassword(password)) {
            map.put(PASSWORD, INVALID_PASSWORD.name().toLowerCase(Locale.ROOT));
            result = false;
        }
        if (!isEmailValid(email)) {
            map.put(EMAIL, INVALID_EMAIL.name().toLowerCase(Locale.ROOT));
            result = false;
        }
        if (!isCorrectPhoneNumber(phone)) {
            map.put(PHONE_NUMBER, INVALID_PHONE_NUMBER.name().toLowerCase(Locale.ROOT));
            result = false;
        }
        if (!isPasswordNumberValid(passwordNumber)) {
            map.put(PASSPORT_NUMBER, INVALID_PASSWORD_NUMBER.name().toLowerCase(Locale.ROOT));
            result = false;
        }
        return result;
    }


}
