package edu.epam.task4.composite;


public interface TextComponent {

    void remove(TextComponent textComposite);

    void add(TextComponent textComposite);

    TextComponent getChild(int index);

    void removeChild(int index);

    TypeComponent getType();

    int getChildrenCount();
}
