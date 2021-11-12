package edu.epam.task4.chain;

import edu.epam.task4.composite.TextComponent;
import edu.epam.task4.composite.TextComposite;
import edu.epam.task4.composite.TypeComponent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceHandler extends AbstractHandler{
    private AbstractHandler sentenceHandler = new LexemeHandler();
    private static final String SENTENCE_DELIMITER = "[A-ZА-Я][a-zа-я ,\"()-]*(([\\.]{3}|[!?.])[ \r\n])";
    @Override
    public void toHandlerRequest(TextComponent component, String element) {
        Pattern pattern = Pattern.compile(SENTENCE_DELIMITER);
        Matcher matcher = pattern.matcher(element);
        if (matcher.find()){
            for( int i = 0; i < matcher.groupCount()+1; i++ ){
                TextComponent sentence = new TextComposite(TypeComponent.SENTENCE);
                component.add(sentence);
                sentenceHandler.toHandlerRequest(sentence,matcher.group(i));
            }
        }

    }
}
