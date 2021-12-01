package edu.epam.task5.Main;

import edu.epam.task5.exception.InvalidPathFormatException;
import edu.epam.task5.exception.SymbolException;
import edu.epam.task5.parser.CarsParser;
import edu.epam.task5.reader.LineReader;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class Main {
    private static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws InvalidPathFormatException, SymbolException {
        String fileName = "src/main/resources/data/cars.txt";
        List<String> lines = LineReader.readLines(fileName);
        ArrayList cars = CarsParser.parseCars(lines);
        System.out.println(cars);
    }
}
