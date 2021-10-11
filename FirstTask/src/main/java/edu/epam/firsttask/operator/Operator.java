package edu.epam.firsttask.operator;

import edu.epam.firsttask.entity.CustomArray;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public interface Operator {
    OptionalInt findMinValue(CustomArray array);

    OptionalInt findMaxValue(CustomArray array);

    long sumOfElements(CustomArray array);

    OptionalDouble findAverageNumber(CustomArray array);

    long countPositiveNumbers(CustomArray array);

    long countNegativeNumbers(CustomArray array);

    CustomArray replaceNegativeWithPositive(CustomArray array);
}
