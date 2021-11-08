package edu.epam.task4.chain;

import edu.epam.task4.composite.TextComponent;

public class SentenceHandler extends AbstractHandler{
    private AbstractHandler handler = new LexemeHandler();
    @Override
    public void toHandlerRequest(TextComponent component, String element) {

    }
}
