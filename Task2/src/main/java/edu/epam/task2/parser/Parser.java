package edu.epam.task2.parser;

import edu.epam.task2.entity.CustomCube;
import edu.epam.task2.entity.CustomPoint;
import edu.epam.task2.exception.InvalidNumberOfPointsError;
import edu.epam.task2.exception.SymbolException;
import edu.epam.task2.factory.CubeFromOnePointAndLength;
import edu.epam.task2.validator.inputformat.impl.ValidatorImpl;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Arrays;


public class Parser {
    static Logger logger = LogManager.getLogger(Parser.class);
    private static final String SPLIT_REGEX = "\\s+";
    CubeFromOnePointAndLength cubeFromOnePointAndLength = new CubeFromOnePointAndLength();

    public CustomCube fromString(String line, int shapeIdToAssign) throws SymbolException, InvalidNumberOfPointsError {
        ValidatorImpl validator = new ValidatorImpl();
        if (!validator.isValid(line)) {
            logger.log(Level.ERROR, "Wrong format" + line);
            throw new SymbolException("Wrong format");
        }

        double[] coordinates = Arrays.stream(line.split(SPLIT_REGEX))
                .mapToDouble(Float::parseFloat)
                .toArray();

        CustomPoint origin = new CustomPoint(coordinates[0], coordinates[1], coordinates[2]);
        double sideLength = coordinates[3];
        return cubeFromOnePointAndLength.createCubeFromOnePoint(origin,sideLength,shapeIdToAssign);
    }
}
