package edu.epam.task2;

import edu.epam.task2.exception.InvalidPathFormatException;
import edu.epam.task2.reader.LineReader;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class LineReaderTest {

    @Test
    public void testReadLines() throws InvalidPathFormatException {
        List<String> linesFromMethod = LineReader.readLines("src/main/resources/data/file.txt");
        List<String> linesFromFile = new ArrayList<>();
        linesFromFile.add("445 344 544433 f");
        linesFromFile.add("434 5 g");
        assertEquals(linesFromFile,linesFromMethod);
    }
}