package edu.epam.firstTask.factory;

import edu.epam.firstTask.array.Number;
import edu.epam.firstTask.utils.Checker;
import edu.epam.firstTask.utils.Converter;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;

public class ArrayFactoryTest {
    ArrayFactory arrayFactory = new ArrayFactory();

    @Test
    public void testCreateFromLine() throws SymbolException {
        ArrayList<Number> array = arrayFactory.createFromLine("56 655 6");
        ArrayList<Number> outputs = Converter.convertToArray(new int[]{56, 655, 6});
        assertTrue(
                Checker.areArraysEqual(array, outputs)
        );
    }

    @Test
    public void testCreateFromInvalidLine() throws SymbolException {
        assertThrows(SymbolException.class, () -> arrayFactory.createFromLine("1222 2344fff"));
    }

    @Test
    public void testCreateNumberPositive() throws SymbolException {
        Number number = arrayFactory.createNumber("5556");
        assertEquals(number.getNumber(), 5556);
    }

    @Test
    public void testCreateNumberNegative() throws SymbolException {
        Number number = arrayFactory.createNumber("-5556");
        assertEquals(number.getNumber(), -5556);
    }

    @Test
    public void testCreateNumberWithZero() throws SymbolException {
        Number number = arrayFactory.createNumber("0");
        assertEquals(number.getNumber(), 0);
    }
}