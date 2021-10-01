package edu.epam.firstTask.sorting;

import edu.epam.firstTask.array.Number;
import org.testng.annotations.Test;
import edu.epam.firstTask.utils.Checker;
import edu.epam.firstTask.utils.Converter;

import java.util.ArrayList;

import static org.testng.Assert.*;

public class SelectionSortingTest {
    SelectionSorting selectionSorting = new SelectionSorting();

    @Test
    public void testSelectionSort() {
        ArrayList<Number> inputsBeforeSorting = Converter.convertToArray(new int[]{2, -1, -3, 4, -7});
        ArrayList<Number> outputsAfterSorting = Converter.convertToArray(new int[]{-7, -3, -1, 2, 4});

        ArrayList<Number> sortingArray = selectionSorting.selectionSort(inputsBeforeSorting);
        assertTrue(
                Checker.areArraysEqual(sortingArray, outputsAfterSorting)
        );
    }
}
