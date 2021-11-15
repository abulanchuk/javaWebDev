package edu.epam.task4.chain;


import edu.epam.task4.composite.TextComposite;
import edu.epam.task4.composite.TypeComponent;
import edu.epam.task4.exception.InvalidPathFormatException;
import edu.epam.task4.reader.TextReader;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;


public class TextHandlerTest {

    String linesFromFile = TextReader.readText("src/main/resources/data/testText.txt");

    public TextHandlerTest() throws IOException, InvalidPathFormatException {
    }


    @Test
    public void testToHandlerRequest() {
        TextHandler textHandler = new TextHandler();
        TextComposite root = new TextComposite(TypeComponent.TEXT);
        textHandler.toHandlerRequest(root, linesFromFile);
        assertEquals(root.toString(),linesFromFile);
    }
}