package edu.epam.task4.service;

import edu.epam.task4.chain.AbstractHandler;
import edu.epam.task4.chain.TextHandler;
import edu.epam.task4.composite.TextComponent;
import edu.epam.task4.composite.TextComposite;
import edu.epam.task4.composite.TypeComponent;
import edu.epam.task4.exception.InvalidPathFormatException;
import edu.epam.task4.reader.TextReader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public class BaseServiceTest {
    public final String TEST_FILE_PATH = "src/main/resources/data/text.txt";
    public TextComponent text = new TextComposite(TypeComponent.TEXT);

    @BeforeMethod
    void prepareText() throws IOException, InvalidPathFormatException {
        String textFromFile = TextReader.readText(TEST_FILE_PATH);
        TextHandler chain = new TextHandler();
        chain.toHandlerRequest(text, textFromFile);
    }
}
