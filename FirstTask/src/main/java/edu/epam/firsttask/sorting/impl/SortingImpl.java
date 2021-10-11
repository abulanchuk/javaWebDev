package edu.epam.firsttask.sorting.impl;

import edu.epam.firsttask.entity.CustomArray;

import edu.epam.firsttask.sorting.Sorting;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Arrays;

public class SortingImpl implements Sorting {
    static Logger logger = LogManager.getLogger(SortingImpl.class);

    @Override
    public CustomArray selectionSort(CustomArray array) {
        int[] integerArray = array.getArray();

        for (int i = 0; i < integerArray.length; i++) {
            int min = integerArray[i];
            int idxMin = i;

            for (int j = i + 1; j < integerArray.length; j++) {
                if (integerArray[j] < min) {
                    min = integerArray[j];
                    idxMin = j;
                }
            }
            integerArray[idxMin] = integerArray[i];
            integerArray[i] = min;
        }
        logger.log(Level.INFO,Arrays.toString(new CustomArray[]{array}) + "Selection Sorting array: " + Arrays.toString(integerArray));
        return new CustomArray(integerArray);
    }

    @Override
    public CustomArray shellSort(CustomArray array) {
        int[] integerArray = array.getArray();
        for (int i = 0; i < integerArray.length - 1; i++) {
            int value = integerArray[i];
            if (integerArray[i] > integerArray[i + 1]) {
                integerArray[i] = integerArray[i + 1];
                integerArray[i + 1] = value;
                i = i - 2;
                if (i < 0) {
                    i = -1;
                }
            }
        }
        logger.log(Level.INFO, Arrays.toString(new CustomArray[]{array}) + "\nShell's sorting array: " + Arrays.toString(integerArray));
        return new CustomArray(integerArray);
    }

    @Override
    public CustomArray sortByInserts(CustomArray array) {
        int[] integerArray = array.getArray();
        for (int i = 0; i < integerArray.length; i++) {
            int value = integerArray[i];

            int j = i - 1;
            while (j >= 0) {
                if (value >= integerArray[j]) {
                    break;
                }

                integerArray[j + 1] = integerArray[j];
                j--;
            }
            integerArray[j + 1] = value;
        }

        logger.log(Level.INFO, Arrays.toString(new CustomArray[]{array}) + "\nArray sorting by inserts: " + Arrays.toString(integerArray));
        return new CustomArray(integerArray);
    }
}
