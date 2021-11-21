package edu.epam.task4.service;

import edu.epam.task4.composite.TextComponent;
import edu.epam.task4.exception.InvalidTypeException;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;

public class SortingParagraphsTest extends BaseServiceTest {

    @Test
    public void testSortParagraphsFromText() throws InvalidTypeException {
        ArrayList<String> resultFromMethod = new ArrayList<>();
        String firstParagraph = "It has survived - not only (five) centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the “Динамо” (Рига) with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker Faclon9 including versions of Lorem Ipsum!";
        String secondParagraph = "It is a long a!=b established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Ipsum is that it has a more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here), content here's, making it look like readable English?";
        String thirdParagraph = "It is a established fact that a reader will be of a page when looking at its layout...";
        String fouthParagraph = "Bye бандерлоги.";
        resultFromMethod.add(thirdParagraph);
        resultFromMethod.add(fouthParagraph);
        resultFromMethod.add(firstParagraph);
        resultFromMethod.add(secondParagraph);
        ArrayList<TextComponent> res = SortingParagraphs.sortParagraphsFromText(this.text);
        assertEquals(resultFromMethod.toString(), res.toString());
    }
}