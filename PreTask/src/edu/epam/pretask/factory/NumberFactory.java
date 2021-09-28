package edu.epam.pretask.factory;

import edu.epam.pretask.numbers.FloatNumber;
import edu.epam.pretask.reader.LineReader;
import edu.epam.pretask.validation.Validator;

import java.io.IOException;
import java.util.ArrayList;

public class NumberFactory {
    public ArrayList<FloatNumber> fromFile(String path) throws IOException, SymbolException {
        LineReader reader = new LineReader();
        ArrayList<String> lines = reader.readLines(path);
        ArrayList<FloatNumber> numbers = new ArrayList<>();

        for (String line : lines) {
            numbers.add(createNumber(line));
        }
        return numbers;
    }

    public FloatNumber createNumber(String line) throws SymbolException {
        Validator validator = new Validator();
        if (!validator.isValid(line)) {
            throw new SymbolException("Wrong number format: " + line);
        }

        return new FloatNumber(Float.parseFloat(line));
    }
}
