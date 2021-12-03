package edu.epam.task5.Main;

import edu.epam.task5.entity.Car;
import edu.epam.task5.entity.Ferry;
import edu.epam.task5.exception.InvalidPathFormatException;
import edu.epam.task5.exception.SymbolException;
import edu.epam.task5.parser.CarsParser;
import edu.epam.task5.reader.LineReader;
import edu.epam.task5.service.CarOperator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;


public class Main {
    private static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws InvalidPathFormatException, SymbolException {
        String fileName = "src/main/resources/data/cars.txt";
        List<String> lines = LineReader.readLines(fileName);
        ArrayList<Car> cars = CarsParser.parseCars(lines);

        ExecutorService pool = Executors.newFixedThreadPool(cars.size());

        List<Future<?>> futuresList = new ArrayList<>();

        for (var car: cars) {
            CarOperator operator = new CarOperator(car);
            futuresList.add(pool.submit(operator));
        }
        pool.shutdown();

        try {
            for (var future : futuresList) {
                future.get();
            }

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //Ferry ferry = new Ferry(5,4000);
        //System.out.println(cars);
    }
}
