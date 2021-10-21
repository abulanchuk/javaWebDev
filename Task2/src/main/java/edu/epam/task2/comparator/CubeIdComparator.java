package edu.epam.task2.comparator;

import edu.epam.task2.entity.CustomCube;

import java.util.Comparator;

public class CubeIdComparator implements Comparator<CustomCube> {

    @Override
    public int compare (CustomCube firstCube, CustomCube secondCube){
        long cubeFirstId = firstCube.getCustomCubeId();
        long cubeSecondId = secondCube.getCustomCubeId();

        return Long.compare(cubeFirstId,cubeSecondId);
    }
}
