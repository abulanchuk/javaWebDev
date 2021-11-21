package edu.epam.task4.Comparator;

import edu.epam.task4.composite.TextComponent;

import java.util.Comparator;

public class ParagraphSorting implements Comparator<TextComponent> {
    @Override
    public int compare(TextComponent o1, TextComponent o2) {
        int counterFirstParagraphsChildren = o1.getChildrenCount();
        int counterSecondParagraphsChildren = o2.getChildrenCount();
        return Integer.compare(counterFirstParagraphsChildren,counterSecondParagraphsChildren);
    }
}
