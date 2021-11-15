package edu.epam.task4.composite;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class TextComposite implements TextComponent {
    private static Logger logger = LogManager.getLogger(TextComposite.class);
    protected List<TextComponent> componentList = new ArrayList<TextComponent>();
    private TypeComponent type;


    public TextComposite(TypeComponent type) {//TODO
        this.type = type;
    }


    @Override
    public void remove(TextComponent textComposite) {
        componentList.remove(textComposite);
        logger.log(Level.INFO, textComposite + " deleted in arraylist");
    }

    @Override
    public void add(TextComponent textComposite) {
        componentList.add(textComposite);
        logger.log(Level.INFO, textComposite + " added in arraylist");
    }

    @Override
    public TextComponent getChild(int i) {
        logger.log(Level.INFO, " get element with index: " + i);
        return componentList.get(i);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        String separator = "";
        switch (type) {
            case TEXT -> separator = "\r\n";
            case PARAGRAPH -> separator = " ";
            case SENTENCE -> separator = " ";
        }

        for (int i = 0; i < componentList.size() ; ++i) {
            TextComponent component = componentList.get(i);

            if (type.equals(TypeComponent.TEXT)) {
                builder.append("   ");
            }

            builder.append(component.toString());
            if (i < componentList.size() - 1) {
                builder.append(separator);
            }
        }
        return builder.toString();
    }
}
