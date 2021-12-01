package edu.epam.task5.entity;


import java.util.ArrayList;
import java.util.List;

public class Ferry {
    private int capacity;
    private int howManyCarsInTheMoment;
    private double totalWeightCars;
    private double maxWeight;
    private boolean fullOrNot;
    private List<Car> whatCarsOnAFerry;


    public Ferry(int capacity, double maxWeight) {
        whatCarsOnAFerry = new ArrayList<>();
        this.capacity = capacity;
        this.maxWeight = maxWeight;
    }

    public boolean isFullOrNot() {
        if (howManyCarsInTheMoment < capacity || maxWeight > totalWeightCars) {
            return false;
        }
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
                e.printStackTrace();
            }
            howManyCarsInTheMoment++;
        }

    }

    public void removeFromFerry() {
        whatCarsOnAFerry.removeAll(whatCarsOnAFerry);
        howManyCarsInTheMoment = whatCarsOnAFerry.size();
        fullOrNot = false;
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
