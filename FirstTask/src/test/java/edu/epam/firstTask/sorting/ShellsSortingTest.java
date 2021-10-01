package edu.epam.firstTask.sorting;

import edu.epam.firstTask.array.Number;
import edu.epam.firstTask.utils.Checker;
import org.testng.annotations.Test;
import edu.epam.firstTask.utils.Converter;

import java.util.ArrayList;

import static org.testng.Assert.*;

public class ShellsSortingTest {
    ShellsSorting sorter = new ShellsSorting();

    @Test
    public void testShellSort() {
        ArrayList<Number> inputsBeforeSorting = Converter.convertToArray(new int[]{2, -1, -3, 4, -7});
        ArrayList<Number> outputsAfterSorting = Converter.convertToArray(new int[]{-7, -3, -1, 2, 4});
        ArrayList<Number> replaceArray = sorter.shellSort(inputsBeforeSorting);
        assertTrue(
                Checker.areArraysEqual(replaceArray, outputsAfterSorting)
        );
    }
}