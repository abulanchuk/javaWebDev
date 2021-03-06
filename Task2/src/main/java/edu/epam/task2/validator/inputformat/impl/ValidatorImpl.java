package edu.epam.task2.validator.inputformat.impl;

import edu.epam.task2.validator.inputformat.Validator;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorImpl implements Validator {
    private static Logger logger = LogManager.getLogger(ValidatorImpl.class);
    private static final String STRING_CUBE_FORMAT_COORDINATE = "^(([+-]?[0-9]*[.][0-9]*)\\s+){3}([+-]?[0-9]*[.][0-9]*)$";

    @Override
    public boolean isValid(String line) {
        Pattern pattern = Pattern.compile(STRING_CUBE_FORMAT_COORDINATE);
        Matcher matcher = pattern.matcher(line);
        boolean isValid = matcher.matches();

        logger.log(Level.INFO, line + ": " + isValid);
        return isValid;
    }
}
