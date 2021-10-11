package edu.epam.task2.entity;

import edu.epam.task2.exception.InvalidNumberOfPointsError;

public class CustomCube {
    CustomPoint[] points;
    int id;

    public CustomCube(CustomPoint[] points, int id) throws InvalidNumberOfPointsError {
        if (points.length != 8) {
            throw new InvalidNumberOfPointsError(8, points.length);
        }

        this.points = points;
        this.id = id;
    }

    public CustomPoint[] getPoints() {
        return points;
    }

    public int getId() {
        return id;
    }

    public CustomPoint getPoint(int index){
        //TODO: check index
        return points[index];
    }
}
