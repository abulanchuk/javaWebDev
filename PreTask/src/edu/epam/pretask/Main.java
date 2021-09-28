package edu.epam.pretask;

import edu.epam.pretask.factory.NumberFactory;
import edu.epam.pretask.factory.SymbolException;
import edu.epam.pretask.numbers.FloatNumber;
import edu.epam.pretask.operator.Operator;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SymbolException, IOException {

        NumberFactory numberFactory = new NumberFactory();
        ArrayList<FloatNumber> numbers = numberFactory.fromFile("resources/file.txt");


        Operator operator = new Operator();
        System.out.println(operator.sum(numbers.get(0), numbers.get(1)).getNumber());
        System.out.println(operator.subtract(numbers.get(0), numbers.get(1)).getNumber());
        System.out.println(operator.divide(numbers.get(0), numbers.get(1)).getNumber());
        System.out.println(operator.multiply(numbers.get(0), numbers.get(1)).getNumber());
    }
}
