package eu.iteije.adventofcode;

import eu.iteije.adventofcode.core.AOCFileReader;

import java.util.List;

public class DayOnePartTwo {

    public static void main(String[] args) {
        AOCFileReader fileReader = new AOCFileReader();
        List<Integer> input = fileReader.getInputAsIntegers("input.txt");

        int finalNumber = -1;

        for (int base : input) {
            int requiredSum = 2020 - base;
            for (int secondInput : input) {
                int missing = requiredSum - secondInput;

                if (input.contains(missing)) {
                    finalNumber = base * secondInput * missing;
                    break;
                }
            }

        }

        System.out.println(finalNumber);
    }

}
