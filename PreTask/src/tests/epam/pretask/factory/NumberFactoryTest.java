package tests.epam.pretask.factory;

import edu.epam.pretask.numbers.FloatNumber;
import edu.epam.pretask.factory.NumberFactory;
import edu.epam.pretask.factory.SymbolException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberFactoryTest {

    @Test
    void fromFile() throws IOException, SymbolException {
        NumberFactory factory = new NumberFactory();
        List<FloatNumber> numbers = factory.fromFile("resources/file.txt");
        assertEquals(numbers.size(), 4);
        assertEquals(numbers.get(0).getNumber(), 121.212f);
        assertEquals(numbers.get(1).getNumber(), 21.6f);
        assertEquals(numbers.get(2).getNumber(), 1.21f);
        assertEquals(numbers.get(3).getNumber(), -10e+5f);

    }

    @Test
    void createNumber() throws SymbolException {
        NumberFactory factory = new NumberFactory();
        Assertions.assertEquals(factory.createNumber("11.11").getNumber(), 11.11f, 1e-06f);
    }
}