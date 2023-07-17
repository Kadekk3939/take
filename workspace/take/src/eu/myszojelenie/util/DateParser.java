package eu.myszojelenie.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DateParser {

    public static int getYear(String date) {
        return Arrays.stream(date.split("-")).map(Integer::parseInt).collect(Collectors.toList()).get(2);
    }

    public static int getMonth(String date) {
        return Arrays.stream(date.split("-")).map(Integer::parseInt).collect(Collectors.toList()).get(1);
    }

    public static int getDay(String date) {
        return Arrays.stream(date.split("-")).map(Integer::parseInt).collect(Collectors.toList()).get(0);
    }
}
