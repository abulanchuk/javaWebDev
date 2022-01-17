package com.example.finalproject.validatorImpl;

import com.example.finalproject.validator.impl.ValidatorImpl;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ValidatorImplTest {
ValidatorImpl validator = new ValidatorImpl();
    @Test
    public void testIsRatingValid() {
        byte rating = 3;
        boolean resultFromMethod = validator.isRatingValid(rating);
        assertTrue(resultFromMethod);
    }

    @Test
    public void testIsRatingInvalid() {
        byte rating = 11;
        boolean resultFromMethod = validator.isRatingValid(rating);
        assertFalse(resultFromMethod);
    }

    @Test
    public void testIsDiscountValid() {
        byte percent = 3;
        boolean resultFromMethod = validator.isPercentValid(percent);
        assertTrue(resultFromMethod);
    }

    @Test
    public void testIsDiscountInvalid() {
        byte percent = -1;
        boolean resultFromMethod = validator.isPercentValid(percent);
        assertFalse(resultFromMethod);
    }

    @Test
    public void testIsEmailValid() {
        String email = "anna-9900@tut.by";
        boolean resultFromMethod = validator.isEmailValid(email);
        assertTrue(resultFromMethod);
    }

    @Test
    public void testIsEmailInvalid() {
        String email = "anna!9900@tut.by";
        boolean resultFromMethod = validator.isEmailValid(email);
        assertFalse(resultFromMethod);
    }

    @Test
    public void testIsPasswordNumberValid() {
        String passwordNumber = "MP3432211";
        boolean resultFromMethod = validator.isPasswordNumberValid(passwordNumber);
        assertTrue(resultFromMethod);
    }

    @Test
    public void testIsPasswordNumberInvalid() {
        String passwordNumber = "M23432211";
        boolean resultFromMethod = validator.isPasswordNumberValid(passwordNumber);
        assertFalse(resultFromMethod);
    }

    @Test
    public void testIsCorrectLogin(){
        String login = "katebaskova";
        boolean resultFromMethod = validator.isCorrectLogin(login);
        assertTrue(resultFromMethod);
    }

    @Test
    public void testIsCorrectPhoneNumber(){
        String phoneNumber = "297865533";
        boolean resultFromMethod = validator.isCorrectPhoneNumber(phoneNumber);
        assertTrue(resultFromMethod);
    }

    @Test
    public void testIsNotCorrectPhoneNumber(){
        String phoneNumber = "237865533";
        boolean resultFromMethod = validator.isCorrectPhoneNumber(phoneNumber);
        assertFalse(resultFromMethod);
    }

    @Test
    public void testIsCorrectPassword(){
        String password = "JackJonson-12";
        boolean resultFromMethod = validator.isCorrectPassword(password);
        assertTrue(resultFromMethod);
    }

    @Test
    public void testIsNotCorrectPassword(){
        String password = "JackJonson11";
        boolean resultFromMethod = validator.isCorrectPassword(password);
        assertFalse(resultFromMethod);
    }

    @Test
    public void testIsNotCorrectName(){
        String name = "Jack2";
        boolean resultFromMethod = validator.isCorrectName(name);
        assertFalse(resultFromMethod);
    }

    @Test
    public void testIsCorrectName(){
        String name = "Jack";
        boolean resultFromMethod = validator.isCorrectName(name);
        assertTrue(resultFromMethod);
    }

    @Test
    public void testIsNotCorrectSurname(){
        String surname = "JhonsanN";
        boolean resultFromMethod = validator.isCorrectSurname(surname);
        assertFalse(resultFromMethod);
    }

    @Test
    public void testIsCorrectSurname(){
        String surname = "Jhonsan";
        boolean resultFromMethod = validator.isCorrectName(surname);
        assertTrue(resultFromMethod);
    }
}