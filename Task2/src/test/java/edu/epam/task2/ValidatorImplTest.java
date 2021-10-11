package edu.epam.task2;

import edu.epam.task2.validator.inputformat.impl.ValidatorImpl;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ValidatorImplTest {
    ValidatorImpl validator = new ValidatorImpl();

    @Test
    public void testIsValid() {
        String line = "45    65 343";
        boolean resultFromMethod = validator.isValid(line);
        assertTrue(resultFromMethod);
    }
    @Test
    public void testIsNotValid() {
        String line = "45    65 343 554d";
        boolean resultFromMethod = validator.isValid(line);
        assertFalse(resultFromMethod);
    }

    @Test
    public void testIsNotValidFourNumbers() {
        String line = "45    65 343 554";
        boolean resultFromMethod = validator.isValid(line);
        assertFalse(resultFromMethod);
    }
}