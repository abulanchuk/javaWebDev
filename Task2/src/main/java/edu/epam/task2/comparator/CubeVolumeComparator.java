package edu.epam.task2.comparator;

import edu.epam.task2.entity.CustomCube;
import edu.epam.task2.warehouse.Warehouse;

import java.util.Comparator;

public class CubeVolumeComparator implements Comparator<CustomCube> {
    Warehouse warehouse = Warehouse.getInstance();

    @Override
    public int compare(CustomCube firstCube, CustomCube secondCube) {
        double volumeFirstCube = warehouse.getParameters(firstCube.getCustomCubeId()).getVolume();
        double volumeSecondCube = warehouse.getParameters(secondCube.getCustomCubeId()).getVolume();

        return Double.compare(volumeFirstCube, volumeSecondCube);
    }
}
