package edu.epam.task2.parser;

import edu.epam.task2.entity.CustomPoint;
import edu.epam.task2.exception.SymbolException;
import edu.epam.task2.validator.inputformat.impl.ValidatorImpl;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Arrays;


public class Parser {
    static Logger logger = LogManager.getLogger(Parser.class);
    private static final String SPLIT_REGEX = "\\s+";

    public CustomPoint fromString(String line) throws SymbolException{
        ValidatorImpl validator = new ValidatorImpl();
        if (!validator.isValid(line)) {
            logger.log(Level.ERROR, "Wrong format" + line);
            throw new SymbolException("Wrong format");
        }

        double[] coordinates = Arrays.stream(line.split(SPLIT_REGEX)).mapToDouble(Float::parseFloat).toArray();

        return new CustomPoint(coordinates[0], coordinates[1], coordinates[2]);
    }
}
