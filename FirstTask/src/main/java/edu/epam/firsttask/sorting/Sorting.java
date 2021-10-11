package edu.epam.firsttask.sorting;

import edu.epam.firsttask.entity.CustomArray;

public interface Sorting {
    CustomArray selectionSort(CustomArray array);

    CustomArray shellSort(CustomArray array);

    CustomArray sortByInserts(CustomArray array);
}
