package edu.epam.task4.chain;

import edu.epam.task4.composite.TextComponent;
import edu.epam.task4.composite.TextComposite;
import edu.epam.task4.composite.TypeComponent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class WordHandler extends AbstractHandler {
    private AbstractHandler wordHandler = new SymbolHandler();
    private static final String WORD_REGEX = "[A-ZА-Яa-zа-я]+";
    private static final Pattern WORD_PATTERN = Pattern.compile(WORD_REGEX);

    @Override
    public void toHandlerRequest(TextComponent component, String element) {
        Matcher matcher = WORD_PATTERN.matcher(element);
        int lastIndex = 0;

        while (matcher.find()) {
            int matchStart = matcher.start();
            int matchEnd = matcher.end();

            TextComponent word = new TextComposite(TypeComponent.WORD);
            component.add(word);
            if (matchStart > lastIndex) {
                wordHandler.toHandlerRequest(word, element.substring(lastIndex, matchStart));
            }

            String addingWord = element.substring(matchStart,matchEnd);
            wordHandler.toHandlerRequest(word, addingWord);

            lastIndex = matchEnd;
        }
        if (lastIndex != element.length()) {
            TextComponent word = new TextComposite(TypeComponent.WORD);
            component.add(word);
            wordHandler.toHandlerRequest(word, element.substring(lastIndex));
        }
    }
}
