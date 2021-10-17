package edu.epam.task2.entity;

import edu.epam.task2.exception.InvalidNumberOfPointsError;
import edu.epam.task2.util.IdGenerator;

import java.util.Arrays;

public class CustomCube {
    CustomPoint[] points;
    long shapeId = IdGenerator.generateId();

    public CustomCube(CustomPoint[] points) throws InvalidNumberOfPointsError {
        if (points.length != 8) {
            throw new InvalidNumberOfPointsError(8, points.length);
        }

        this.points = points;
    }

    public CustomPoint[] getPoints() {
        return points;
    }

    public long getShapeId() {
        return shapeId;
    }

    public CustomPoint getPoint(int index) {
        //TODO: check index
        return points[index];
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
    public int hashCode() {
        //TODO
        return 0;
    }
}
