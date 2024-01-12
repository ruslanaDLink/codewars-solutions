package pl.babiak.ruslana.java.codewars.solutions.timeFormatter;

import java.util.ArrayList;
import java.util.List;

public class TimeFormatter {
    private static final int MINUTE = 60;
    private static final int HOUR = 3600;
    private static final int DAY = 86400;
    private static final int YEAR = 31_556_926;

    public static String formatDuration(int seconds) {
        if (seconds < 0) {
            throw new IllegalArgumentException("Argument must be non negative number");
        }
        if (seconds == 0) {
            return "now";
        }
        int years = seconds / YEAR;
        int leapYears = years / 4;
        int days = ((seconds % YEAR) + (leapYears * DAY)) / DAY;
        int hours = (seconds % DAY) / HOUR;
        int minutes = (seconds % HOUR) / MINUTE;
        int remainingSeconds = seconds % MINUTE;

        String dateYear = years > 1 ? years + " years" : years + " year";
        String dateDay = days > 1 ? days + " days" : days + " day";
        String dateHour = hours > 1 ? hours + " hours" : hours + " hour";
        String dateMinute = minutes > 1 ? minutes + " minutes" : minutes + " minute";
        String dateSeconds = remainingSeconds > 1 ? remainingSeconds + " seconds" : remainingSeconds + " second";

        List<String> list = new ArrayList<>();

        if (years != 0) list.add(dateYear);
        if (days != 0) list.add(dateDay);
        if (hours != 0) list.add(dateHour);
        if (minutes != 0) list.add(dateMinute);
        if (remainingSeconds != 0) list.add(dateSeconds);

        String collect = String.join(", ", list);
        int lastComma = collect.lastIndexOf(",");
        if (lastComma >= 0) {
            collect = collect.substring(0, lastComma) + " and" + collect.substring(lastComma + 1);
        }
        return collect;
    }
}
