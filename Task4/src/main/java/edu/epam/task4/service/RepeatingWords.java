package edu.epam.task4.service;

import edu.epam.task4.composite.TextComponent;
import edu.epam.task4.composite.TypeComponent;
import edu.epam.task4.exception.InvalidTypeException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatingWords {
    private ArrayList<String> collectWords(TextComponent text) {
        ArrayList<String> words = new ArrayList<>();

        for (int i = 0; i < text.getChildrenCount(); i++) {
            TextComponent paragraph = text.getChild(i);
            for (int j = 0; j < paragraph.getChildrenCount(); j++) {
                TextComponent sentence = paragraph.getChild(j);
                for (int k = 0; k < sentence.getChildrenCount(); k++) {
                    TextComponent lexeme = sentence.getChild(k);
                    for (int m = 0; m < lexeme.getChildrenCount(); m++) {
                        String word = lexeme.getChild(m).toString().toLowerCase();
                        words.add(word);
                    }
                }
            }
        }
        return words;
    }

    private Map<String, Integer> countWords(List<String> words) {
        Map<String, Integer> wordCounts = new HashMap<>();

        for (String word : words) {
            if (wordCounts.containsKey(word)) {
                wordCounts.computeIfPresent(word, (key, value) -> value + 1);
            } else {
                wordCounts.put(word, 1);
            }
        }

        return wordCounts;
    }

    private Map<String, Integer> filterCounts(Map<String, Integer> wordCounts) {
        Map<String, Integer> repeatedWords = new HashMap<>();
        for (Map.Entry<String, Integer> ent : wordCounts.entrySet()) {
            if (ent.getValue() > 1) {
                repeatedWords.put(ent.getKey(), ent.getValue());
            }
        }
        return repeatedWords;
    }

    public Map<String, Integer> countRepeatingWords(TextComponent text) throws InvalidTypeException {
        if (!TypeComponent.TEXT.equals(text.getType())) {
            throw new InvalidTypeException("Expected TEXT");
        }

        ArrayList<String> words = collectWords(text);
        Map<String, Integer> wordCounts = countWords(words);

        return filterCounts(wordCounts);
    }
}
