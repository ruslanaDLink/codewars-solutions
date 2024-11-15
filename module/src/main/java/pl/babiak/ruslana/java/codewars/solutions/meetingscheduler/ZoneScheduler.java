package pl.babiak.ruslana.java.codewars.solutions.meetingscheduler;
//    Multi-Zone Meeting Scheduler with Time Optimization
//    Create an application that schedules a meeting across three different time zones (e.g., America/New_York, Europe/London, Asia/Tokyo).
//    The user inputs a preferred meeting time in one time zone.
//    Calculate and suggest an optimal time for all participants, minimizing late-night or early-morning hours for any zone.
//    Display the final meeting time in all three time zones.

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ZoneScheduler {

    public static void scheduleMeeting(int hour, int day, int month, int year, ZoneId zone) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd:MM:yyyy");

        if (hour > 0 && day > 0 && month > 0) {
            ZonedDateTime signedDateMeeting = ZonedDateTime.of(year, month, day, hour, 0, 0, 0, zone);

            if (signedDateMeeting.getZone().toString().equals("America/New_York") ||
                    signedDateMeeting.getZone().toString().equals("Europe/London") ||
                    signedDateMeeting.getZone().toString().equals("Asia/Tokyo")) {
                ZonedDateTime londonTime = signedDateMeeting.withZoneSameInstant(ZoneId.of("Europe/London"));
                ZonedDateTime newYorkTime = signedDateMeeting.withZoneSameInstant(ZoneId.of("America/New_York"));
                ZonedDateTime tokyoTime = signedDateMeeting.withZoneSameInstant(ZoneId.of("Asia/Tokyo"));

                int londonHour = londonTime.getHour();
                int newYorkHour = newYorkTime.getHour();
                int tokyoHour = tokyoTime.getHour();

                if (isWorkingHour(londonHour) && isWorkingHour(newYorkHour) && isWorkingHour(tokyoHour)) {
                    System.out.println("Meeting scheduled!");
                    System.out.println(signedDateMeeting.format(formatter));
                } else {
                    boolean active = true;
                    int countHours = 0;

                    if (!isWorkingHour(londonHour)) {
                        warningMessage("London", londonHour);
                    }
                    if (!isWorkingHour(tokyoHour)) {
                        warningMessage("Tokyo", tokyoHour);
                    }
                    if (!isWorkingHour(newYorkHour)) {
                        warningMessage("New York", newYorkHour);
                    }
                    while (active) {
                        countHours++;
                        ZonedDateTime london = londonTime.plusHours(countHours);
                        ZonedDateTime tokyo = tokyoTime.plusHours(countHours);
                        ZonedDateTime newYork = newYorkTime.plusHours(countHours);
                        int londonChangedHour = london.getHour();
                        int tokyoChangedHour = tokyo.getHour();
                        int newYorkChangedHour = newYork.getHour();
                        if (isWorkingHour(londonChangedHour) && isWorkingHour(tokyoChangedHour) && isWorkingHour(newYorkChangedHour)) {
                            active = false;
                            System.out.println("Found the most suitable nearest meeting time");
                            System.out.println("_________________________________________________");
                            System.out.println("London => " + london.format(formatter));
                            System.out.println("Tokyo => " + tokyo.format(formatter));
                            System.out.println("New_York => " + newYork.format(formatter));
                            System.out.println("_________________________________________________");
                        }
                    }
                }
            }
        }
    }
    private static boolean isWorkingHour(int hour) {
        return hour >= 7 && hour <= 20;
    }

    private static void warningMessage(String region, int hour) {
        System.out.println("Current hour " + hour + " in " + region + " is not considered as working.");
        System.out.println("Rescheduling meeting time...");
    }
}
