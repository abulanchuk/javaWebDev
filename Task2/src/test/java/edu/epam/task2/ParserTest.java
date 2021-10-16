package edu.epam.task2;

import edu.epam.task2.exception.SymbolException;
import edu.epam.task2.parser.Parser;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ParserTest {
    Parser parser = new Parser();

    @Test
    public void testConvertStringToDoubles() throws SymbolException {
        String input = "12 12 4 3";
        double[] output = parser.convertStringToDoubles(input);
        double[] correctAnswer = {12, 12, 4, 3};
        assertEquals(correctAnswer, output);
    }
}