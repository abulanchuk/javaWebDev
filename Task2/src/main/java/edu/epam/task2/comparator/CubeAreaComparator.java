package edu.epam.task2.comparator;

import edu.epam.task2.entity.CustomCube;
import edu.epam.task2.warehouse.Warehouse;

import java.util.Comparator;

public class CubeAreaComparator implements Comparator<CustomCube>{
    Warehouse warehouse = Warehouse.getInstance();

    @Override
    public int compare(CustomCube firstCube, CustomCube secondCube) {
        double areaFirstCube = warehouse.getParameters(firstCube.getCustomCubeId()).getArea();
        double areaSecondCube = warehouse.getParameters(secondCube.getCustomCubeId()).getArea();

        return Double.compare(areaFirstCube,areaSecondCube);
    }
}
