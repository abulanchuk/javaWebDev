package edu.epam.task2.exception;

public class InvalidNumberOfPointsError extends Exception{
    public InvalidNumberOfPointsError(int expectedCount, int actualCount) {
        super("Expected " + expectedCount + ", got " + actualCount);
    }
}
