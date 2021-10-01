package edu.epam.firstTask.sorting;

import edu.epam.firstTask.array.Number;
import edu.epam.firstTask.operator.NumberComparator;

import java.util.ArrayList;

public class ExchangeSorting {
    NumberComparator numberComparator = new NumberComparator();

    public ArrayList<Number> exchangeSort(ArrayList<Number> numbers) {
        Number temporaryVariable = new Number(0);
        for (int j = 0; j < numbers.size(); j++) {
            for (int i = 0; i < numbers.size() - 1; i++) {
                if (numberComparator.compare(numbers.get(i + 1), numbers.get(i)) < 0) {
                    //temporaryVariable = numbers.get(i+1);
                    //numbers.get(i+1) = numbers.get(i);
                    //numbers.get(i) = temporaryVariable;

                    numbers.set(temporaryVariable.getNumber(), numbers.get(i + 1));
                    numbers.set(i + 1, numbers.get(i));
                    numbers.set(i, temporaryVariable);
                }
            }
        }
        return numbers;
    }
}
