package edu.epam.task2.validator.shape.impl;

import edu.epam.task2.entity.CustomCube;
import edu.epam.task2.entity.CustomPoint;
import edu.epam.task2.validator.inputformat.impl.ValidatorImpl;
import edu.epam.task2.validator.shape.ShapeValidator;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class CubeValidator implements ShapeValidator {
    private static Logger logger = LogManager.getLogger(CubeValidator.class);

    private boolean checkZAxisAlignment(CustomPoint first, CustomPoint second) {
        boolean zDoNotMatch = first.getZ() != second.getZ();
        boolean yMatches = first.getY() == second.getY();
        boolean xMatches = first.getX() == second.getX();

        return zDoNotMatch && yMatches && xMatches;
    }

    private boolean checkYAxisAlignment(CustomPoint first, CustomPoint second) {
        boolean yDoNotMatch = first.getY() != second.getY();
        boolean zMatches = first.getZ() == second.getZ();
        boolean xMatches = first.getX() == second.getX();

        return yDoNotMatch && zMatches && xMatches;
    }

    private boolean checkXAxisAlignment(CustomPoint first, CustomPoint second) {
        boolean xDoNotMatch = first.getX() != second.getX();
        boolean zMatches = first.getZ() == second.getZ();
        boolean yMatches = first.getY() == second.getY();

        return xDoNotMatch && zMatches && yMatches;
    }

    @Override
    public boolean isCube(CustomCube cube) {
        boolean xAlignment = checkXAxisAlignment(cube.getPoint(0), cube.getPoint(3)) &&
                checkXAxisAlignment(cube.getPoint(1), cube.getPoint(2)) &&
                checkXAxisAlignment(cube.getPoint(4), cube.getPoint(7)) &&
                checkXAxisAlignment(cube.getPoint(5), cube.getPoint(6));

        boolean zAlignment = checkZAxisAlignment(cube.getPoint(0), cube.getPoint(4)) &&
                checkZAxisAlignment(cube.getPoint(3), cube.getPoint(7)) &&
                checkZAxisAlignment(cube.getPoint(1), cube.getPoint(5)) &&
                checkZAxisAlignment(cube.getPoint(2), cube.getPoint(6));

        boolean yAlignment = checkYAxisAlignment(cube.getPoint(0), cube.getPoint(1)) &&
                checkYAxisAlignment(cube.getPoint(3), cube.getPoint(2)) &&
                checkYAxisAlignment(cube.getPoint(4), cube.getPoint(5)) &&
                checkYAxisAlignment(cube.getPoint(7), cube.getPoint(6));
        logger.log(Level.INFO, "points on the x-axis: " + xAlignment + ", points on the y-axis: " + yAlignment + ", points on the z-axis: " + zAlignment);
        return xAlignment && zAlignment && yAlignment;
    }

}
