package edu.epam.task2.selector.impl;

import edu.epam.task2.entity.CustomCube;
import edu.epam.task2.selector.Selector;
import edu.epam.task2.warehouse.Warehouse;

public class VolumeSelectorImpl implements Selector {
    private double maxVolume;

    public VolumeSelectorImpl(double maxVolume) {
        this.maxVolume = maxVolume;
    }

    @Override
    public boolean shouldSelect(CustomCube cube) {
        Warehouse warehouse = Warehouse.getInstance();
        double currentVolume = warehouse.getParameters(cube.getCustomCubeId()).getVolume();
        return Double.compare(currentVolume, maxVolume) < 0;
    }
}
