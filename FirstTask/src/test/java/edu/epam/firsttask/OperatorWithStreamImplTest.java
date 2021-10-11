package edu.epam.firsttask;

import edu.epam.firsttask.entity.CustomArray;
import edu.epam.firsttask.factory.CustomArrayFactory;
import edu.epam.firsttask.operator.impl.OperatorWithStreamImpl;
import org.testng.annotations.Test;

import java.util.OptionalDouble;
import java.util.OptionalInt;

import static org.testng.Assert.*;

public class OperatorWithStreamImplTest {
    OperatorWithStreamImpl operator = new OperatorWithStreamImpl();

    @Test
    public void testFindMinValue() {
        CustomArray array = CustomArrayFactory.fromIntegers(1, 2, 3, 4, 5);
        OptionalInt minimum = operator.findMinValue(array);

        assertEquals(minimum.getAsInt(), 1);
    }

    @Test
    public void testFindMaxValue() {
        CustomArray array = CustomArrayFactory.fromIntegers(1, 20, 3, 4, -2);
        OptionalInt minimum = operator.findMinValue(array);

        assertEquals(minimum.getAsInt(), -2);
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