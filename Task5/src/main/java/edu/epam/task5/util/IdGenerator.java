package edu.epam.task5.util;

public class IdGenerator {
    private static long counter = 0;

    public static long generateId() {
        return ++counter;

    }
}
