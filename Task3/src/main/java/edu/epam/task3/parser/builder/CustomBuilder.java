package edu.epam.task3.parser.builder;

import edu.epam.task3.exception.ParserException;
import entity.Sweet;

import java.util.Set;

public interface CustomBuilder {
    void buildSweetSet(String xmlPath) throws ParserException;
     Set<Sweet> getSweets();
}
