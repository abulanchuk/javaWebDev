package tests.epam.pretask.operator;

import edu.epam.pretask.operator.Operator;
import edu.epam.pretask.numbers.FloatNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperatorTest {

    @Test
    void sum() {
        Operator operator = new Operator();
       FloatNumber result = operator.sum(new FloatNumber(2.3f),new FloatNumber(3.4f));
        assertEquals( 5.7, result.getNumber(), 1e-5);

    }

    @Test
    void subtract() {
        Operator operator = new Operator();
        FloatNumber result = operator.subtract(new FloatNumber(5.3f),new FloatNumber(1.2f));
        assertEquals( 4.1, result.getNumber(), 1e-5);
    }

    @Test
    void multiply() {
        Operator operator = new Operator();
        FloatNumber firstTestResult = operator.multiply(new FloatNumber(2.3f),new FloatNumber(3.4f));
        assertEquals( 7.82, firstTestResult.getNumber(), 1e-5);
        FloatNumber secondTestResult = operator.multiply(new FloatNumber(5.3f),new FloatNumber(3.24f));
        assertEquals( 17.172f, secondTestResult.getNumber(), 1e-5);
    }

    @Test
    void divide() {
        Operator operator = new Operator();
        FloatNumber firstTestResult = operator.divide(new FloatNumber(22.3f),new FloatNumber(3.4f));
        assertEquals( 6.558, firstTestResult.getNumber(), 1e-3);
        FloatNumber secondTestResult = operator.divide(new FloatNumber(35.35f),new FloatNumber(1.5f));
        assertEquals( 23.5666, secondTestResult.getNumber(), 1e-3);

        FloatNumber divisionByZeroResult = operator.divide(
                new FloatNumber(11.f), new FloatNumber(0.f)
        );
        assertEquals(divisionByZeroResult.getNumber(), Float.POSITIVE_INFINITY);

        divisionByZeroResult = operator.divide(
                new FloatNumber(-11.f), new FloatNumber(0.f)
        );
        assertEquals(divisionByZeroResult.getNumber(), Float.NEGATIVE_INFINITY);
    }

}