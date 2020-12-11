package eu.iteije.adventofcode.enums;

import java.util.Arrays;
import java.util.function.Predicate;

public enum PassportField {

    BYR (data -> {
        int year = Integer.parseInt(data);
        return year >= 1920 && year <= 2002;
    }),

    IYR (data -> {
        int year = Integer.parseInt(data);
        return year >= 2010 && year <= 2020;
    }),

    EYR (data -> {
        int year = Integer.parseInt(data);
        return year >= 2020 && year <= 2030;
    }),

    HGT (data -> {
        if (data.endsWith("cm")) {
            int number = Integer.parseInt(data.substring(0, data.length() - 2));
            return number >= 150 && number <= 193;
        } else if (data.endsWith("in")) {
            int number = Integer.parseInt(data.substring(0, data.length() - 2));
            return number >= 59 && number <= 76;
        }
        return false;
    }),

    HCL (data -> {
        return data.matches("#[0-9a-f]{6}");
    }),

    ECL (data -> {
        return Arrays.asList("amb", "blu", "brn", "gry", "hzl", "oth", "grn").contains(data);
    }),

    PID (data -> {
        return data.matches("[0-9]{9}");
    }),

    CID (data -> true)
    ;

    private final Predicate<String> validation;

    PassportField(Predicate<String> validation) {
        this.validation = validation;
    }

    public Predicate<String> getValidation() {
        return validation;
    }
}
