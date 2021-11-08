package edu.epam.task4.chain;

import edu.epam.task4.composite.TextComponent;

public class TextHandler extends AbstractHandler {
    private AbstractHandler textHandler = new ParagraphHandler();

    @Override
    public void toHandlerRequest(TextComponent component, String element) {
        textHandler.toHandlerRequest(component,element);
    }
}
