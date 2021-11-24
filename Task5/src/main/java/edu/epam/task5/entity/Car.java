package edu.epam.task5.entity;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Car {
    private static Logger logger = LogManager.getLogger(Car.class);
    private int idCar;
    private String carNumber;
    private float weight;

    public Car(int idCar, String carNumber, float weight) {
        this.idCar = idCar;
        this.carNumber = carNumber;
        this.weight = weight;
    }

    public int getIdCar() {
        return idCar;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public float getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Car{");
        sb.append("idCar=").append(idCar);
        sb.append(", carNumber='").append(carNumber).append('\'');
        sb.append(", weight=").append(weight);
        sb.append('}');
        return sb.toString();
    }
}
