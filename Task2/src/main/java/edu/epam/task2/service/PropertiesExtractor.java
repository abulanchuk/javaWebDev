package edu.epam.task2.service;

import edu.epam.task2.entity.CustomCube;

public class PropertiesExtractor {
    public double getEdgeLength(CustomCube cube) {
        double firstPointX = cube.getPoint(0).getX();
        double secondPointX = cube.getPoint(3).getX();
        return secondPointX - firstPointX;
    }
}
