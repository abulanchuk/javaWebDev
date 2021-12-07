package edu.epam.task5.reader;

import edu.epam.task5.exception.InvalidPathFormatException;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LineReader {
    private static Logger logger = LogManager.getLogger(LineReader.class);

    public static List<String> readLines(String pathToFile) throws InvalidPathFormatException {

        if (pathToFile == null || pathToFile.isEmpty()) {
            logger.log(Level.ERROR, "File is not found" + pathToFile);
            throw new InvalidPathFormatException("File is not found");
        }
        Path path = Paths.get(pathToFile);

        List<String> lines = new ArrayList<>();
        try (Stream<String> lineStream = Files.lines(path)) {
            lines = lineStream.collect(Collectors.toList());

        } catch (IOException ignored) {
            logger.log(Level.ERROR, ignored);
        }

        return lines;
    }
}