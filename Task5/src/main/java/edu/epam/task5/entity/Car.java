package edu.epam.task5.entity;


public class Car {
    private long idCar;
    private String carNumber;
    private double weight;

    public Car(long idCar, String carNumber, double weight) {
        this.idCar = idCar;
        this.carNumber = carNumber;
        this.weight = weight;
    }

    public long getIdCar() {
        return idCar;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public double getWeight() {
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
