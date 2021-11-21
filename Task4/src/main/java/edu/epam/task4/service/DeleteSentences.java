package edu.epam.task4.service;

import edu.epam.task4.composite.TextComponent;
import edu.epam.task4.composite.TypeComponent;
import edu.epam.task4.exception.InvalidTypeException;

import java.util.ArrayList;

public class DeleteSentences {
    public TextComponent deleteSentencesLessThanNumber(TextComponent text, int number) throws InvalidTypeException {
        if (!TypeComponent.TEXT.equals(text.getType())) {
            throw new InvalidTypeException("Expected TEXT");
        }

        for (int i = 0; i < text.getChildrenCount(); i++) {
            TextComponent paragraph = text.getChild(i);
            ArrayList<Integer> indexesToDelete = new ArrayList<>();

            for (int j = 0; j < paragraph.getChildrenCount(); j++) {
                TextComponent sentence = paragraph.getChild(j);
                int wordCounter = sentence.getChildrenCount();
                if (wordCounter < number) {
                    indexesToDelete.add(j);
                }
            }

            int howManySentencesWasDeleted = 0;
            for (int j = 0; j < indexesToDelete.size(); j++) {
                paragraph.removeChild(indexesToDelete.get(j) - howManySentencesWasDeleted);
                howManySentencesWasDeleted++;
            }
        }
        return text;
    }
}
