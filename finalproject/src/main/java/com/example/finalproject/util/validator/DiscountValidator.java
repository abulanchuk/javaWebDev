package com.example.finalproject.util.validator;


public class DiscountValidator {

    public DiscountValidator() {
    }

    public static boolean isPercentValid(byte percent) {
        return percent >= 0 && percent <= 100;
    }
}
