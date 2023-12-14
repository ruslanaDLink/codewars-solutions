package pl.babiak.ruslana.java.codewars.solutions.centuryDetection;

public class Solution {

    public static String whatCentury(int year) {
        String th = "th";
        String st = "st";
        String nd = "nd";
        String rd = "rd";

        String yearString = String.valueOf(year);

        if (yearString.length() == 4) {
            int century = year / 100 + 1;
            int lastCenturyDigit = century % 10;
            int lastDigit = year % 10;
            int lastTwoDigits = year % 100;

            if (lastDigit == 0 && lastTwoDigits == 0) {
                return century - 1 + th;
            }
            if(century == 11 || century == 12 || century == 13){
                return century + th;
            }
            if (lastCenturyDigit == 1) {
                return century + st;
            } else if (lastCenturyDigit == 2) {
                return century + nd;
            } else if (lastCenturyDigit == 3) {
                return century + rd;
            } else {
                return century + th;
            }
        }
        return "";
    }
}