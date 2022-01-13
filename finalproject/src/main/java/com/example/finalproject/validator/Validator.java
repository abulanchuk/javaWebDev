package com.example.finalproject.validator;

import java.util.Map;

public interface Validator {
    boolean isRatingValid(byte rating);
    boolean isPasswordNumberValid(String line);
    boolean isEmailValid(String line);
    boolean isCorrectLogin(String login);
    boolean isCorrectPassword(String password);
    boolean isCorrectName(String name);
    boolean isCorrectPhoneNumber(String phoneNumber);
    boolean isPercentValid(byte percent);
    boolean isRoomNumberValid(String numberOfRoom);
    boolean isPriceOfRoomValid(String priceRoom);
   // boolean checkRegistration(Map<String, String> map);
    boolean isLocaleExist(String locale);

}
