package edu.epam.task2;

import edu.epam.task2.entity.CustomCube;
import edu.epam.task2.entity.CustomPoint;
import edu.epam.task2.exception.DoesNotCrossAxisException;
import edu.epam.task2.service.impl.PropertiesExtractorImpl;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PropertiesExtractorImplTest {
    CustomPoint[] correctPoints = new CustomPoint[]{
            new CustomPoint(0, 0, -1),
            new CustomPoint(0, 4, -1),
            new CustomPoint(4, 4, -1),
            new CustomPoint(4, 0, -1),
            new CustomPoint(0, 0, 3),
            new CustomPoint(0, 4, 3),
            new CustomPoint(4, 4, 3),
            new CustomPoint(4, 0, 3)
    };
    CustomCube cube = new CustomCube(correctPoints);

    PropertiesExtractorImpl propertiesExtractor = PropertiesExtractorImpl.getInstance();

    @Test
    public void testGetEdgeLength() {
        double lengthFromMethod = propertiesExtractor.getEdgeLength(cube);
        double correctLength = 4.0;
        assertEquals(lengthFromMethod, correctLength);
    }

    @Test
    public void testCountArea() {
        double areaFromMethod = propertiesExtractor.countArea(cube);
        double correctArea = 96.0;
        assertEquals(areaFromMethod, correctArea);
    }

    @Test
    public void testCountVolume() {
        double volumeFromMethod = propertiesExtractor.countVolume(cube);
        double correctVolume = 64.0;
        assertEquals(volumeFromMethod, correctVolume);
    }

    @Test
    public void testGetVolumesRatio() throws DoesNotCrossAxisException {
        double volumesRatio = propertiesExtractor.getVolumesRatio(cube);
        double correctVolumesRatio = 3;
        assertEquals(volumesRatio, correctVolumesRatio);
    }

    @Test
    public void testCheckIfTheFigureIsOnTheCoordinatePlane() {
        boolean resultFromMethod = propertiesExtractor.checkIfTheFigureIsOnTheCoordinatePlane(cube);
        assertTrue(resultFromMethod);
    }
}