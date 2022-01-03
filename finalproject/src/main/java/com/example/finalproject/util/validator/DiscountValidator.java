package com.example.finalproject.util.validator;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class DiscountValidator {
    private static Logger logger = LogManager.getLogger(ClientValidator.class);

    public DiscountValidator() {
    }

    public static boolean isPercentValid(byte percent) {
        return percent >= 0 && percent <= 100;
    }
}
