package com.example.finalproject.util.validator;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ClientValidatorTest {

    @Test
    public void testIsPasswordNumberValid() {
        String passwordNumber = "MP3432211";
        boolean resultFromMethod = ClientValidator.isPasswordNumberValid(passwordNumber);
        assertTrue(resultFromMethod);
    }

    @Test
    public void testIsPasswordNumberInvalid() {
        String passwordNumber = "M23432211";
        boolean resultFromMethod = ClientValidator.isPasswordNumberValid(passwordNumber);
        assertFalse(resultFromMethod);
    }

    @Test
    public void testIsEmailValid() {
        String email = "anna-9900@tut.by";
        boolean resultFromMethod = ClientValidator.isEmailValid(email);
        assertTrue(resultFromMethod);
    }

    @Test
    public void testIsEmailInvalid() {
        String email = "anna!9900@tut.by";
        boolean resultFromMethod = ClientValidator.isEmailValid(email);
        assertFalse(resultFromMethod);
    }
}