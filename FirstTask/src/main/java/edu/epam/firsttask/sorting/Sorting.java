package edu.epam.firsttask.sorting;

import edu.epam.firsttask.entity.CustomArray;

public class Sorting {
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
        return new CustomArray(integerArray);
    }

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
        return new CustomArray(integerArray);
    }

    public CustomArray sortByInserts(CustomArray array) {
        int[] integerArray = array.getArray();
        for (int i = 0; i < integerArray.length; i++) {
            int value = integerArray[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (value < integerArray[j]) {
                    integerArray[j + 1] = integerArray[j];
                } else {
                    break;
                }
            }
            integerArray[j + 1] = value;
        }
        return new CustomArray(integerArray);
    }
}
