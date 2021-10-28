package edu.epam.task2;

import edu.epam.task2.validator.inputformat.impl.ValidatorImpl;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ValidatorImplTest {
    ValidatorImpl validator = new ValidatorImpl();

    @Test
    public void testIsValid() {
        String line = "2.3 2.5 2.6 2.5";
        boolean resultFromMethod = validator.isValid(line);
        assertTrue(resultFromMethod);
    }
    @Test
    public void testIsNotValid() {
        String line = "45.4 65 343 554d";
        boolean resultFromMethod = validator.isValid(line);
        assertFalse(resultFromMethod);
    }

    @Test
    public void testIsValidFourNumbers() {
        String line = "443.4 5.5 343.5 3.5";
        boolean resultFromMethod = validator.isValid(line);
        assertTrue(resultFromMethod);
    }
}