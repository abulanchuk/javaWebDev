package edu.epam.firsttask.entity;

import java.util.Arrays;

public class CustomArray {
    int[] array;

    public CustomArray(int[] array) {
        this.array = array;
    }

    public int get(int i) {
        return array[i];
    }

    public int[] getArray() {
        return Arrays.copyOf(array, array.length);
    }

    public int getLength() {
        return array.length;
    }

    public void set(int i, int newValue) {
        this.array[i] = newValue;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i : array) {
            stringBuilder.append(i).append(" ");
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
