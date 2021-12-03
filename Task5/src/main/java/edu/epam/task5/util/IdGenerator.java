package edu.epam.task5.util;

public class IdGenerator {
    private static int counter = 0;

    public static int generateId() {
        return ++counter;

    }
}
