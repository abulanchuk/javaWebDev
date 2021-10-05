package edu.epam.firsttask.operator;

import edu.epam.firsttask.entity.CustomArray;

public class Operator {
    public int findMinValue(CustomArray array) {
        // TODO: empty array?
        int minValue = array.get(0);

        for (int i = 1; i < array.getLength(); i++) {
            if (array.get(i) < minValue) {
                minValue = array.get(i);
            }
        }
        return minValue;
    }

    public int findMaxValue(CustomArray array) {
        int maxValue = array.get(0);
        for (int i = 0; i < array.getLength(); i++) {
            if (array.get(i) > maxValue) {
                maxValue = array.get(i);
            }
        }
        return maxValue;
    }

    public long sumOfElements(CustomArray array) {
        long sum = 0;
        for (int i = 0; i < array.getLength(); i++) {
            sum += array.get(i);
        }
        return sum;
    }

    public double findAverageNumber(CustomArray array) {
        if (array.getLength() == 0) {
            throw new RuntimeException("Empty array");
        }

        return (double) sumOfElements(array) / array.getLength();
    }

    public int countPositiveNumbers(CustomArray array) {
        int positiveCounter = 0;
        for (int i = 0; i < array.getLength(); i++) {
            if (array.get(i) > 0) {
                positiveCounter++;
            }
        }
        return positiveCounter;
    }

    public int countNegativeNumbers(CustomArray array) {
        int negativeCounter = 0;
        for (int i = 0; i < array.getLength(); i++) {
            if (array.get(i) < 0) {
                negativeCounter++;
            }
        }
        return negativeCounter;
    }

    public CustomArray replaceNegativeWithPositive(CustomArray array) {
        int[] integerArray = array.getArray();
        for (int i = 0; i < integerArray.length; i++) {
            if (integerArray[i] < 0) {
                integerArray[i] = integerArray[i] * (-1);
            }
        }
        return new CustomArray(integerArray);
    }
}
