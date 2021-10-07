package edu.epam.firsttask;

import edu.epam.firsttask.exception.InvalidPathFormatException;
import edu.epam.firsttask.reader.LineReader;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.testng.Assert.*;

public class LineReaderTest {


    @Test
    public void testReadLines() throws IOException, InvalidPathFormatException {
        ArrayList<String> linesFromMethod = LineReader.readLines("src/main/resources/data/file.txt");
        ArrayList <String> linesFromFile = new ArrayList<>();
        linesFromFile.add("1 4 8 3");
        linesFromFile.add("2 2 0");
        linesFromFile.add("-22f 4345 111");
        linesFromFile.add("-4 4 1990");
        assertEquals(linesFromFile,linesFromMethod);
    }
}