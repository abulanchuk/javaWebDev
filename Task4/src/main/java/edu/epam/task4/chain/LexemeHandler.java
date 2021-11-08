package edu.epam.task4.chain;

import edu.epam.task4.composite.TextComponent;

public class LexemeHandler extends AbstractHandler{
    static final String REGEX_LEXEME = " ";
    private AbstractHandler handler = new WordHandler();

    @Override
    public void toHandlerRequest(TextComponent component, String element) {

    }
}
