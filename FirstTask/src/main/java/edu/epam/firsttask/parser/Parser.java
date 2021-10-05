package edu.epam.firsttask.parser;

import edu.epam.firsttask.entity.CustomArray;
import edu.epam.firsttask.exception.SymbolException;
import edu.epam.firsttask.validation.Validator;

public class Parser {
    public static CustomArray fromString(String string) throws SymbolException {
        Validator validator = new Validator();
        if (validator.isValid(string)) {
            String[] numberInString = string.split(" ");
            int[] numbers = new int[numberInString.length];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = Integer.parseInt(numberInString[i]);
            }
            return new CustomArray(numbers);
        } else {
            throw new SymbolException("wrong format");
        }
    }
}
