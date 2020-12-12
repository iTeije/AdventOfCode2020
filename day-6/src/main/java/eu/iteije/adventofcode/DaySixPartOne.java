package eu.iteije.adventofcode;

import eu.iteije.adventofcode.core.AOCFileReader;

import java.util.*;

public class DaySixPartOne {

    public static void main(String[] args) {
        AOCFileReader fileReader = new AOCFileReader();
        List<String> input = fileReader.getInputAsStrings("input.txt");
        input.add("");

        int unique = 0;
        Set<String> characters = new HashSet<>();

        for (String line : input) {
            if (line.isEmpty()) {
                unique += characters.size();
                characters.clear();

                continue;
            }

            characters.addAll(Arrays.asList(line.split("")));
        }

        System.out.println(unique);
    }
}
