package edu.epam.firsttask;

import edu.epam.firsttask.validation.Validator;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ValidatorTest {
    Validator validator = new Validator();

    @Test
    public void testIsValid() {
        String line = "12 14 34";
        boolean isValid = validator.isValid(line);
        assertTrue(isValid);
    }

    @Test
    public void testIsNotValid() {
        String line = "12n 14 34";
        boolean isValid = validator.isValid(line);
        assertFalse(isValid);
    }

    @Test
    public void testIsNotValidSecond() {
        String line = "12, 140 34";
        boolean isValid = validator.isValid(line);
        assertFalse(isValid);
    }

}