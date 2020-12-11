package eu.iteije.adventofcode;

import eu.iteije.adventofcode.core.AOCFileReader;

import java.util.List;

public class DayThreePartTwo {

    public static void main(String[] args) {
        AOCFileReader fileReader = new AOCFileReader();
        List<String> input = fileReader.getInputAsStrings("input.txt");

        String result = String.valueOf(
                getEncounters(1, 1, input) *
                getEncounters(3, 1, input) *
                getEncounters(5, 1, input) *
                getEncounters(7, 1, input) *
                getEncounters(1, 2, input)
        );

        System.out.println(result);
    }

    private static long getEncounters(int right, int down, List<String> input) {
        int trees = 0;
        int next = 0;

        for (int i = 0; i < input.size(); i += down) {
            String line = input.get(i);

            if (line.charAt(next) == '#') trees++;

            next = (next + right) % line.length();
        }

        return trees;
    }

}
