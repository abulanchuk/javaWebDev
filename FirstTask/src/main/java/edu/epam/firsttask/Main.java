package edu.epam.firsttask;

import edu.epam.firsttask.entity.CustomArray;
import edu.epam.firsttask.exception.SymbolException;
import edu.epam.firsttask.factory.CustomArrayFactory;
import edu.epam.firsttask.operator.Operator;
import edu.epam.firsttask.parser.Parser;
import edu.epam.firsttask.sorting.Sorting;
import edu.epam.firsttask.validation.Validator;

public class Main {
    public static void main(String[] args) throws SymbolException {
        Validator v = new Validator();
        v.isValid("12 11 11 111");
        Parser parser = new Parser();
        Parser.fromString("123 433 4");
       CustomArray integerArray = CustomArrayFactory.fromIntegers(-12, 323, 23, 32);
        Operator operator = new Operator();

        operator.findMaxValue(integerArray);
        operator.findAverageNumber(integerArray);
        operator.countNegativeNumbers(integerArray);
        operator.findMinValue(integerArray);
        operator.countPositiveNumbers(integerArray);
        operator.replaceNegativeWithPositive(integerArray);

        Sorting sorting = new Sorting();
        CustomArray secondIntegerArray = CustomArrayFactory.fromIntegers(-12, -323, 230, 32);
        sorting.selectionSort(integerArray);
        CustomArray thirdIntegerArray = CustomArrayFactory.fromIntegers(12, -323, 230, -32);
        sorting.shellSort(integerArray);
        CustomArray fourthIntegerArray = CustomArrayFactory.fromIntegers(12, -323, -230, 32);
        sorting.sortByInserts(integerArray);
    }
}
