package edu.epam.firsttask.operator.impl;

import edu.epam.firsttask.entity.CustomArray;

import edu.epam.firsttask.operator.Operator;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class OperatorImpl implements Operator {
    static Logger logger = LogManager.getLogger(OperatorImpl.class);

    @Override
    public OptionalInt findMinValue(CustomArray array) {
        if (array.getLength() == 0) {
            return OptionalInt.empty();
        }

        int minValue = array.get(0);
        for (int i = 1; i < array.getLength(); i++) {
            if (array.get(i) < minValue) {
                minValue = array.get(i);
            }
        }

        logger.log(Level.INFO, "The minimum value is: " + minValue);
        return OptionalInt.of(minValue);
    }

    @Override
    public OptionalInt findMaxValue(CustomArray array) {
        if (array.getLength() == 0) {
            return OptionalInt.empty();
        }

        int maxValue = array.get(0);
        for (int i = 0; i < array.getLength(); i++) {
            if (array.get(i) > maxValue) {
                maxValue = array.get(i);
            }
        }
        logger.log(Level.INFO, "The maximum value is: " + maxValue);
        return OptionalInt.of(maxValue);
    }

    @Override
    public long sumOfElements(CustomArray array) {
        long sum = 0;
        for (int i = 0; i < array.getLength(); i++) {
            sum += array.get(i);
        }
        logger.log(Level.INFO, "The sum of elements is: " + sum);
        return sum;
    }

    @Override
    public OptionalDouble findAverageNumber(CustomArray array) {
        if (array.getLength() == 0) {
            return OptionalDouble.empty();
        }
        double averageNumber = (double) sumOfElements(array) / array.getLength();
        logger.log(Level.INFO, "The average number of elements is: " + averageNumber);
        return OptionalDouble.of(averageNumber);
    }

    @Override
    public long countPositiveNumbers(CustomArray array) {
        long positiveCounter = 0;
        for (int i = 0; i < array.getLength(); i++) {
            if (array.get(i) > 0) {
                positiveCounter++;
            }
        }
        logger.log(Level.INFO, "Number of positive elements: " + positiveCounter);
        return positiveCounter;
    }

    @Override
    public long countNegativeNumbers(CustomArray array) {
        long negativeCounter = 0;
        for (int i = 0; i < array.getLength(); i++) {
            if (array.get(i) < 0) {
                negativeCounter++;
            }
        }
        logger.log(Level.INFO, "Number of negative elements: " + negativeCounter);
        return negativeCounter;
    }

    @Override
    public CustomArray replaceNegativeWithPositive(CustomArray array) {
        int[] integerArray = array.getArray();
        for (int i = 0; i < integerArray.length; i++) {
            if (integerArray[i] < 0) {
                integerArray[i] = integerArray[i] * (-1);
            }
        }
        logger.log(Level.INFO, "Array after replacing negative elements: " + Arrays.toString(integerArray));
        return new CustomArray(integerArray);
    }
}
