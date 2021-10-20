package edu.epam.task2.selector.impl;

import edu.epam.task2.entity.CustomCube;
import edu.epam.task2.entity.CustomPoint;
import edu.epam.task2.selector.Selector;

public class PointInARangeImpl implements Selector {
    double rangeXMin;
    double rangeXMax;

    double rangeYMin;
    double rangeYMax;

    double rangeZMin;
    double rangeZMax;

    public PointInARangeImpl(double rangeXMin, double rangeXMax, double rangeYMin, double rangeYMax, double rangeZMin, double rangeZMax) {
        this.rangeXMin = rangeXMin;
        this.rangeXMax = rangeXMax;
        this.rangeYMin = rangeYMin;
        this.rangeYMax = rangeYMax;
        this.rangeZMin = rangeZMin;
        this.rangeZMax = rangeZMax;
    }

    @Override
    public boolean shouldSelect(CustomCube cube) {
        for (int i = 0; i < cube.getPoints().length; i++) {
            CustomPoint cubePoint = cube.getPoint(i);
            boolean cubeInTheRangeAlongXAxis = cubePoint.getX() > rangeXMin && cubePoint.getX() < rangeXMax;
            boolean cubeInTheRangeAlongYAxis = cubePoint.getY() > rangeYMin && cubePoint.getY() < rangeYMax;
            boolean cubeInTheRangeAlongZAxis = cubePoint.getZ() > rangeZMin && cubePoint.getZ() < rangeZMax;
            if (!cubeInTheRangeAlongXAxis || !cubeInTheRangeAlongYAxis || !cubeInTheRangeAlongZAxis){
                return false;
            }
        }
        return true;
    }
}
