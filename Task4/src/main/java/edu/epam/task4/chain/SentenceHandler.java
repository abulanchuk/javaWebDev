package edu.epam.task4.chain;

import edu.epam.task4.composite.TextComponent;
import edu.epam.task4.composite.TextComposite;
import edu.epam.task4.composite.TypeComponent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceHandler extends AbstractHandler {
    private AbstractHandler sentenceHandler = new LexemeHandler();
    private static final String SENTENCE_REGEX = "[A-ZА-Я]((?!\\. )[A-ZА-Яa-zа-я=:'?!\\. ,\\-\\\"”“()0-9])+(([\\.]{3}|[!?.])( |\\r\\n|\\Z))";

    @Override
    public void toHandlerRequest(TextComponent component, String element) {
        Pattern pattern = Pattern.compile(SENTENCE_REGEX);
        Matcher matcher = pattern.matcher(element);
        while (matcher.find()) {
            TextComponent sentence = new TextComposite(TypeComponent.SENTENCE);
            component.add(sentence);

            String sentenceText = element.substring(matcher.start(), matcher.end());
            sentenceHandler.toHandlerRequest(sentence, sentenceText);
        }

    }
}
