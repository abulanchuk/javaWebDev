package edu.epam.firstTask.operator;

import edu.epam.firstTask.array.Number;
import edu.epam.firstTask.operator.NumberComparator;
import edu.epam.firstTask.operator.Operator;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;

public class OperatorTest {
    Operator operator = new Operator();

    protected ArrayList<Number> convertToArray(int[] array) {
        ArrayList<Number> numbers = new ArrayList<>();
        for (int element : array) {
            numbers.add(new Number(element));
        }
        return numbers;
    }

    protected boolean areArraysEqual(ArrayList<Number> first, ArrayList<Number> second) {
        if (first.size() != second.size()) {
            return false;
        }

        NumberComparator comparator = new NumberComparator();

        for (int i = 0; i < first.size(); ++i) {
            if (comparator.compare(first.get(i), second.get(i)) != 0) {
                return false;
            }
        }

        return true;
    }


    @Test
    public void testFindMinValueFirst() {
        ArrayList<Number> inputs = convertToArray(new int[]{1, 2, 3, 4, 5});
        Number minimum = operator.findMinValue(inputs);

        assertEquals(minimum.getNumber(), 1);
    }

    @Test
    public void testFindMinValueLast() {
        ArrayList<Number> inputs = convertToArray(new int[]{4, 11, 324555, -2});
        Number minimum = operator.findMinValue(inputs);

        assertEquals(minimum.getNumber(), -2);
    }

    @Test
    public void testFindMinValueInACenter() {
        ArrayList<Number> inputs = convertToArray(new int[]{7, 1134, 6, 324555, 20});
        Number minimum = operator.findMinValue(inputs);

        assertEquals(minimum.getNumber(), 6);
    }

    @Test
    public void testFindMaxValueFirst() {
        ArrayList<Number> inputs = convertToArray(new int[]{34, 5, 7, 9, 23});
        Number maximum = operator.findMaxValue(inputs);

        assertEquals(maximum.getNumber(), 34);
    }

    @Test
    public void testFindMaxValueLast() {
        ArrayList<Number> inputs = convertToArray(new int[]{455, 11, 654, 20000});
        Number maximum = operator.findMaxValue(inputs);

        assertEquals(maximum.getNumber(), 20000);
    }

    @Test
    public void testFindMaxValueInACenter() {
        ArrayList<Number> inputs = convertToArray(new int[]{7, 1134, 6, 324555, 20});
        Number maximum = operator.findMaxValue(inputs);

        assertEquals(maximum.getNumber(), 324555);
    }

    @Test
    public void testSumOfElements() {
        ArrayList<Number> inputs = convertToArray(new int[]{34, 15, 1, 3, 20});
        Number sum = operator.sumOfElements(inputs);

        assertEquals(sum.getNumber(), 73);
    }

    @Test
    public void testFindAverageNumber() {
        ArrayList<Number> inputs = convertToArray(new int[]{34, 15, 1, 3, 20});
        Number average = operator.findAverageNumber(inputs);

        assertEquals(average.getNumber(), 14);
    }

    @Test
    public void testCountPositiveNumbers() {
        ArrayList<Number> inputs = convertToArray(new int[]{2, -1, -3, 4, -7});
        Number positiveNum = operator.countPositiveNumbers(inputs);

        assertEquals(positiveNum.getNumber(), 2);
    }

    @Test
    public void testCountNegativeNumbers() {
        ArrayList<Number> inputs = convertToArray(new int[]{2, -1, -3, 4, -7});
        Number negativeNum = operator.countNegativeNumbers(inputs);

        assertEquals(negativeNum.getNumber(), 3);
    }

    @Test
    public void testReplaceNegativeWithPositive() {
        ArrayList<Number> inputsBeforeReplace = convertToArray(new int[]{2, -1, -3, 4, -7});
        ArrayList<Number> outputsAfterReplace = convertToArray(new int[]{2, 1, 3, 4, 7});
        ArrayList<Number> replaceArray = operator.replaceNegativeWithPositive(inputsBeforeReplace);
        assertTrue(
                areArraysEqual(replaceArray, outputsAfterReplace)
        );
    }
}