package edu.epam.task4.service;

import edu.epam.task4.composite.TextComponent;
import edu.epam.task4.exception.InvalidTypeException;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DeleteSentencesTest extends BaseServiceTest{
    public final String refText = "   It has survived - not only (five) centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the “Динамо” (Рига) with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker Faclon9 including versions of Lorem Ipsum!\r\n" +
            "   It is a long a!=b established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Ipsum is that it has a more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here), content here's, making it look like readable English?\r\n" +
            "   It is a established fact that a reader will be of a page when looking at its layout...";

    @Test
    public void testDeleteSentencesLessThanNumber() throws InvalidTypeException {
        DeleteSentences service = new DeleteSentences();
        TextComponent newText = service.deleteSentencesLessThanNumber(this.text, 3);
        String newTextAsString = newText.toString().stripTrailing();

        assertEquals(newTextAsString, refText);
    }
}