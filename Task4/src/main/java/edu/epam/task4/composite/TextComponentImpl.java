package edu.epam.task4.composite;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class TextComponentImpl implements TextComponent {
    private static Logger logger = LogManager.getLogger(TextComponentImpl.class);
    protected List<TextComponent> componentList = new ArrayList<TextComponent>();
    private TypeComponent type;

    public TextComponentImpl() {
    }

    public TextComponentImpl(TypeComponent type) {//TODO
        this.type = type;
    }


    @Override
    public void operation() {
        logger.log(Level.INFO, "call children operations");
        int size = componentList.size();
        for (int i = 0; i < size; i++) {
            componentList.get(i).operation();
        }
    }

    @Override
    public void remove(TextComponent textComposite) {
        componentList.remove(textComposite);
        logger.log(Level.INFO, textComposite + "added in arraylist");
    }

    @Override
    public void add(TextComponent textComposite) {
        componentList.add(textComposite);
        logger.log(Level.INFO, textComposite + "deleted in arraylist");
    }

    @Override
    public TextComponent getChild(int i) {
        logger.log(Level.INFO, "get element with index: " + i);
        return componentList.get(i);
    }

    @Override
    public String toString() { //TODO
        return "TextCompositeImpl{" +
                "componentList=" + componentList +
                '}';
    }
}
