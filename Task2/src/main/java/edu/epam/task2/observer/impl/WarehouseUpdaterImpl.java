package edu.epam.task2.observer.impl;

import edu.epam.task2.entity.CustomCube;
import edu.epam.task2.observer.Observer;
import edu.epam.task2.service.impl.PropertiesExtractorImpl;
import edu.epam.task2.warehouse.Warehouse;

public class WarehouseUpdaterImpl implements Observer {
    @Override
    public void cubeChanged(CustomCube cube) {
        PropertiesExtractorImpl propertiesExtractor = new PropertiesExtractorImpl();
        double volume = propertiesExtractor.countVolume(cube);
        double area = propertiesExtractor.countArea(cube);

        Warehouse warehouse = Warehouse.getInstance();
        warehouse.updateParameters(cube.getCustomCubeId(), area, volume);
    }
}
