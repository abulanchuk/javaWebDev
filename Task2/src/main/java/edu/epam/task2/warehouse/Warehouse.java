package edu.epam.task2.warehouse;

import java.util.HashMap;
import java.util.Map;


import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Warehouse {
    static Logger logger = LogManager.getLogger(Warehouse.class);
    private Map<Long, CubeInfo> cubeParameters;
    private static Warehouse instance;

    private Warehouse() {
        cubeParameters = new HashMap<>();
    }

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    public void putCubeParameters(long shapeId, double area, double volume, double edgeLength) {
        CubeInfo cubeInfo = new CubeInfo(area, volume, edgeLength);
        cubeInfo.setArea(area);
        cubeInfo.setVolume(volume);
        cubeInfo.setEdgeLength(edgeLength);
        cubeParameters.put(shapeId, cubeInfo);
    }

    public void putParameters(long sphereId, CubeInfo cubeInfo) {
        cubeParameters.put(sphereId, cubeInfo);
    }

    public CubeInfo getParameters(long shapeId) {
        return cubeParameters.get(shapeId);
    }

    public boolean updateParameters(long sphereId, double area, double volume, double edgeLength) {
        CubeInfo cubeParameter = cubeParameters.get(sphereId);
        if (cubeParameter == null) {
            logger.log(Level.ERROR, "not found a cube with such id");
            return false;
        }
        cubeParameter.setArea(area);
        cubeParameter.setVolume(volume);
        cubeParameter.setEdgeLength(edgeLength);

        return true;
    }

}
