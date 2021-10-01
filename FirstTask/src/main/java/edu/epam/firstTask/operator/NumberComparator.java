package edu.epam.firstTask.operator;

import edu.epam.firstTask.array.Number;

import java.util.Comparator;

public class NumberComparator implements Comparator<Number> {
    @Override
    public int compare(Number first, Number second) {
        return Integer.compare(first.getNumber(), second.getNumber());
    }
}
