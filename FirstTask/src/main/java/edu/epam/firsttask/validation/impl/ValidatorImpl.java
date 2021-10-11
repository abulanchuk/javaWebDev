package edu.epam.firsttask.validation.impl;

import edu.epam.firsttask.validation.Validator;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorImpl implements Validator {
    static Logger logger = LogManager.getLogger(ValidatorImpl.class);
    private static final String STRING_FORMAT = "^-?\\d+(\\s+(-?\\d+))*$";

    public boolean isValid(String line){
        Pattern pattern = Pattern.compile(STRING_FORMAT);
        Matcher matcher = pattern.matcher(line);
        boolean isValid = matcher.matches();

        logger.log(Level.INFO, line + ": " + isValid);
        return isValid;
    }
}
