package eu.iteije.adventofcode;

import eu.iteije.adventofcode.core.AOCFileReader;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DayFourPartOne {

    private static final Set<String> REQUIRED_FIELDS = new HashSet<String>(Arrays.asList("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"));

    public static void main(String[] args) {
        AOCFileReader fileReader = new AOCFileReader();
        List<String> input = fileReader.getInputAsStrings("input.txt");

        int validPassports = 0;

        Set<String> fields = new HashSet<String>();

        // Loop through all lines
        for (String line : input) {
            // If the string is empty, check whether all required fields are present
            if (line.isEmpty()) {
                if (fields.containsAll(REQUIRED_FIELDS)) validPassports++;

                fields.clear();
                continue;
            }

            // Cache all fields from this line
            for (String givenField : line.split(" ")) {
                fields.add(givenField.split(":")[0]);
            }
        }

        // Check last field (not counted because the file ends with an empty line)
        if (fields.containsAll(REQUIRED_FIELDS)) validPassports++;

        System.out.println(validPassports);
    }

}
