package edu.epam.task2.util;

public class IdGenerator {
    private static long counter = 0;

    public static long generateId() {
      return  ++counter;

    }

}
