package edu.epam.task5.entity;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;

public class Ferry {
    private static Logger logger = LogManager.getLogger(Ferry.class);
    private int capacity;
    private int howManyCarsInTheMoment;
    private double totalWeightCars;
    private double maxWeight;
    private boolean fullOrNot;
    private List<Car> whatCarsOnAFerry;


    public Ferry(int capacity, int howManyCarsInTheMoment, double totalWeightCars, double maxWeight, boolean fullOrNot, List<Car> whatCarsOnAFerry) {
        this.capacity = capacity;
        this.howManyCarsInTheMoment = howManyCarsInTheMoment;
        this.totalWeightCars = totalWeightCars;
        this.maxWeight = maxWeight;
        this.fullOrNot = fullOrNot;
        this.whatCarsOnAFerry = whatCarsOnAFerry;
    }

    public boolean isFullOrNot() {
        if (howManyCarsInTheMoment < capacity || maxWeight > totalWeightCars) {
            return false;
        }
        logger.log(Level.INFO, "The ferry is full " + fullOrNot);
        return true;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public double getTotalWeightCars() {
        for (Car car : whatCarsOnAFerry) {
            totalWeightCars += car.getWeight();
        }
        return totalWeightCars;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getHowManyCarsInTheMoment() {
        return whatCarsOnAFerry.size();
    }

    public synchronized void addToFerry() {
        while (isFullOrNot()) {
            try {
                wait();
            } catch (InterruptedException e) {
                logger.log(Level.INFO, "The ferry is full" + e);
                e.printStackTrace();
            }
            howManyCarsInTheMoment++;
            logger.log(Level.INFO, "The car went to ferry");
        }

    }

    public void removeFromFerry() {
        whatCarsOnAFerry.removeAll(whatCarsOnAFerry);
        howManyCarsInTheMoment = whatCarsOnAFerry.size();
        fullOrNot = false;
        logger.log(Level.INFO, "The cars went out from ferry");
    }

    public List<Car> getWhatCarsOnAFerry() {
        return whatCarsOnAFerry;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ferry{");
        sb.append("capacity=").append(capacity);
        sb.append(", howManyCarsInTheMoment=").append(howManyCarsInTheMoment);
        sb.append(", totalWeightCars=").append(totalWeightCars);
        sb.append(", maxWeight=").append(maxWeight);
        sb.append(", fullOrNot=").append(fullOrNot);
        sb.append(", whatCarsOnAFerry=").append(whatCarsOnAFerry);
        sb.append('}');
        return sb.toString();
    }
}
