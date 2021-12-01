package edu.epam.task5.parser;

import edu.epam.task5.entity.Car;

import edu.epam.task5.exception.SymbolException;
import edu.epam.task5.util.IdGenerator;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CarsParser {
    private static Logger logger = LogManager.getLogger(CarsParser.class);
    private static final String SPLIT_REGEX = ",";

    public static ArrayList<Car> parseCars(List<String> lines) throws SymbolException {
        if (lines.isEmpty()) {
            logger.log(Level.ERROR, "The file is empty. Fix this" + lines);
            throw new SymbolException("The file is empty. Fix this");
        }
        ArrayList<Car> cars = new ArrayList<>();
        for (String line : lines) {
         String []parameters =  line.split(SPLIT_REGEX);
         if(parameters.length!=2){
             throw new SymbolException("more than 2 parameters");
         }
         String carNumber = parameters[0];
         double carWeight = Double.parseDouble(parameters[1]);
         long carId = IdGenerator.generateId();
         Car car = new Car(carId,carNumber,carWeight);
         cars.add(car);
        }
        return cars;
    }
}
