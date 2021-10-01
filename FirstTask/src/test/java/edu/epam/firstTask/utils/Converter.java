package edu.epam.firstTask.utils;

import edu.epam.firstTask.array.Number;

import java.util.ArrayList;

public class Converter {
    public static ArrayList<Number> convertToArray(int[] array) {
        ArrayList<Number> numbers = new ArrayList<>();
        for (int element : array) {
            numbers.add(new Number(element));
        }
        return numbers;
    }
}
