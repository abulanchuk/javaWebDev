package edu.epam.firsttask.validation;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    static Logger logger = LogManager.getRootLogger();
    private static final Pattern REG_EXP = Pattern.compile("^-?\\d+(\\s(-?\\d+))*$");


    public boolean isValid(String line){
        Matcher matcher = REG_EXP.matcher(line);
        boolean isValid = matcher.matches();

        logger.log(Level.INFO, "edu.epam.firstTask.validator: " + line + ": " + isValid);
        return isValid;
    }
}
