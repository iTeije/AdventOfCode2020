package eu.iteije.adventofcode;

import eu.iteije.adventofcode.core.AOCFileReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DaySevenPartTwo {

    private static Map<String, Map<String, Integer>> bags;

    public static void main(String[] args) {
        bags = new HashMap<>();

        AOCFileReader fileReader = new AOCFileReader();
        List<String> input = fileReader.getInputAsStrings("input.txt");

        for (String line : input) {
            String[] data = line.substring(0, line.length() - 1).split(" bags contain ");

            Map<String, Integer> contents = new HashMap<>();

            for (String content : data[1].split(", ")) {
                int amount = -1;
                try {
                    amount = Integer.parseInt(String.valueOf(content.charAt(0)));
                } catch (NumberFormatException ignored) {}

                if (amount != -1) {
                    String name = content.substring(2, content.length() - 4).trim();
                    contents.put(name, amount);
                }
            }

            bags.put(data[0], contents);
        }

        System.out.println(count(DaySevenPartOne.GOLDEN_BAG));
    }

    private static int count(String key) {
        if (bags.get(key) == null) return 0;
        int count = 0;

        Map<String, Integer> content = bags.get(key);

        for (Map.Entry<String, Integer> sub : content.entrySet()) {
            count += sub.getValue() + (sub.getValue() * count(sub.getKey()));
        }

        return count;
    }

}
