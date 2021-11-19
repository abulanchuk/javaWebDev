package edu.epam.task4.composite;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class LeafPunctuation implements TextComponent{
    private static Logger logger = LogManager.getLogger(LeafPunctuation.class);
    char punctuation;
    TypeComponent type;

    public LeafPunctuation(char punctuation) {
        this.punctuation = punctuation;
    }

    public LeafPunctuation(char punctuation, TypeComponent type) {
        this.punctuation = punctuation;
        this.type = type;
    }


    @Override
    public void remove(TextComponent textComposite) {
        logger.log(Level.WARN, "Can't remove this element!");
    }

    @Override
    public void add(TextComponent textComposite) {
        logger.log(Level.WARN, "Can't add this element!");
    }

    @Override
    public TextComponent getChild(int index) {
        return null;
    }

    @Override
    public void removeChild(int index) {
        logger.log(Level.WARN, "Can't remove child!");
    }

    @Override
    public TypeComponent getType() {
        return type;
    }

    @Override
    public int getChildrenCount() {
        return 0;
    }

    @Override
    public String toString() {
        return String.valueOf(punctuation);
    }
}
