package edu.epam.task2;

import edu.epam.task2.exception.SymbolException;
import edu.epam.task2.parser.impl.CubeParserImpl;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CubeParserImplTest {
    CubeParserImpl cubeParserImpl = new CubeParserImpl();

    @Test
    public void testConvertStringToDoubles() throws SymbolException {
        String input = "12 12 4 3";
        double[] output = cubeParserImpl.convertStringToDoubles(input);
        double[] correctAnswer = {12, 12, 4, 3};
        assertEquals(correctAnswer, output);
    }
}