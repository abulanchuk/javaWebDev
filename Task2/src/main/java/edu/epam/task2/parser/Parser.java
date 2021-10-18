package edu.epam.task2.parser;

import edu.epam.task2.exception.SymbolException;

public interface Parser {
    double[] convertStringToDoubles(String line) throws SymbolException;
}
