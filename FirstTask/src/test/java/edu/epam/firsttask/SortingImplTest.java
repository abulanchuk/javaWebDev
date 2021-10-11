package edu.epam.firsttask;

import edu.epam.firsttask.entity.CustomArray;
import edu.epam.firsttask.factory.CustomArrayFactory;
import edu.epam.firsttask.sorting.impl.SortingImpl;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SortingImplTest {
    SortingImpl sorter = new SortingImpl();

    CustomArray inputArray = CustomArrayFactory.fromIntegers(2, -1, -3, 4, -7);
    CustomArray referenceArray = CustomArrayFactory.fromIntegers(-7, -3, -1, 2, 4);

    @Test
    public void testSelectionSort() {
        CustomArray sortedArray = sorter.selectionSort(inputArray);
        assertEquals(sortedArray.getArray(), referenceArray.getArray());
    }

    @Test
    public void testShellSort() {
        CustomArray sortedArray = sorter.shellSort(inputArray);
        assertEquals(sortedArray.getArray(), referenceArray.getArray());
    }

    @Test
    public void testSortByInserts() {
        CustomArray sortedArray = sorter.sortByInserts(inputArray);
        assertEquals(sortedArray.getArray(), referenceArray.getArray());

    }
}