package edu.epam.firsttask;

import edu.epam.firsttask.entity.CustomArray;
import edu.epam.firsttask.factory.CustomArrayFactory;
import edu.epam.firsttask.operator.Operator;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class OperatorTest {
    Operator operator = new Operator();

    @Test
    public void testFindMinValueFirst() {
        CustomArray array = CustomArrayFactory.fromIngeters(1, 2, 3, 4, 5);
        int minimum = operator.findMinValue(array);

        assertEquals(minimum, 1);
    }

    @Test
    public void testFindMinValueLast() {
        CustomArray array = CustomArrayFactory.fromIngeters(1, 20, 3, 4, -2);
        int minimum = operator.findMinValue(array);

        assertEquals(minimum, -2);
    }

    @Test
    public void testFindMinValueInACenter() {
        CustomArray array = CustomArrayFactory.fromIngeters(1, -2, 3, 4, 5);
        int minimum = operator.findMinValue(array);

        assertEquals(minimum, -2);
    }

    @Test
    public void testFindMaxValueFirst() {
        CustomArray array = CustomArrayFactory.fromIngeters(1234, -2, 3, 4, 5);
        int maximum = operator.findMaxValue(array);

        assertEquals(maximum, 1234);
    }

    @Test
    public void testFindMaxValueLast() {
        CustomArray array = CustomArrayFactory.fromIngeters(12, -2, 3, 4, 500);
        int maximum = operator.findMaxValue(array);

        assertEquals(maximum, 500);
    }

    @Test
    public void testFindMaxValueInACenter() {
        CustomArray array = CustomArrayFactory.fromIngeters(12, -2, 3000, 4, 500);
        int maximum = operator.findMaxValue(array);
        assertEquals(maximum, 3000);
    }

    @Test
    public void testSumOfElements() {
        CustomArray array = CustomArrayFactory.fromIngeters(12, -2, 3, 4, 50);
        long sum = operator.sumOfElements(array);

        assertEquals(sum, 67);
    }

    @Test
    public void testFindAverageNumber() {
        CustomArray array = CustomArrayFactory.fromIngeters(12000, -2, 30000, 4, 50000);
         double average = operator.findAverageNumber(array);

        assertEquals(average, 18400.4);
    }

    @Test
    public void testCountPositiveNumbers() {
        CustomArray array = CustomArrayFactory.fromIngeters(12000, -2, 30000, 4, 50000);
        int positiveNum = operator.countPositiveNumbers(array);

        assertEquals(positiveNum, 4);
    }

    @Test
    public void testCountNegativeNumbers() {
        CustomArray array = CustomArrayFactory.fromIngeters(12000, -2, 30000, 4, 50000);
        int negativeNum = operator.countNegativeNumbers(array);

        assertEquals(negativeNum, 1);
    }

    @Test
    public void testReplaceNegativeWithPositive() {
        CustomArray array = CustomArrayFactory.fromIngeters(12000, -2, 30000, 4, 50000);
        CustomArray replaceArray = operator.replaceNegativeWithPositive(array);

        assertEquals(replaceArray.getArray(), new int[]{12000, 2, 30000, 4, 50000});

    }
}