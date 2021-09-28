package edu.epam.pretask.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LineReader {
    public ArrayList<String> readLines(String pathToFile) throws IOException {
        ArrayList<String> lines = new ArrayList<>();

        Path path = Paths.get(pathToFile);
        try (BufferedReader reader = Files.newBufferedReader(path)) {

            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

        }
        return lines;
    }
}
