package edu.epam.task4.chain;

import edu.epam.task4.composite.TextComponent;
import edu.epam.task4.composite.TextComposite;
import edu.epam.task4.composite.TypeComponent;

public class LexemeHandler extends AbstractHandler {
    private static final String DELIMITER_LEXEME = "\\s";
    private AbstractHandler lexemeHandler = new WordHandler();

    @Override
    public void toHandlerRequest(TextComponent component, String element) {
        element = element.trim();

        String[] lexemes = element.split(DELIMITER_LEXEME);
        for (String lexeme : lexemes) {
            TextComponent lexemeComponent = new TextComposite(TypeComponent.LEXEME);
            component.add(lexemeComponent);
            lexemeHandler.toHandlerRequest(lexemeComponent, lexeme);
        }
    }
}
