package edu.epam.task5.entity;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Ferry {
    private static Logger logger = LogManager.getLogger(Ferry.class);
    private int capacity;
    private boolean fullOrNot;

    public Ferry(int capacity, boolean fullOrNot) {
        this.capacity = capacity;
        this.fullOrNot = fullOrNot;
    }

    public boolean isFullOrNot() {
        logger.log(Level.INFO, "Ferry is full " + fullOrNot);
        return fullOrNot;
    }
}
