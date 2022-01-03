package com.example.finalproject.util.validator;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DiscountValidatorTest {

    @Test
    public void testIsDiscountValid() {
        byte percent = 3;
        boolean resultFromMethod = DiscountValidator.isPercentValid(percent);
        assertTrue(resultFromMethod);
    }

    @Test
    public void testIsDiscountInvalid() {
        byte percent = -1;
        boolean resultFromMethod = DiscountValidator.isPercentValid(percent);
        assertFalse(resultFromMethod);
    }
}