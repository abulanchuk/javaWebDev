package edu.epam.task5.entity;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Ferry {
    private static Logger logger = LogManager.getLogger(Ferry.class);
    private int capacity;
    private int howManyCarsInTheMoment;
    private boolean fullOrNot;

    public Ferry(int capacity, int howManyCarsInTheMoment, boolean fullOrNot) {
        this.capacity = capacity;
        this.howManyCarsInTheMoment = howManyCarsInTheMoment;
        this.fullOrNot = fullOrNot;

    }

    public boolean isFullOrNot() {
        if (howManyCarsInTheMoment < capacity) {
            fullOrNot = false;
        }
        logger.log(Level.INFO, "Ferry is full " + fullOrNot);
        return true;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getHowManyCarsInTheMoment() {
        return howManyCarsInTheMoment;
    }

    public synchronized void addToFerry() {
        while (isFullOrNot()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            howManyCarsInTheMoment++;
            logger.log(Level.INFO, "car went to ferry");
        }

    }

    public void removeFromFerry() {
        howManyCarsInTheMoment = 0;
        logger.log(Level.INFO, "car number went out from ferry");
    }
}
