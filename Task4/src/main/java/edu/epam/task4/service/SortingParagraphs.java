package edu.epam.task4.service;

import edu.epam.task4.composite.TextComponent;
import edu.epam.task4.composite.TypeComponent;
import edu.epam.task4.exception.InvalidTypeException;

import java.util.ArrayList;
import java.util.Comparator;


public class SortingParagraphs {
    public static ArrayList<TextComponent> sort(TextComponent text) throws InvalidTypeException {
        if (!TypeComponent.TEXT.equals(text.getType())) {
            throw new InvalidTypeException("Expected TEXT");
        }
        ArrayList<TextComponent> paragraphs = new ArrayList<>();
        for (int i = 0; i < text.getChildrenCount(); i++) {
            paragraphs.add(text.getChild(i));
        }
        paragraphs.sort(new ComparatorParagraph());
        return paragraphs;
    }

}


class ComparatorParagraph implements Comparator<TextComponent>{
    @Override
    public int compare(TextComponent o1, TextComponent o2) {
       int counterFirstParagraphsChildren = o1.getChildrenCount();
        int counterSecondParagraphsChildren = o2.getChildrenCount();
       return Integer.compare(counterFirstParagraphsChildren,counterSecondParagraphsChildren);
    }
}