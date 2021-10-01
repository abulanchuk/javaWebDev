package edu.epam.firstTask.utils;

import edu.epam.firstTask.array.Number;
import edu.epam.firstTask.operator.NumberComparator;

import java.util.ArrayList;

public class Checker {
    public static boolean areArraysEqual(ArrayList<Number> first, ArrayList<Number> second) {
        if (first.size() != second.size()) {
            return false;
        }

        NumberComparator comparator = new NumberComparator();

        for (int i = 0; i < first.size(); ++i) {
            if (comparator.compare(first.get(i), second.get(i)) != 0) {
                return false;
            }
        }

        return true;
    }
}
