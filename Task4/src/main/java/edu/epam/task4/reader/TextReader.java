package edu.epam.task4.reader;

import edu.epam.task4.exception.InvalidPathFormatException;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class TextReader {
    private static Logger logger = LogManager.getLogger(TextReader.class);

    public static String readText(String pathToFile) throws InvalidPathFormatException, IOException {

        if (pathToFile == null || pathToFile.isEmpty()) {
            logger.log(Level.ERROR, "File is not found" + pathToFile);
            throw new InvalidPathFormatException("File is not found");
        }
        Path path = Paths.get(pathToFile);
        String line = Files.readString(path, StandardCharsets.UTF_8);

        return line;
    }
}
