package eu.iteije.adventofcode;

import eu.iteije.adventofcode.core.AOCFileReader;

import java.util.List;

public class DayTwoPartOne {

    public static void main(String[] args) {
        AOCFileReader fileReader = new AOCFileReader();
        List<String> input = fileReader.getInputAsStrings("input.txt");

        String result = "-";

        result = String.valueOf(input.stream().filter(DayTwoPartOne::validatePassword).count());

        System.out.println(result);
    }

    private static boolean validatePassword(String line) {
        String[] data = line.split(" ");

        if (data.length != 3) throw new IllegalArgumentException("Unable to parse data");

        String[] allowedAppearancesData = data[0].split("-");
        int minimumAppearances = Integer.parseInt(allowedAppearancesData[0]);
        int maximumAppearances = Integer.parseInt(allowedAppearancesData[1]);

        char character = data[1].charAt(0);

        String password = data[2];

        int characterCount = 0;

        for (char passwordCharacter : password.toCharArray()) {
            if (passwordCharacter == character) characterCount++;
        }

        return characterCount >= minimumAppearances && characterCount <= maximumAppearances;
    }

}
