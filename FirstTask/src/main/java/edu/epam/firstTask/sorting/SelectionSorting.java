package edu.epam.firstTask.sorting;

import edu.epam.firstTask.array.Number;
import edu.epam.firstTask.operator.NumberComparator;

import java.util.ArrayList;

public class SelectionSorting {
    public ArrayList<Number> selectionSort(ArrayList<Number> numbers) {
        NumberComparator numberComparator = new NumberComparator();

        for (int i = 0; i < numbers.size(); i++) {
            Number min = numbers.get(i);
            int idxMin = i;

            for (int j = i + 1; j < numbers.size(); j++) {
                if (numberComparator.compare(numbers.get(j), min) < 0) {
                    min = numbers.get(j);
                    idxMin = j;
                }
            }
            numbers.set(idxMin, numbers.get(i));
            numbers.set(i, min);
        }
        return numbers;
    }
}