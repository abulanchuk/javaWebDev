package edu.epam.firsttask;

import edu.epam.firsttask.validation.Validator;

public class Main {
    public static void main(String[] args) {
        Validator v = new Validator();
        v.isValid("12 11 11 111");
    }
}
