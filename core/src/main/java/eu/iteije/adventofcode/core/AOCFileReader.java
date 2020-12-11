package eu.iteije.adventofcode.core;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class AOCFileReader {

    public AOCFileReader() {

    }

    public List<Integer> getInputAsIntegers(String resourceName) {
        InputStream input = ClassLoader.getSystemClassLoader().getResourceAsStream(resourceName);
        if (input == null) {
            throw new IllegalArgumentException("Couldn't find resource " + resourceName);
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        return reader.lines().map(Integer::parseInt).collect(Collectors.toList());
    }

    public List<String> getInputAsStrings(String resourceName) {
        InputStream input = ClassLoader.getSystemClassLoader().getResourceAsStream(resourceName);
        if (input == null) {
            throw new IllegalArgumentException("Couldn't find resource " + resourceName);
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        return reader.lines().collect(Collectors.toList());
    }

}
