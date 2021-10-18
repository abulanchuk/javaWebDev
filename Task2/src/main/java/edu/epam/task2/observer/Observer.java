package edu.epam.task2.observer;

import edu.epam.task2.entity.CustomCube;

public interface Observer {
    void cubeChanged(CustomCube cube);
}
