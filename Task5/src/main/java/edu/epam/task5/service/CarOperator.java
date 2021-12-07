package edu.epam.task5.service;

import edu.epam.task5.entity.Car;
import edu.epam.task5.entity.Ferry;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class CarOperator implements Runnable {
    private static Logger logger = LogManager.getLogger(CarOperator.class);
    private Car car;

    public CarOperator(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextLong(0, 5000));
        } catch (InterruptedException e) {
            logger.log(Level.ERROR, e);
            e.printStackTrace();
        }

        Ferry ferry = Ferry.getInstance();
        ferry.addToQueue(car);
    }
}
