package edu.epam.firsttask;

import edu.epam.firsttask.entity.CustomArray;
import edu.epam.firsttask.factory.CustomArrayFactory;
import edu.epam.firsttask.operator.impl.OperatorImpl;
import org.testng.annotations.Test;

import java.util.OptionalDouble;
import java.util.OptionalInt;

import static org.testng.Assert.*;

public class OperatorImplTest {
    OperatorImpl operator = new OperatorImpl();

    @Test
    public void testFindMinValueFirst() {
        CustomArray array = CustomArrayFactory.fromIntegers(1, 2, 3, 4, 5);
        OptionalInt minimum = operator.findMinValue(array);

        assertEquals(minimum.getAsInt(), 1);
    }

    @Test
    public void testFindMinValueLast() {
        CustomArray array = CustomArrayFactory.fromIntegers(1, 20, 3, 4, -2);
        OptionalInt minimum = operator.findMinValue(array);

        assertEquals(minimum.getAsInt(), -2);
    }

    @Test
    public void testFindMinValueInACenter() {
        CustomArray array = CustomArrayFactory.fromIntegers(1, -2, 3, 4, 5);
        OptionalInt minimum = operator.findMinValue(array);

        assertEquals(minimum.getAsInt(), -2);
    }

    @Test
    public void testFindMaxValueFirst() {
        CustomArray array = CustomArrayFactory.fromIntegers(1234, -2, 3, 4, 5);
        OptionalInt maximum = operator.findMaxValue(array);

        assertEquals(maximum.getAsInt(), 1234);
    }

    @Test
    public void testFindMaxValueLast() {
        CustomArray array = CustomArrayFactory.fromIntegers(12, -2, 3, 4, 500);
        OptionalInt maximum = operator.findMaxValue(array);

        assertEquals(maximum.getAsInt(), 500);
    }

    @Test
    public void testFindMaxValueInACenter() {
        CustomArray array = CustomArrayFactory.fromIntegers(12, -2, 3000, 4, 500);
        OptionalInt maximum = operator.findMaxValue(array);

        assertEquals(maximum.getAsInt(), 3000);
    }

    @Test
    public void testSumOfElements() {
        CustomArray array = CustomArrayFactory.fromIntegers(12, -2, 3, 4, 50);
        long sum = operator.sumOfElements(array);

        assertEquals(sum, 67);
    }

    @Test
    public void testFindAverageNumber() {
        CustomArray array = CustomArrayFactory.fromIntegers(12000, -2, 30000, 4, 50000);
         OptionalDouble average = operator.findAverageNumber(array);

        assertEquals(average.getAsDouble(), 18400.4);
    }

    @Test
    public void testCountPositiveNumbers() {
        CustomArray array = CustomArrayFactory.fromIntegers(12000, -2, 30000, 4, 50000);
        long positiveNum = operator.countPositiveNumbers(array);

        assertEquals(positiveNum, 4);
    }

    @Test
    public void testCountNegativeNumbers() {
        CustomArray array = CustomArrayFactory.fromIntegers(12000, -2, 30000, 4, 50000);
        long negativeNum = operator.countNegativeNumbers(array);

        assertEquals(negativeNum, 1);
    }

    @Test
    public void testReplaceNegativeWithPositive() {
        CustomArray array = CustomArrayFactory.fromIntegers(12000, -2, 30000, 4, 50000);
        CustomArray replaceArray = operator.replaceNegativeWithPositive(array);

        assertEquals(replaceArray.getArray(), new int[]{12000, 2, 30000, 4, 50000});

    }
}