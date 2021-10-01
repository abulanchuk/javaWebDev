package edu.epam.firstTask.factory;

import edu.epam.firstTask.array.Number;
import edu.epam.firstTask.reader.LineReader;
import edu.epam.firstTask.validation.Validator;

import java.io.IOException;
import java.util.ArrayList;

public class ArrayFactory {
    Validator validator = new Validator();

    public ArrayList<Number> createFromLine(String fileLine) throws SymbolException {
        ArrayList<Number> numbers = new ArrayList<>();

        // TODO: ПЕРЕПИСАТЬ С ИСПОЛЬЗОВАНИЕМ StreamAPI
        for (String line : fileLine.split(" ")) {
            numbers.add(createNumber(line));
        }
        return numbers;
    }

    public Number createNumber(String line) throws SymbolException {
        if (!validator.isValid(line)) {
            throw new SymbolException("Wrong number format: " + line);
        }
        return new Number(Integer.parseInt(line));
    }

    public ArrayList<ArrayList<Number>> createArrayFromFile(String path) throws IOException {
        LineReader reader = new LineReader();
        ArrayList<String> lines = reader.readLines(path);

        ArrayList<ArrayList<Number>> arraysFromFile = new ArrayList<>();
        for (String line : lines) {
            try {
                ArrayList<Number> array = createFromLine(line);
                arraysFromFile.add(array);
            } catch (SymbolException ignored) {
            }
        }
        return arraysFromFile;
    }
}

