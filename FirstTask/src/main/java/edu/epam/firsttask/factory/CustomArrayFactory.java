package edu.epam.firsttask.factory;

import edu.epam.firsttask.entity.CustomArray;

public class CustomArrayFactory {
    public static CustomArray fromIntegers(int... args) {
        return new CustomArray(args);
    }
}
