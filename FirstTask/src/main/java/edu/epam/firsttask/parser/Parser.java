package edu.epam.firsttask.parser;

import edu.epam.firsttask.entity.CustomArray;
import edu.epam.firsttask.exception.SymbolException;
import edu.epam.firsttask.validation.impl.ValidatorImpl;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class Parser {
    static Logger logger = LogManager.getLogger(Parser.class);
    private static final String SPLIT_REGEX = "\\s+";

    public static CustomArray fromString(String string) throws SymbolException {
        ValidatorImpl validator = new ValidatorImpl();

        if (!validator.isValid(string)) {
            logger.log(Level.ERROR, "Wrong format" + string);
            throw new SymbolException("Wrong format");
        }

        String[] numberInString = string.split(SPLIT_REGEX);
        int[] numbers = new int[numberInString.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(numberInString[i]);
        }
        return new CustomArray(numbers);
    }
}
