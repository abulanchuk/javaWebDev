package edu.epam.task2.factory;

import edu.epam.task2.entity.CustomCube;
import edu.epam.task2.entity.CustomPoint;
import edu.epam.task2.exception.InvalidNumberOfPointsError;

public class CubeFromOnePointAndLength {

    public CustomCube createCubeFromOnePoint(CustomPoint point0, double length, int id) throws InvalidNumberOfPointsError {
        double x0 = point0.getX();
        double y0 = point0.getY();
        double z0 = point0.getZ();

        CustomPoint[] points = new CustomPoint[]{
                new CustomPoint(x0, y0 + length, z0),
                new CustomPoint(x0 + length, y0 + length, z0),
                new CustomPoint(x0 + length, y0, z0),
                new CustomPoint(x0, y0, z0 + length),
                new CustomPoint(x0, y0 + length, z0 + length),
                new CustomPoint(x0 + length, y0 + length, z0 + length),
                new CustomPoint(x0 + length, y0, z0 + length)
        };

        CustomCube cube = new CustomCube(points, id);
        return cube;
    }
}
