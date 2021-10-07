package edu.epam.firsttask.validation;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    static Logger logger = LogManager.getLogger(Validator.class);
    private static final Pattern STRING_FORMAT_CHECKER = Pattern.compile("^-?\\d+(\\s(-?\\d+))*$");

    public boolean isValid(String line){
        Matcher matcher = STRING_FORMAT_CHECKER.matcher(line);
        boolean isValid = matcher.matches();

        logger.log(Level.INFO, line + ": " + isValid);
        return isValid;
    }
}
