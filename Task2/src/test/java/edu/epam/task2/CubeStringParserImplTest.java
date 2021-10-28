package edu.epam.task2;

import edu.epam.task2.exception.SymbolException;
import edu.epam.task2.parser.impl.CubeStringParserImpl;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class CubeStringParserImplTest {
    private final double TOLERANCE = 1e-06;
    CubeStringParserImpl cubeStringParserImpl = new CubeStringParserImpl();

    @Test
    public void testConvertStringToDoubles() throws SymbolException {
        String input = "12.3 12.3 4.5 3.5";
        double[] output = cubeStringParserImpl.convertStringToDoubles(input);
        double[] correctAnswer = {12.3, 12.3, 4.5, 3.5};
        for (int i = 0; i < correctAnswer.length; ++i) {
            assertEquals(output[i], correctAnswer[i], TOLERANCE);
        }
    }
}
