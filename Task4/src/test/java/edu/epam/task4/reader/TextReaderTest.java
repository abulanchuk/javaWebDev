package edu.epam.task4.reader;

import edu.epam.task4.exception.InvalidPathFormatException;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class TextReaderTest {


    @Test
    public void testReadLines() throws InvalidPathFormatException {
        List<String> linesFromFile = TextReader.readLines("src/main/resources/data/text.txt");
        List<String> linesFromMethod = new ArrayList<>();
        linesFromMethod.add("   It has survived - not only (five) centuries, but also the leap into electronic");
        linesFromMethod.add("typesetting, remaining essentially unchanged. It was popularised in the “Динамо” (Рига)");
        linesFromMethod.add("with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and");
        linesFromMethod.add("more recently with desktop publishing software like Aldus PageMaker Faclon9 including");
        linesFromMethod.add("versions of Lorem Ipsum!");
        linesFromMethod.add("   It is a long a!=b established fact that a reader will be distracted by the readable");
        linesFromMethod.add("content of a page when looking at its layout. The point of using Ipsum is that it has a");
        linesFromMethod.add("more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here),");
        linesFromMethod.add("content here's, making it look like readable English?");
        linesFromMethod.add("   It is a established fact that a reader will be of a page when looking at its layout...");
        linesFromMethod.add("   Bye бандерлоги.");
        assertEquals(linesFromFile,linesFromMethod);
    }
}