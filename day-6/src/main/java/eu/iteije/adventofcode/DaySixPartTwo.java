package eu.iteije.adventofcode;

import eu.iteije.adventofcode.core.AOCFileReader;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DaySixPartTwo {

    public static void main(String[] args) {
        AOCFileReader fileReader = new AOCFileReader();
        List<String> input = fileReader.getInputAsStrings("input.txt");
        input.add("");

        int total = 0;
        boolean skipCheck = true;
        Set<String> characters = new HashSet<>();

        for (final String line : input) {
            if (line.isEmpty()) {
                total += characters.size();
                characters.clear();
                skipCheck = true;

                continue;
            }

            if (skipCheck) {
                characters.addAll(Arrays.asList(line.split("")));
                skipCheck = false;
            }

            characters.removeIf(c -> !line.contains(c));
        }

        System.out.println(total);
    }

}
