package edu.epam.pretask.operator;

import edu.epam.pretask.numbers.FloatNumber;

public class Operator {

    public FloatNumber sum(FloatNumber first, FloatNumber second) {
        return new FloatNumber(first.getNumber() + second.getNumber());
    }

    public FloatNumber subtract(FloatNumber first, FloatNumber second) {
        return new FloatNumber(first.getNumber() - second.getNumber());
    }

    public FloatNumber multiply(FloatNumber first, FloatNumber second) {
        return new FloatNumber(first.getNumber() * second.getNumber());
    }

    public FloatNumber divide(FloatNumber first, FloatNumber second) {
        return new FloatNumber(first.getNumber() / second.getNumber());
    }
}
