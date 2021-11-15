package edu.epam.task4.chain;

import edu.epam.task4.composite.LeafLetter;
import edu.epam.task4.composite.LeafPunctuation;
import edu.epam.task4.composite.TextComponent;


import java.util.regex.Pattern;

public class SymbolHandler extends AbstractHandler {
    private final static String PUNCTUATION_PATTERN = "\\p{Punct}";

    @Override
    public void toHandlerRequest(TextComponent component, String element) {
        for (int i = 0; i < element.length(); i++) {
            char currentChar = element.charAt(i);
            boolean isPunctuation = Pattern.matches(PUNCTUATION_PATTERN, String.valueOf(currentChar));

            TextComponent symbol = isPunctuation ? new LeafPunctuation(currentChar) : new LeafLetter(currentChar);
            component.add(symbol);
        }
    }
}
