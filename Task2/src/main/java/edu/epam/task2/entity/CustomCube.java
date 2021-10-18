package edu.epam.task2.entity;

import edu.epam.task2.exception.InvalidNumberOfPointsError;
import edu.epam.task2.observer.Observable;
import edu.epam.task2.observer.Observer;
import edu.epam.task2.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class CustomCube implements Observable {
    long customCubeId;
    CustomPoint[] points;
    List<Observer> observers;

    public CustomCube(CustomPoint[] points) throws InvalidNumberOfPointsError {
        if (points.length != 8) {
            throw new InvalidNumberOfPointsError(8, points.length);
        }
        this.points = points;
        customCubeId = IdGenerator.generateId();
        observers = new ArrayList<>();
    }

    public CustomPoint[] getPoints() {
        return points;
    }

    public long getCustomCubeId() {
        return customCubeId;
    }

    public CustomPoint getPoint(int index) {
        //TODO: check index
        return points[index];
    }

    public void setPoint(CustomPoint point, int index) {
        points[index] = point;
        notifyObservers();
    }

    public void setPoints(CustomPoint[] points) {
        // TODO: check array length
        this.points = points;
        notifyObservers();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CustomCube cube = (CustomCube) o;
        for (int i = 0; i < points.length; i++) {
            if (!points[i].equals(cube.points[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        if (observers.isEmpty()) {
            return;
        }
        for (Observer observer : observers) {
            observer.cubeChanged(this);
        }
    }

    @Override
    public int hashCode() {
        //TODO
        return 0;
    }
}
