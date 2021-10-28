package edu.epam.task2.observer.impl;

import edu.epam.task2.entity.CustomCube;
import edu.epam.task2.observer.Observer;
import edu.epam.task2.service.impl.PropertiesExtractorImpl;
import edu.epam.task2.warehouse.Warehouse;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class WarehouseUpdaterImpl implements Observer {
    private static Logger logger = LogManager.getLogger(WarehouseUpdaterImpl.class);

    @Override
    public void cubeChanged(CustomCube cube) {
        PropertiesExtractorImpl propertiesExtractor = PropertiesExtractorImpl.getInstance();
        double volume = propertiesExtractor.countVolume(cube);
        double area = propertiesExtractor.countArea(cube);
        double edgeLength = propertiesExtractor.getEdgeLength(cube);

        Warehouse warehouse = Warehouse.getInstance();
        warehouse.updateParameters(cube.getCustomCubeId(), area, volume, edgeLength);
        logger.log(Level.INFO, "Updated cube parameters.");
    }
}
