package edu.epam.task4.service;

import edu.epam.task4.composite.TextComponent;
import edu.epam.task4.exception.InvalidTypeException;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Objects;

import static org.testng.Assert.*;

public class SentenceWithMaxWordLengthTest extends BaseServiceTest {

    @Test
    public void testFindSentenceWithMaxWordLength() throws InvalidTypeException {
        String correctAnswer = "The point of using Ipsum is that it has a more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here), content here's, making it look like readable English?";
        ArrayList<String> correctList = new ArrayList<>();
        correctList.add(correctAnswer);
        ArrayList<TextComponent> sentencesFromMethod = SentenceWithMaxWordLength.findSentenceWithMaxWordLength(this.text);
        assertEquals(correctList.toString(), sentencesFromMethod.toString());
    }
}