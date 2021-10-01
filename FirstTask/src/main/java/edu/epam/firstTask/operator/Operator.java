package edu.epam.firstTask.operator;

import edu.epam.firstTask.array.Number;

import java.util.ArrayList;

public class Operator {
    NumberComparator numberComparator = new NumberComparator();

    public Number findMinValue(ArrayList<Number> numbers) {
        Number minValue = numbers.get(0);
        for (int i = 0; i < numbers.size(); i++) {
            if (numberComparator.compare(minValue, numbers.get(i)) > 0) {
                minValue = numbers.get(i);
            }
        }
        return minValue;
    }

    public Number findMaxValue(ArrayList<Number> numbers) {
        Number maxValue = numbers.get(0);
        for (int i = 0; i < numbers.size(); i++) {
            if (numberComparator.compare(maxValue, numbers.get(i)) < 0) {
                maxValue = numbers.get(i);
            }
        }
        return maxValue;
    }

    public Number sumOfElements(ArrayList<Number> numbers) {
        Number sum = new Number(0);
        for (int i = 0; i < numbers.size(); i++) {
            sum = new Number(sum.getNumber() + numbers.get(i).getNumber());
        }
        return sum;
    }

    public Number findAverageNumber(ArrayList<Number> numbers) {
        int averageNumber = (int) sumOfElements(numbers).getNumber() / numbers.size();
        return new Number(averageNumber);
    }

    public Number countPositiveNumbers(ArrayList<Number> numbers) {
        int positiveCounter = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (numberComparator.compare(new Number(0), numbers.get(i)) < 0) {
                positiveCounter++;
            }
        }
        return new Number(positiveCounter);
    }

    public Number countNegativeNumbers(ArrayList<Number> numbers) {
        int negativeCounter = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (numberComparator.compare(new Number(0), numbers.get(i)) > 0) {
                negativeCounter++;
            }
        }
        return new Number(negativeCounter);
    }

    public ArrayList<Number> replaceNegativeWithPositive(ArrayList<Number> numbers) {
        ArrayList<Number> arrayAfterReplacement = new ArrayList<>(numbers);
        for (int i = 0; i < numbers.size(); i++) {
            if (numberComparator.compare(new Number(0), numbers.get(i)) > 0) {
                arrayAfterReplacement.set(i, new Number(numbers.get(i).getNumber() * (-1)));
            }
        }
        return arrayAfterReplacement;
    }
}
