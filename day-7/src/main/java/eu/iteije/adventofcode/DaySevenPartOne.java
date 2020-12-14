package eu.iteije.adventofcode;

import eu.iteije.adventofcode.core.AOCFileReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DaySevenPartOne {

    private static final String GOLDEN_BAG = "shiny gold";
    private static Map<String, List<String>> bags;

    public static void main(String[] args) {
        bags = new HashMap<>();

        AOCFileReader fileReader = new AOCFileReader();
        List<String> input = fileReader.getInputAsStrings("input.txt");

        for (String line : input) {
            String[] data = line.substring(0, line.length() - 1).split(" bags contain ");

            List<String> contents = new ArrayList<>();

            for (String content : data[1].split(", ")) {
                String bagName = content.substring(2, content.length() - 4).trim();
                contents.add(bagName);
            }

            bags.put(data[0], contents);
        }

        int count = 0;

        for (String key : bags.keySet()) {
            if (hasShiny(key)) count++;
        }

        System.out.println(count);
    }

    public static boolean hasShiny(String bagKey) {
        if (bags.get(bagKey) == null) return false;

        for (String sub : bags.get(bagKey)) {
            if (sub.equals(GOLDEN_BAG)) return true;

            if (hasShiny(sub)) return true;
        }

        return false;
    }

}
