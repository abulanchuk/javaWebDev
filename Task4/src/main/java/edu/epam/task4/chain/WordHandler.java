package edu.epam.task4.chain;

import edu.epam.task4.composite.TextComponent;
import edu.epam.task4.composite.TextComposite;
import edu.epam.task4.composite.TypeComponent;

public class WordHandler extends AbstractHandler{
    private AbstractHandler wordHandler = new SymbolHandler();
    private static final String WORD_DELIMITER = "[A-ZА-Я]?[a-zа-я]*";

    @Override
    public void toHandlerRequest(TextComponent component, String element) {
        String[] words = element.split(WORD_DELIMITER);
        for (String word : words) {
            TextComponent lexemeComponent = new TextComposite(TypeComponent.WORD);
            component.add(lexemeComponent);
            wordHandler.toHandlerRequest(lexemeComponent, word);
        }
    }
}
