package edu.epam.task2.parser;

import edu.epam.task2.exception.SymbolException;

public interface StringParser {
    double[] convertStringToDoubles(String line) throws SymbolException;
}
