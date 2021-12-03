package edu.epam.task5.entity;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ferry {
    private int capacity = 5;
    private double maxWeight = 12000d;

    private int howManyCarsInTheMoment;
    private int totalCarsServed;
    private double totalWeightCars;

    private List<Car> whatCarsOnAFerry;

    private Lock queueLock;
    private static Lock lockForSingleton = new ReentrantLock(true);
    private static Ferry queueInstance = null;


    public Ferry() {
        totalCarsServed = 0;
        whatCarsOnAFerry = new ArrayList<>();
        queueLock = new ReentrantLock();
    }

    public static Ferry getInstance() {
        try {
            lockForSingleton.lock();
            if (queueInstance == null) {
                queueInstance = new Ferry();
            }
        } finally {
            lockForSingleton.unlock();
        }
        return queueInstance;
    }

    public boolean canAcceptCar(Car car) {
        if (getMaxWeight() < totalWeightCars + car.getWeight()) {
            return false;
        }

        return getCapacity() >= getHowManyCarsInTheMoment() + 1;
    }

    public void addToQueue(Car car) {
        try {
            queueLock.lock();
            System.out.println("NEW CAR: " + car);

            if (!canAcceptCar(car)) {
                System.out.println("CANT ACCEPT CAR " + car + ", FERRY: " + this);
                shipCars();
            }

            System.out.println("EMBARK: " + car);
            embarkCar(car);
            if (totalCarsServed + whatCarsOnAFerry.size() == 14) { // TODO
                shipCars();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            queueLock.unlock();
        }
    }

    public void embarkCar(Car car) {
        whatCarsOnAFerry.add(car);
        totalWeightCars += car.getWeight();
        howManyCarsInTheMoment++;
    }

    public void unloadAll() {
        howManyCarsInTheMoment = 0;
        totalCarsServed += whatCarsOnAFerry.size();
        whatCarsOnAFerry.clear();
        totalWeightCars = 0;
    }

    public void shipCars() throws InterruptedException {
        System.out.println("FERRY: Departure, cars on board: " + whatCarsOnAFerry.size());
        TimeUnit.SECONDS.sleep(4);
        System.out.println("FERRY: Arrival");
        unloadAll();
    }

    public double getMaxWeight() {
        return maxWeight;
    }


    public int getCapacity() {
        return capacity;
    }

    public int getHowManyCarsInTheMoment() {
        return whatCarsOnAFerry.size();
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
        sb.append(", totalServed=").append(totalCarsServed);
        sb.append(", whatCarsOnAFerry=").append(whatCarsOnAFerry);
        sb.append('}');
        return sb.toString();
    }

}
