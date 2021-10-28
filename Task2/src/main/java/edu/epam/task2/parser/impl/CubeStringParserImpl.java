package edu.epam.task2.parser.impl;

import edu.epam.task2.exception.SymbolException;
import edu.epam.task2.parser.StringParser;
import edu.epam.task2.validator.inputformat.impl.ValidatorImpl;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Arrays;


public class CubeStringParserImpl implements StringParser {
   private static Logger logger = LogManager.getLogger(CubeStringParserImpl.class);
    private static final String SPLIT_REGEX = "\\s+";

    public double[] convertStringToDoubles(String line) throws SymbolException {
        if(line.isEmpty()){
            logger.log(Level.ERROR, "The file is empty. Fix this" +line);
            throw new SymbolException("The file is empty. Fix this");
        }
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
