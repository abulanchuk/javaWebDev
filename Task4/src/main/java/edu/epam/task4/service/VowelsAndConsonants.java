package edu.epam.task4.service;

import edu.epam.task4.composite.LeafLetter;
import edu.epam.task4.composite.TextComponent;
import edu.epam.task4.composite.TypeComponent;
import edu.epam.task4.exception.InvalidTypeException;

import java.util.ArrayList;

public class VowelsAndConsonants {
    private static final String VOWELS_SYMBOLS = "aeioyuуеаоэяию";

    public static int[] toCountVowelsAndConsonants(TextComponent text, int numberOfSentence) throws InvalidTypeException {
        if (!TypeComponent.TEXT.equals(text.getType())) {
            throw new InvalidTypeException("Expected TEXT");
        }

        TextComponent sentenceToHandle = null;
        ArrayList<TextComponent> sentences = new ArrayList<>();

        for (int i = 0; i < text.getChildrenCount(); i++) {
            TextComponent paragraph = text.getChild(i);
            for (int j = 0; j < paragraph.getChildrenCount(); j++) {
                TextComponent sentence = paragraph.getChild(j);
                sentences.add(sentence);
            }
        }

        ArrayList<String> characters = new ArrayList<>();

        for (int i = 0; i < sentences.size(); i++) {
            if (i == numberOfSentence) {
                for (int j = 0; j < sentences.get(i).getChildrenCount(); j++) {
                    TextComponent lexeme = sentences.get(i).getChild(j);
                    for (int k = 0; k < lexeme.getChildrenCount(); k++) {
                        TextComponent word = lexeme.getChild(k);
                        for (int l = 0; l < word.getChildrenCount(); l++) {
                            TextComponent character = word.getChild(l);
                            if (character instanceof LeafLetter) {
                                characters.add(character.toString().toLowerCase());
                            }
                        }

                    }
                }
            }
        }

        int vowelsCounter = 0;
        int consonantsCounter = 0;
        int[] result = new int[2];

        for (int i = 0; i < characters.size(); i++) {
            boolean isVowel = VOWELS_SYMBOLS.contains(characters.get(i));
            if (isVowel) {
                vowelsCounter++;
            } else {
                consonantsCounter++;
            }
        }
        result[0] = vowelsCounter;
        result[1] = consonantsCounter;
        return result;
    }
}


