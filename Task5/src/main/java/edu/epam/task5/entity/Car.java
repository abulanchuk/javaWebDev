package edu.epam.task5.entity;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Car {
    private static Logger logger = LogManager.getLogger(Car.class);
    private int carNumber;

    public Car(int carNumber) {
        this.carNumber = carNumber;
    }

    public int getCarNumber() {
        return carNumber;
    }


}
