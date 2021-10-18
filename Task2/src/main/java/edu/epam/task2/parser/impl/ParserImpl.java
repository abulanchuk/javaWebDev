package edu.epam.task2.parser.impl;

import edu.epam.task2.exception.SymbolException;
import edu.epam.task2.parser.Parser;
import edu.epam.task2.validator.inputformat.impl.ValidatorImpl;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Arrays;


public class ParserImpl implements Parser {
    static Logger logger = LogManager.getLogger(ParserImpl.class);
    private static final String SPLIT_REGEX = "\\s+";

    public double[] convertStringToDoubles(String line) throws SymbolException {
        ValidatorImpl validator = new ValidatorImpl();
        if (!validator.isValid(line)) {
            logger.log(Level.ERROR, "Wrong format" + line);
            throw new SymbolException("Wrong format");
        }

        return Arrays.stream(line.split(SPLIT_REGEX))
                .mapToDouble(Float::parseFloat)
                .toArray();

    }
}
