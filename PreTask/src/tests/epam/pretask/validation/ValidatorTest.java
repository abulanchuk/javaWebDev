package tests.epam.pretask.validation;

import edu.epam.pretask.validation.Validator;
import org.junit.jupiter.api.Assertions;

class ValidatorTest {

    @org.junit.jupiter.api.Test
    void isValid() {
        Validator validator = new Validator();
        Assertions.assertTrue(validator.isValid("1234.44"));
        Assertions.assertTrue(validator.isValid("1234."));
        Assertions.assertTrue(validator.isValid(".0"));
        Assertions.assertTrue(validator.isValid("1e+05"));
        Assertions.assertTrue(validator.isValid("1e-05"));
        Assertions.assertTrue(validator.isValid("1123444e05"));
        Assertions.assertTrue(validator.isValid("-2e5"));

        Assertions.assertFalse(validator.isValid("asfdsgfdsg"));
        Assertions.assertFalse(validator.isValid(""));
        Assertions.assertFalse(validator.isValid("."));
        Assertions.assertFalse(validator.isValid("4234"));
    }
}