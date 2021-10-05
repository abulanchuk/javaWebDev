package edu.epam.firsttask.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LineReader {
    public static ArrayList<String> readLines(String pathToFile) throws IOException {
        ArrayList<String> linesOfFile = new ArrayList<>();

        Path path = Paths.get(pathToFile);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                linesOfFile.add(line);
            }
        }
        return linesOfFile;
    }
}

/// String s = "123 444 311 111";
/// Parser p = new Parser();
/// int[] arr = p.parse(s);
/// CustomArray array = new CustomArray(arr);

/// Factory f = new Factory();
/// CustomArray a = f.fromIntegers(1, 2, 3, 4);
