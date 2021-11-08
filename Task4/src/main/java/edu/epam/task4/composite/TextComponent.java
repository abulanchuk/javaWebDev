package edu.epam.task4.composite;


public interface TextComponent {
    void operation();
    void remove(TextComponent textComposite);

    void add(TextComponent textComposite);

    Object getChild(int index);

}
