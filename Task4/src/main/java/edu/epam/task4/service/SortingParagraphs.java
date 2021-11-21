package edu.epam.task4.service;

import edu.epam.task4.Comparator.ParagraphSorting;
import edu.epam.task4.composite.TextComponent;
import edu.epam.task4.composite.TypeComponent;
import edu.epam.task4.exception.InvalidTypeException;

import java.util.ArrayList;


public class SortingParagraphs {
    public static ArrayList<TextComponent> sortParagraphsFromText(TextComponent text) throws InvalidTypeException {
        if (!TypeComponent.TEXT.equals(text.getType())) {
            throw new InvalidTypeException("Expected TEXT");
        }
        ArrayList<TextComponent> paragraphs = new ArrayList<>();
        for (int i = 0; i < text.getChildrenCount(); i++) {
            paragraphs.add(text.getChild(i));
        }
        paragraphs.sort(new ParagraphSorting());
        return paragraphs;
    }

}
