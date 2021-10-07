package edu.epam.firsttask.operator;

import edu.epam.firsttask.entity.CustomArray;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class OperatorWithStream {
    static Logger logger = LogManager.getLogger(Operator.class);

    public int findMinValue(CustomArray array) {
        // TODO: empty array?
        int minValue = Arrays.stream(array.getArray())
                .min()
                .getAsInt();
        logger.log(Level.INFO, "The minimum value is (use IntStream): " + minValue);
        return minValue;
    }

    public int findMaxValue(CustomArray array) {
        int maxValue = Arrays.stream(array.getArray())
                .max()
                .getAsInt();
        logger.log(Level.INFO, "The maximum value is (use IntStream): " + maxValue);
        return maxValue;
    }

    public long sumOfElements(CustomArray array) {
        long sum = Arrays.stream(array.getArray())
                .sum();
        logger.log(Level.INFO, "The sum of elements is (use IntStream): " + sum);
        return sum;
    }

    public double findAverageNumber(CustomArray array) {
        double avarage = Arrays.stream(array.getArray())
                .average()
                .getAsDouble();
        logger.log(Level.INFO, "The average number of elements is (use IntStream): " + avarage);
        return avarage;
    }

    public long countPositiveNumbers(CustomArray array) {
        long positiveCounter = Arrays.stream(array.getArray())
                .filter(n -> n > 0).count();
        logger.log(Level.INFO, "Number of positive elements (use IntStream): " + positiveCounter);
        return positiveCounter;
    }

    public long countNegativeNumbers(CustomArray array) {
        long negativeCounter = Arrays.stream(array.getArray())
                .filter(n -> n < 0)
                .count();
        logger.log(Level.INFO, "Number of negative elements (use IntStream): " + negativeCounter);
        return negativeCounter;
    }

    public CustomArray replaceNegativeWithPositive(CustomArray array) {
        int[] integerArray = array.getArray();
        //IntStream stream1 = Arrays.stream(integerArray);
        int [] stream1 = Arrays.stream(integerArray).map(Math::abs).toArray();

        logger.log(Level.INFO, "Array after replacing negative elements (use IntStream): " + stream1);
        return new CustomArray(stream1);
    }
}
