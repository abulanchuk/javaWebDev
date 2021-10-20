package edu.epam.task2.selector.impl;

import edu.epam.task2.entity.CustomCube;
import edu.epam.task2.selector.Selector;
import edu.epam.task2.warehouse.Warehouse;

public class AreaFromRangeSelectorImpl implements Selector {
    long minValue;
    long maxValue;

    public AreaFromRangeSelectorImpl(long minValue, long maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    @Override
    public boolean shouldSelect(CustomCube cube) {
        Warehouse warehouse = Warehouse.getInstance();
        double currentArea = warehouse.getParameters(cube.getCustomCubeId()).getArea();
        return currentArea > minValue && currentArea < maxValue;
    }
}
