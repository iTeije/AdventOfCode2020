package eu.iteije.adventofcode;

import eu.iteije.adventofcode.core.AOCFileReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DayFivePartOne {

    public static void main(String[] args) {
        int highestSeatId = -1;
        for (int seatId : getSeatIds()) {
            if (seatId > highestSeatId) highestSeatId = seatId;
        }

        System.out.println(highestSeatId);
    }

    public static List<Integer> getSeatIds() {
        AOCFileReader fileReader = new AOCFileReader();
        List<String> input = fileReader.getInputAsStrings("input.txt");

        List<Integer> seatIds = new ArrayList<>();

        for (String line : input) seatIds.add(getSeatId(0, 127, 0, 7, line));

        Collections.sort(seatIds);
        return seatIds;
    }
    
    private static int getSeatId(int rowLowerBound, int rowUpperBound, int columnLowerBound, int columnUpperBound, String input) {
        if (input.length() == 0) return (rowLowerBound * 8) + columnLowerBound;
        char character = input.charAt(0);

        if (character == 'F') {
            rowUpperBound = (int) Math.floor(calculate(rowLowerBound, rowUpperBound));
        } else if (character == 'B') {
            rowLowerBound = (int) Math.ceil(calculate(rowLowerBound, rowUpperBound)) ;
        }

        if (character == 'R') {
            columnLowerBound = (int) Math.ceil(calculate(columnLowerBound, columnUpperBound));
        } else if (character == 'L') {
            columnUpperBound = (int) Math.floor(calculate(columnLowerBound, columnUpperBound));
        }

        return getSeatId(rowLowerBound, rowUpperBound, columnLowerBound, columnUpperBound, input.substring(1));
    }

    private static double calculate(int lowerBound, int upperBound) {
        return (double) (upperBound - lowerBound) / 2 + lowerBound;
    }
}
