package edu.epam.task4.service;

import edu.epam.task4.chain.TextHandler;
import edu.epam.task4.composite.TextComponent;
import edu.epam.task4.composite.TextComposite;
import edu.epam.task4.composite.TypeComponent;
import edu.epam.task4.exception.InvalidPathFormatException;
import edu.epam.task4.exception.InvalidTypeException;
import edu.epam.task4.reader.TextReader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

public class RepeatingWordsTest  {

    public final String TEST_FILE_PATH = "src/main/resources/data/testText.txt";
    public TextComponent text = new TextComposite(TypeComponent.TEXT);

    @BeforeTest
    void prepareText() throws IOException, InvalidPathFormatException, InvalidTypeException {
        String textFromFile = TextReader.readText(TEST_FILE_PATH);
        TextHandler chain = new TextHandler();
        chain.toHandlerRequest(text, textFromFile);
    }

    @Test
    public void testCountRepeatingWords() throws InvalidTypeException {
        RepeatingWords service = new RepeatingWords();
        Map<String, Integer> correctResult = Map.of("hello", 2, ".",5);

        Map<String, Integer> resultFromMethod = service.countRepeatingWords(this.text);
        assertEquals(resultFromMethod, correctResult);
    }
}