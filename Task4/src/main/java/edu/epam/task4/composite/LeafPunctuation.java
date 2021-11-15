package edu.epam.task4.composite;

public class LeafPunctuation implements TextComponent{
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

    }

    @Override
    public void add(TextComponent textComposite) {

    }

    @Override
    public TextComponent getChild(int index) {
        return null;
    }

    @Override
    public String toString() {
        return String.valueOf(punctuation);
    }
}
