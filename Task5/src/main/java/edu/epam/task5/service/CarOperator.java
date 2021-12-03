package edu.epam.task5.service;

import edu.epam.task5.entity.Car;
import edu.epam.task5.entity.Ferry;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class CarOperator implements Runnable {
    private Car car;

    public CarOperator(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextLong(0, 5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Ferry ferry = Ferry.getInstance();
        ferry.addToQueue(car);
    }
}
