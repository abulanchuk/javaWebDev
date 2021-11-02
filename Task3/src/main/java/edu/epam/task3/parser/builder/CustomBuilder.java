package edu.epam.task3.parser.builder;

import edu.epam.task3.exception.ParserException;

public interface CustomBuilder {
    void buildSweetSet(String xmlPath) throws ParserException;
}
