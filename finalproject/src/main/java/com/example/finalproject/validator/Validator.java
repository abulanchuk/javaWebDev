package com.example.finalproject.validator;

import java.util.Map;

/**
 * The interface Validator.
 */
public interface Validator {
    /**
     * Is rating valid boolean.
     *
     * @param rating the rating
     * @return the boolean (is correct or not)
     */
    boolean isRatingValid(byte rating);

    /**
     * Is password number valid boolean.
     *
     * @param line the line
     * @return the boolean (is correct or not)
     */
    boolean isPasswordNumberValid(String line);

    /**
     * Is email valid boolean.
     *
     * @param line the line
     * @return the boolean (is correct or not)
     */
    boolean isEmailValid(String line);

    /**
     * Is correct login boolean.
     *
     * @param login the login
     * @return the boolean (is correct or not)
     */
    boolean isCorrectLogin(String login);

    /**
     * Is correct password boolean.
     *
     * @param password the password
     * @return the boolean (is correct or not)
     */
    boolean isCorrectPassword(String password);

    /**
     * Is correct name boolean.
     *
     * @param name the name
     * @return the boolean (is correct or not)
     */
    boolean isCorrectName(String name);

    /**
     * Is correct surname boolean.
     *
     * @param surname the surname
     * @return the boolean (is correct or not)
     */
    boolean isCorrectSurname(String surname);

    /**
     * Is correct phone number boolean.
     *
     * @param phoneNumber the phone number
     * @return the boolean (is correct or not)
     */
    boolean isCorrectPhoneNumber(String phoneNumber);

    /**
     * Is percent valid boolean.
     *
     * @param percent the percent
     * @return the boolean (is correct or not)
     */
    boolean isPercentValid(byte percent);

    /**
     * Is room number valid boolean.
     *
     * @param numberOfRoom the number of room
     * @return the boolean (is correct or not)
     */
    boolean isRoomNumberValid(String numberOfRoom);

    /**
     * Is price of room valid boolean.
     *
     * @param priceRoom the price room
     * @return the boolean (is correct or not)
     */
    boolean isPriceOfRoomValid(String priceRoom);

    /**
     * Is deposit an account valid boolean.
     *
     * @param sumOfMoney the sum of money
     * @return the boolean (is correct or not)
     */
    boolean isDepositAnAccountValid(String sumOfMoney);

    /**
     * Is floor valid boolean.
     *
     * @param floor the floor
     * @return the boolean (is correct or not)
     */
    boolean isFloorValid(String floor);

    /**
     * Is room type valid boolean.
     *
     * @param roomType the room type
     * @return the boolean (is correct or not)
     */
    boolean isRoomTypeValid(String roomType);

    /**
     * Is id discount valid boolean.
     *
     * @param idDiscount the id discount
     * @return the boolean (is correct or not)
     */
    boolean isIdDiscountValid(String idDiscount);

    /**
     * Check registration client boolean.
     *
     * @param map the map
     * @return the boolean (is correct or not)
     */
    boolean checkRegistrationClient(Map<String, String> map);

    /**
     * Check registration butler or owner boolean.
     *
     * @param map the map
     * @return the boolean (is correct or not)
     */
    boolean checkRegistrationButlerOrOwner(Map<String, String> map);

    /**
     * Check dates from orders boolean.
     *
     * @param order the order
     * @return the boolean (is correct or not)
     */
    boolean checkDatesFromOrders(Map<String, String> order);
}
