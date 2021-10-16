package edu.epam.task2;

import edu.epam.task2.entity.CustomCube;
import edu.epam.task2.entity.CustomPoint;
import edu.epam.task2.factory.CubeFactory;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class CubeFactoryTest {
    CustomPoint[] correctPoints = new CustomPoint[]{
            new CustomPoint(0, 0, 0),
            new CustomPoint(0, 4, 0),
            new CustomPoint(4, 4, 0),
            new CustomPoint(4, 0, 0),
            new CustomPoint(0, 0, 4),
            new CustomPoint(0, 4, 4),
            new CustomPoint(4, 4, 4),
            new CustomPoint(4, 0, 4)
    };

    @Test
    public void testCreateCubeFromOnePoint() {
        CustomPoint point = new CustomPoint(0, 0, 0);
        double length = 4.0;
        CubeFactory cubeFactory = new CubeFactory();
        CustomCube cubeFromMethod = cubeFactory.createCubeFromOnePoint(point, length, 1);
        CustomCube cube = new CustomCube(correctPoints, 1);
       assertEquals(cubeFromMethod,cube);
    }

}