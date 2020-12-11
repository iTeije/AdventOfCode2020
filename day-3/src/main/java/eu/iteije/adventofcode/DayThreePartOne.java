package eu.iteije.adventofcode;

import eu.iteije.adventofcode.core.AOCFileReader;

import java.util.List;

public class DayThreePartOne {

    public static void main(String[] args) {
        AOCFileReader fileReader = new AOCFileReader();
        List<String> input = fileReader.getInputAsStrings("input.txt");

        int next = 0;
        int trees = 0;

        for (String line : input) {
            if (line.charAt(next) == '#') trees++;

            next = (next + 3) % line.length();
        }

        System.out.println(trees);
    }

}
