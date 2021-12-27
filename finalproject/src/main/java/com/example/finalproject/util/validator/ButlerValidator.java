package com.example.finalproject.util.validator;

public class ButlerValidator {
    public ButlerValidator() {
    }

    public static boolean isRatingValid(byte rating) {
        return rating >= 0 && rating <= 10;
    }
}
