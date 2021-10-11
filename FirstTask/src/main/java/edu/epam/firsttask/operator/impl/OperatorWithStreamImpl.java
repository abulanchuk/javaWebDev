package edu.epam.firsttask.operator.impl;

import edu.epam.firsttask.entity.CustomArray;
import edu.epam.firsttask.operator.Operator;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class OperatorWithStreamImpl implements Operator {
    static Logger logger = LogManager.getLogger(OperatorImpl.class);

    @Override
    public OptionalInt findMinValue(CustomArray array) {
        OptionalInt minValue = Arrays.stream(array.getArray())
                .min();
        logger.log(Level.INFO, "The minimum value is (use IntStream): " + minValue);
        return minValue;
    }

    @Override
    public OptionalInt findMaxValue(CustomArray array) {
        OptionalInt maxValue = Arrays.stream(array.getArray())
                .max();
        logger.log(Level.INFO, "The maximum value is (use IntStream): " + maxValue);
        return maxValue;
    }

    @Override
    public long sumOfElements(CustomArray array) {
        long sum = Arrays.stream(array.getArray())
                .sum();
        logger.log(Level.INFO, "The sum of elements is (use IntStream): " + sum);
        return sum;
    }

    @Override
    public OptionalDouble findAverageNumber(CustomArray array) {
        OptionalDouble averageNumber = Arrays.stream(array.getArray())
                .average();
        logger.log(Level.INFO, "The average number of elements is (use IntStream): " + averageNumber);
        return averageNumber;
    }

    @Override
    public long countPositiveNumbers(CustomArray array) {
        long positiveCounter = Arrays.stream(array.getArray())
                .filter(n -> n > 0).count();
        logger.log(Level.INFO, "Number of positive elements (use IntStream): " + positiveCounter);
        return positiveCounter;
    }

    @Override
    public long countNegativeNumbers(CustomArray array) {
        long negativeCounter = Arrays.stream(array.getArray())
                .filter(n -> n < 0)
                .count();
        logger.log(Level.INFO, "Number of negative elements (use IntStream): " + negativeCounter);
        return negativeCounter;
    }

    @Override
    public CustomArray replaceNegativeWithPositive(CustomArray array) {
        int[] integerArray = array.getArray();
        int[] stream = Arrays.stream(integerArray)
                .map(Math::abs)
                .toArray();

        CustomArray customArray = new CustomArray(stream);
        logger.log(Level.INFO, "Array after replacing negative elements (use IntStream): " + customArray);
        return customArray;
    }
}
