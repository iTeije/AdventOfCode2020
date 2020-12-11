package eu.iteije.adventofcode;

import eu.iteije.adventofcode.core.AOCFileReader;

import java.util.List;

public class DayOnePartOne {

    public static void main(String[] args) {
        AOCFileReader fileReader = new AOCFileReader();
        List<Integer> input = fileReader.getInputAsIntegers("input.txt");

        int finalNumber = -1;

        for (int base : input) {
            int missing = 2020 - base;
            if (input.contains(missing)) {
                finalNumber = missing * base;
                break;
            }
        }

        System.out.println(finalNumber);
    }

}
