package edu.epam.firsttask.operator;

import edu.epam.firsttask.entity.CustomArray;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Arrays;

public class Operator {
    static Logger logger = LogManager.getLogger(Operator.class);

    public int findMinValue(CustomArray array) {
        // TODO: empty array?
        int minValue = array.get(0);

        for (int i = 1; i < array.getLength(); i++) {
            if (array.get(i) < minValue) {
                minValue = array.get(i);
            }
        }
        logger.log(Level.INFO, "The minimum value is: " + minValue);
        return minValue;
    }

    public int findMaxValue(CustomArray array) {
        int maxValue = array.get(0);
        for (int i = 0; i < array.getLength(); i++) {
            if (array.get(i) > maxValue) {
                maxValue = array.get(i);
            }
        }
        logger.log(Level.INFO,  "The maximum value is: " + maxValue);
        return maxValue;
    }

    public long sumOfElements(CustomArray array) {
        long sum = 0;
        for (int i = 0; i < array.getLength(); i++) {
            sum += array.get(i);
        }
        logger.log(Level.INFO, "The sum of elements is: " + sum);
        return sum;
    }

    public double findAverageNumber(CustomArray array) {
        if (array.getLength() == 0) {
            throw new RuntimeException("Empty array");
        }
        logger.log(Level.INFO, "The average number of elements is: " + (sumOfElements(array) / array.getLength()));
        return (double) sumOfElements(array) / array.getLength();
    }

    public int countPositiveNumbers(CustomArray array) {
        int positiveCounter = 0;
        for (int i = 0; i < array.getLength(); i++) {
            if (array.get(i) > 0) {
                positiveCounter++;
            }
        }
        logger.log(Level.INFO, "Number of positive elements: " + positiveCounter);
        return positiveCounter;
    }

    public int countNegativeNumbers(CustomArray array) {
        int negativeCounter = 0;
        for (int i = 0; i < array.getLength(); i++) {
            if (array.get(i) < 0) {
                negativeCounter++;
            }
        }
        logger.log(Level.INFO, "Number of negative elements: " + negativeCounter);
        return negativeCounter;
    }

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
