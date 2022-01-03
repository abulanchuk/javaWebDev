package com.example.finalproject.util.validator;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ButlerValidator {
    private static Logger logger = LogManager.getLogger(ButlerValidator.class);
    public ButlerValidator() {
    }

    public static boolean isRatingValid(byte rating) {
        return rating >= 0 && rating <= 10;
    }
}
