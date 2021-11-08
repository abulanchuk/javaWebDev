package edu.epam.task4.chain;

import edu.epam.task4.composite.TextComponent;
import edu.epam.task4.composite.TextComponentImpl;

public class ParagraphHandler extends AbstractHandler {
    AbstractHandler paragraphHandler = new SentenceHandler();
    static final String DELIMITER_PARAGRAPH = "\\s{3}";

    @Override
    public void toHandlerRequest(TextComponent component, String element) {
        element = element.trim();
        String[] paragraphs = element.split(DELIMITER_PARAGRAPH);
        for (String textParagraphs : paragraphs) {
            TextComponent paragraph = new TextComponentImpl();
            component.add(paragraph);
            paragraphHandler.toHandlerRequest(paragraph, textParagraphs);
        }
    }
}
