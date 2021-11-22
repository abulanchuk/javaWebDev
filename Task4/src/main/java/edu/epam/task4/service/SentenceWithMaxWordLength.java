package edu.epam.task4.service;

import edu.epam.task4.composite.TextComponent;
import edu.epam.task4.composite.TypeComponent;
import edu.epam.task4.exception.InvalidTypeException;

import java.util.ArrayList;
import java.util.Collections;

public class SentenceWithMaxWordLength {
    public static ArrayList<TextComponent> findSentenceWithMaxWordLength(TextComponent text) throws InvalidTypeException {
        if (!TypeComponent.TEXT.equals(text.getType())) {
            throw new InvalidTypeException("expected type TEXT");
        }
        ArrayList<TextComponent> sentences = new ArrayList<>();

        for (int i = 0; i < text.getChildrenCount(); i++) {//paragraphs
            TextComponent paragraph = text.getChild(i);
            for (int j = 0; j < paragraph.getChildrenCount(); j++) { //sentences
                TextComponent sentence = paragraph.getChild(j);
                sentences.add(sentence);
            }
        }
        ArrayList<Integer> maxWordsLength = new ArrayList<>();
        int maxLengthInOneSentence = 0;
        for (int i = 0; i < sentences.size(); i++) {
            ArrayList<Integer> wordsLength = new ArrayList<>();
            for (int j = 0; j < sentences.get(i).getChildrenCount(); j++) {
                TextComponent lexeme = sentences.get(i).getChild(j);
                for(int k=0;k< lexeme.getChildrenCount();k++){
                    TextComponent word = lexeme.getChild(k);
                    wordsLength.add(word.getChildrenCount());
                }

            }
            maxLengthInOneSentence = Collections.max(wordsLength);
            maxWordsLength.add(maxLengthInOneSentence);
        }
        maxLengthInOneSentence = Collections.max(maxWordsLength);
        ArrayList<TextComponent> sentencesToReturn = new ArrayList<>();
        for (int i = 0; i < maxWordsLength.size(); i++) {
            if (maxLengthInOneSentence == maxWordsLength.get(i)) {
                sentencesToReturn.add(sentences.get(i));
            }
        }
        return sentencesToReturn;
    }
}
