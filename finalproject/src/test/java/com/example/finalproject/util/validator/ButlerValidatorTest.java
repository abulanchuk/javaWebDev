package com.example.finalproject.util.validator;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ButlerValidatorTest {

    @Test
    public void testIsRatingValid() {
        byte rating = 3;
        boolean resultFromMethod = ButlerValidator.isRatingValid(rating);
        assertTrue(resultFromMethod);
    }

    @Test
    public void testIsRatingInvalid() {
        byte rating = 11;
        boolean resultFromMethod = ButlerValidator.isRatingValid(rating);
        assertFalse(resultFromMethod);
    }
}