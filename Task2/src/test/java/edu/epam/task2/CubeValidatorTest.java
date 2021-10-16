package edu.epam.task2;

import edu.epam.task2.entity.CustomCube;
import edu.epam.task2.entity.CustomPoint;
import edu.epam.task2.validator.shape.impl.CubeValidator;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CubeValidatorTest {
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

    CustomPoint[] incorrectPoints = new CustomPoint[]{
            new CustomPoint(1, 0, 0),
            new CustomPoint(0, 4, 0),
            new CustomPoint(4, 4, 0),
            new CustomPoint(4, 0, 0),
            new CustomPoint(0, 0, 4),
            new CustomPoint(0, 4, 4),
            new CustomPoint(4, 4, 4),
            new CustomPoint(4, 0, 4)
    };
    CubeValidator cubeValidator = new CubeValidator();

    @Test
    public void testIsCubeCorrect() {
        CustomCube cube = new CustomCube(correctPoints, 1);
        boolean isCorrect = cubeValidator.isCube(cube);
        assertTrue(isCorrect);
    }

    @Test
    public void testIsCubeIncorrect() {
        CustomCube cube = new CustomCube(incorrectPoints, 1);
        boolean isCorrect = cubeValidator.isCube(cube);
        assertFalse(isCorrect);
    }
}