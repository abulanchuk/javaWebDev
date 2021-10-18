package edu.epam.task2.wareHouse;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    Map<Long, CubeInfo> shapeParameters;
    private static Warehouse instance;

    private Warehouse() {
        shapeParameters = new HashMap<>();
    }

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }
    public void putShapeParameters(long shapeId, double area, double volume){
        CubeInfo cubeInfo = new CubeInfo(area, volume);
        cubeInfo.setArea(area);
        cubeInfo.setVolume(volume);
        shapeParameters.put(shapeId, cubeInfo);
    }
    public void putParameters(long sphereId,  CubeInfo cubeInfo) {
        shapeParameters.put(sphereId, cubeInfo);
    }

    public CubeInfo getParameters(long shapeId) {
        return shapeParameters.get(shapeId);
    }

    
}
