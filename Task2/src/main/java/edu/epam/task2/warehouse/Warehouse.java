package edu.epam.task2.warehouse;

import java.util.HashMap;
import java.util.Map;


import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Warehouse {
    static Logger logger = LogManager.getLogger(Warehouse.class);
    Map<Long, CubeInfo> cubeParameters;
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

    public void putCubeParameters(long shapeId, double area, double volume) {
        CubeInfo cubeInfo = new CubeInfo(area, volume);
        cubeInfo.setArea(area);
        cubeInfo.setVolume(volume);
        cubeParameters.put(shapeId, cubeInfo);
    }

    public void putParameters(long sphereId, CubeInfo cubeInfo) {
        cubeParameters.put(sphereId, cubeInfo);
    }

    public CubeInfo getParameters(long shapeId) {
        return cubeParameters.get(shapeId);
    }

    public boolean updateParameters(long sphereId, double area, double volume) {
        CubeInfo sphereParameter = cubeParameters.get(sphereId);
        if (sphereParameter == null) {
            logger.log(Level.ERROR, "not found a cube with such id");
            return false;
        }
        sphereParameter.setArea(area);
        sphereParameter.setVolume(volume);
        return true;
    }

}
