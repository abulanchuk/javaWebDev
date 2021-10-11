package edu.epam.firsttask.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import edu.epam.firsttask.exception.InvalidPathFormatException;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class LineReader {
    static Logger logger = LogManager.getLogger(LineReader.class);

    public static ArrayList<String> readLines(String pathToFile) throws IOException, InvalidPathFormatException {
        ArrayList<String> linesOfFile = new ArrayList<>();

        if (pathToFile == null || pathToFile.isEmpty()) {
            logger.log(Level.ERROR, "File is not found");
            throw new InvalidPathFormatException("File is not found");
        }

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

