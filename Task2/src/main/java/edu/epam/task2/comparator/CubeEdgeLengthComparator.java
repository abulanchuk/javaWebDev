package edu.epam.task2.comparator;

import edu.epam.task2.entity.CustomCube;
import edu.epam.task2.warehouse.Warehouse;

import java.util.Comparator;

public class CubeEdgeLengthComparator implements Comparator<CustomCube> {
    Warehouse warehouse = Warehouse.getInstance();

    @Override
    public int compare (CustomCube firstCube, CustomCube secondCube){
        double edgeLengthOfTheFirstCube =warehouse.getParameters(firstCube.getCustomCubeId()).getEdgeLength();
        double edgeLengthOfTheSecondCube =warehouse.getParameters(secondCube.getCustomCubeId()).getEdgeLength();

        return Double.compare(edgeLengthOfTheFirstCube,edgeLengthOfTheSecondCube);
    }
}
