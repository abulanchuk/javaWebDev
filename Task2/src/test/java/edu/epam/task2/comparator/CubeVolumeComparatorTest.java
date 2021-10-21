package edu.epam.task2.comparator;

import edu.epam.task2.entity.CustomCube;
import edu.epam.task2.entity.CustomPoint;
import edu.epam.task2.factory.CubeFactory;
import edu.epam.task2.warehouse.Warehouse;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CubeVolumeComparatorTest {

    CustomCube firstCube;
    CustomCube secondCube;
    CustomCube thirdCube;

    @BeforeTest
    public void setUp() {
        firstCube = CubeFactory.getInstance().createCubeFromOnePoint(new CustomPoint(0, 0, 0), 4);
        Warehouse.getInstance().putCubeParameters(firstCube.getCustomCubeId(), 96, 64, 4);
        secondCube = CubeFactory.getInstance().createCubeFromOnePoint(new CustomPoint(0, 0, 0), 4);
        Warehouse.getInstance().putCubeParameters(secondCube.getCustomCubeId(), 96, 64, 4);

        thirdCube = CubeFactory.getInstance().createCubeFromOnePoint(new CustomPoint(0, 0, 0), 5);
        Warehouse.getInstance().putCubeParameters(thirdCube.getCustomCubeId(), 150, 125, 5);
    }

    @Test
    public void testCompareAreEqual() {
        CubeEdgeLengthComparator comparator = new CubeEdgeLengthComparator();
        int result = comparator.compare(firstCube,secondCube);
        assertEquals(result, 0);
    }
    @Test
    public void testCompareThirdMore() {
        CubeEdgeLengthComparator comparator = new CubeEdgeLengthComparator();
        int result = comparator.compare(thirdCube,secondCube);
        assertEquals(result, 1);
    }

    @Test
    public void testCompareThirdLess() {
        CubeEdgeLengthComparator comparator = new CubeEdgeLengthComparator();
        int result = comparator.compare(secondCube,thirdCube);
        assertEquals(result, -1);
    }
}