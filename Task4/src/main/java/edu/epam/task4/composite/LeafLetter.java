package edu.epam.task4.composite;

import edu.epam.task4.exception.IllegalOperationException;
import edu.epam.task4.reader.TextReader;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class LeafLetter implements TextComponent {
    private static Logger logger = LogManager.getLogger(LeafLetter.class);

    char letter;
    TypeComponent type;

    public LeafLetter(char letter) {
        this.letter = letter;
    }

    public LeafLetter(char letter, TypeComponent type) {
        this.letter = letter;
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
    public void removeChild(int index)  {
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
        return String.valueOf(letter);
    }
}
