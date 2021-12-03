package edu.epam.task5.entity;


public class Car {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (idCar != car.idCar) return false;
        if (Double.compare(car.weight, weight) != 0) return false;
        return carNumber != null ? carNumber.equals(car.carNumber) : car.carNumber == null;
    }

    @Override
    public int hashCode() {
        int result =idCar;
        result = 31 * result + (carNumber!=null ? carNumber.hashCode() : 0);
        result = 31 * result + Float.floatToIntBits(weight);
        return result;
    }
}
