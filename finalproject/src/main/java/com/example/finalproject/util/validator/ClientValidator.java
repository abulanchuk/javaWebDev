package com.example.finalproject.util.validator;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientValidator {
    private static Logger logger = LogManager.getLogger(ClientValidator.class);
    private static final String STRING_PASSWORD_NUMBER_CHECKER = "[A-Z]{2}[0-9]{7}";
    private static final String STRING_EMAIL_CHECKER = "^[A-Za-z0-9-.]{1,30}@[a-z]{2,7}\\.[a-z]{2,4}$";
    public ClientValidator() {
    }

    public static boolean isPasswordNumberValid(String line) {
        Pattern pattern = Pattern.compile(STRING_PASSWORD_NUMBER_CHECKER);
        Matcher matcher = pattern.matcher(line);
        boolean isValid = matcher.matches();

        logger.log(Level.INFO, line + ": " + isValid);
        return isValid;
    }

    public static boolean isEmailValid(String line) {
        Pattern pattern = Pattern.compile(STRING_EMAIL_CHECKER);
        Matcher matcher = pattern.matcher(line);
        boolean isValid = matcher.matches();

        logger.log(Level.INFO, line + ": " + isValid);
        return isValid;
    }
}
