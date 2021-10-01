package edu.epam.pretask.validation;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    Pattern pattern = Pattern.compile("([+-]?[0-9]*[.][0-9]*)|([+-]?[0-9]+[Ee][+-]?[0-9]+)");
    static Logger logger = LogManager.getLogger();

    public boolean isValid(String line) {
        if (line.equals(".")) {
            return false;
        }

        Matcher matcher = pattern.matcher(line);
        boolean isValid = matcher.matches();

        logger.log(Level.INFO, "edu.epam.pretask.validator: " + line + ": " + isValid);
        return isValid;

    }
}
