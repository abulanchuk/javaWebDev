package edu.epam.firsttask;

import edu.epam.firsttask.entity.CustomArray;
import edu.epam.firsttask.exception.SymbolException;
import edu.epam.firsttask.factory.CustomArrayFactory;
import edu.epam.firsttask.parser.Parser;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ParserTest {

    @Test
    public void testFromString() throws SymbolException {
        String line = "123   56 4 8";
        CustomArray numbers = CustomArrayFactory.fromIntegers(123, 56, 4, 8);
        CustomArray parsedNumbers = Parser.fromString(line);
        assertEquals(numbers.getArray(), parsedNumbers.getArray());
    }

}