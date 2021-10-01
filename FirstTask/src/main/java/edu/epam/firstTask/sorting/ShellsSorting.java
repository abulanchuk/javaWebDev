package edu.epam.firstTask.sorting;

import edu.epam.firstTask.array.Number;
import edu.epam.firstTask.operator.NumberComparator;

import java.util.ArrayList;

public class ShellsSorting {
    NumberComparator comparator = new NumberComparator();

    public ArrayList<Number> shellSort(ArrayList<Number> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            Number value = numbers.get(i);
            if (comparator.compare(numbers.get(i), numbers.get(i + 1)) > 0) {
                numbers.set(i, numbers.get(i + 1));
                numbers.set(i + 1, value);
                i = i - 2;
                if (i < 0) {
                    i = -1;
                }
            }
        }
        return numbers;
    }

}
