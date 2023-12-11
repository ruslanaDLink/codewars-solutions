package pl.babiak.ruslana.java.codewars.solutions.myFriendTime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class TimeWhereverIgo {

    public static String getFriendDateAndTime(String myTime, String myZone, String friendZone) {
        String pattern = "dd-MM-yyyy HH:mm";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);

        return LocalDateTime
                .parse(myTime, dateTimeFormatter)
                .atZone(ZoneId.of(myZone))
                .withZoneSameInstant(ZoneId.of(friendZone))
                .format(dateTimeFormatter);
    }
}