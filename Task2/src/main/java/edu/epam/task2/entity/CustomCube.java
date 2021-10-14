package edu.epam.task2.entity;

import edu.epam.task2.exception.InvalidNumberOfPointsError;

public class CustomCube {
    CustomPoint[] points;
    int shapeId;

    public CustomCube(CustomPoint[] points, int shapeId) throws InvalidNumberOfPointsError {
        if (points.length != 8) {
            throw new InvalidNumberOfPointsError(8, points.length);
        }

        this.points = points;
        this.shapeId = shapeId;
    }

    public CustomPoint[] getPoints() {
        return points;
    }

    public int getShapeId() {
        return shapeId;
    }

    public CustomPoint getPoint(int index){
        //TODO: check index
        return points[index];
    }
}
