package eu.iteije.adventofcode;

import eu.iteije.adventofcode.core.AOCFileReader;

import java.util.List;

public class DayTwoPartTwo {

    public static void main(String[] args) {
        AOCFileReader fileReader = new AOCFileReader();
        List<String> input = fileReader.getInputAsStrings("input.txt");

        String result = "-";

        result = String.valueOf(input.stream().filter(DayTwoPartTwo::validatePassword).count());

        System.out.println(result);
    }

    private static boolean validatePassword(String line) {
        String[] data = line.split(" ");

        if (data.length != 3) throw new IllegalArgumentException("Unable to parse data");

        String[] appearanceData = data[0].split("-");
        int firstAppearance = Integer.parseInt(appearanceData[0]) - 1;
        int secondAppearance = Integer.parseInt(appearanceData[1]) - 1;

        char character = data[1].charAt(0);

        String password = data[2];


        boolean foundCharacter = false;
        if (password.charAt(firstAppearance) == character) foundCharacter = true;

        if (password.charAt(secondAppearance) == character) {
            return !foundCharacter;
        }

        return foundCharacter;
    }

}
