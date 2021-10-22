package edu.epam.task2.service.impl;

import edu.epam.task2.entity.CustomCube;
import edu.epam.task2.entity.CustomPoint;
import edu.epam.task2.exception.DoesNotCrossAxisException;
import edu.epam.task2.service.PropertiesExtractor;


public class  PropertiesExtractorImpl implements PropertiesExtractor {
    private static PropertiesExtractorImpl instance;

    public static PropertiesExtractorImpl getInstance() {
        if (instance == null) {
            instance = new PropertiesExtractorImpl();
        }
        return instance;
    }
    @Override
    public double getEdgeLength(CustomCube cube) {
        double firstPointX = cube.getPoint(0).getX();
        double secondPointX = cube.getPoint(3).getX();
        return secondPointX - firstPointX;
    }

    @Override
    public double countArea(CustomCube cube) {
        double length = getEdgeLength(cube);
        return 6 * Math.pow(length, 2);
    }

    @Override
    public double countVolume(CustomCube cube) {
        double length = getEdgeLength(cube);
        return Math.pow(length, 3);
    }

    @Override
    public double getVolumesRatio(CustomCube cube) throws DoesNotCrossAxisException {
        double topPointZ = cube.getPoint(7).getZ();
        double bottomPointZ = cube.getPoint(3).getZ();
        if (bottomPointZ > 0 || topPointZ < 0) {
            throw new DoesNotCrossAxisException("The figure does not intersect with the coordinate axis");
        }
        if (bottomPointZ == 0 || topPointZ == 0) {
            return 0;
        }
        return topPointZ / -bottomPointZ;
    }

    @Override
    public boolean checkIfTheFigureIsOnTheCoordinatePlane(CustomCube cube) {
        CustomPoint bottomPoint = cube.getPoint(0);
        CustomPoint topPoint = cube.getPoint(6);
        if (bottomPoint.getX() == 0 || bottomPoint.getY() == 0 || bottomPoint.getZ() == 0) {
            return true;
        }
        if (topPoint.getX() == 0 || topPoint.getY() == 0 || topPoint.getZ() == 0) {
            return true;
        }
        return false;
    }

}
