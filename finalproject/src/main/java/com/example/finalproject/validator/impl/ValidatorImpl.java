package com.example.finalproject.validator.impl;

import com.example.finalproject.validator.Validator;


import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ValidatorImpl implements Validator {
    private static final String STRING_PASSWORD_NUMBER_PATTERN = "[A-Z]{2}[0-9]{7}";
    private static final String STRING_EMAIL_PATTERN = "^[A-Za-z0-9-.]{1,30}@[a-z]{2,7}\\.[a-z]{2,4}$";
   private static final String NAME_PATTERN = "^[A-Za-zА-Яа-я]{2,50}$";
    private static final String LOGIN_PATTERN = "[A-Za-z]\\w{1,19}";
    private static final String USER_PASSWORD_PATTERN = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";
    private static final String MOBILE_NUMBER_PATTERN = "(25|29|33|44)\\d{7}";
    private static final String NUMBER_OF_ROOM_PATTERN = "\\d+";
    private static final String PRICE_OF_ROOM_PATTERN = "\\d{1,3}(?:[.,]\\d{3})*(?:[.,]\\d{2})";
    private static final String ENGLISH_LOCALE = "en_US";
    private static final String RUSSIAN_LOCALE = "ru_RU";
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
        Pattern pattern = Pattern.compile(STRING_PASSWORD_NUMBER_PATTERN);
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

    public boolean isCorrectName(String name) {
        return isNotNullOrEmpty(name) && name.matches(NAME_PATTERN);
    }

    private boolean isNotNullOrEmpty(String line) {
        return line != null && !line.isEmpty();
    }


//    @Override
//    public boolean checkRegistration(Map<String, String> map) {
//        return false;
//    }
//        /*boolean result = true;
//        String login = map.get(USERS_LOGIN);
//        String password = map.get(USERS_PASSWORD);
//        String name = map.get(USERS_NAME);
//        String surname = map.get(USERS_SURNAME);
//        String phone = map.get(USERS_PHONE_NUMBER);
//        String passwordNumber = map.get(CLIENTS_PASSWORD_NUMBER);
//        String email = map.get(CLIENTS_EMAIL);
//
//        if (!isCorrectName(name)) {
//            map.put(USERS_NAME, INVALID_NAME);
//            result = false;
//        }
//        if (!isCorrectName(surname)) {
//            map.put(USERS_SURNAME, INVALID_SURNAME);
//            result = false;
//        }
//        if (!isCorrectLogin(login)) {
//            map.put(USERS_LOGIN, INVALID_LOGIN);
//            result = false;
//        }
//        if (!isCorrectPassword(password)) {
//            map.put(USERS_PASSWORD, INVALID_PASSWORD);
//            result = false;
//        }
//        if (!isEmailValid(email)) {
//            map.put(CLIENTS_EMAIL, INVALID_EMAIL);
//            result = false;
//        }
//        if (!isCorrectPhoneNumber(phone)) {
//            map.put(USERS_PHONE_NUMBER, INVALID_PHONE_NUMBER);
//            result = false;
//        }
//        if (!isPasswordNumberValid(passwordNumber)) {
//            map.put(CLIENTS_PASSWORD_NUMBER, INVALID_PASSWORD_NUMBER);
//            result = false;
//        }
//        return result;
//    }
//
    public boolean isLocaleExist(String locale) {
        return locale != null && locale.matches(ENGLISH_LOCALE + "|" + RUSSIAN_LOCALE);
    }

}
