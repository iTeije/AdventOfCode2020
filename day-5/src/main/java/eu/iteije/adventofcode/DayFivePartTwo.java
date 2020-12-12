package eu.iteije.adventofcode;

import java.util.List;

public class DayFivePartTwo {

    public static void main(String[] args) {
        List<Integer> seatIds = DayFivePartOne.getSeatIds();

        for (int i = 1; i < seatIds.size() - 1; i++) {
            int selected = seatIds.get(i);
            if (seatIds.get(i + 1) != selected + 1 && seatIds.get(i + 1) == selected + 2) {
                System.out.println(selected + 1);
                break;
            }
        }

    }
}
