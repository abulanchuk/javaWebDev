package edu.epam.task2.service;

import edu.epam.task2.entity.CustomCube;
import edu.epam.task2.exception.DoesNotCrossAxisException;

public interface PropertiesExtractor {
    double getEdgeLength(CustomCube cube);

    double countArea(CustomCube cube);

    double countVolume(CustomCube cube);

    double getVolumesRatio(CustomCube cube) throws DoesNotCrossAxisException;

    boolean checkIfTheFigureIsOnTheCoordinatePlane(CustomCube cube);
}
