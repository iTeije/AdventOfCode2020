package eu.iteije.adventofcode;

import eu.iteije.adventofcode.core.AOCFileReader;
import eu.iteije.adventofcode.enums.PassportField;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DayFourPartTwo {

    private static final Set<String> REQUIRED_FIELDS = new HashSet<>(Arrays.asList("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"));

    public static void main(String[] args) {
        AOCFileReader fileReader = new AOCFileReader();
        List<String> input = fileReader.getInputAsStrings("input.txt");

        int validPassports = 0;

        Set<String> fields = new HashSet<>();

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
                String[] fieldData = givenField.split(":");
                boolean valid = PassportField.valueOf(fieldData[0].toUpperCase()).getValidation().test(fieldData[1]);
                if (valid) fields.add(fieldData[0].toLowerCase());
            }
        }

        // Check last field (not counted because the file ends with an empty line)
        if (fields.containsAll(REQUIRED_FIELDS)) validPassports++;

        System.out.println(validPassports);
    }

}
