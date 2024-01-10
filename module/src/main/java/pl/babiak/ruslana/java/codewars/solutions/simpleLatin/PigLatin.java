package pl.babiak.ruslana.java.codewars.solutions.simpleLatin;

import java.util.ArrayList;
import java.util.List;

public class PigLatin {

    public static String pigIt(String str) {
        String pigLatin = "";
        List<String> resultList = new ArrayList<>();

        if (str.length() > 0) {
            String[] splittedString = str.split(" ");

            for (String s : splittedString) {
                s = s.matches(("[a-zA-Z]+")) ? s
                        .concat(String.valueOf(s.charAt(0)))
                        .concat("ay")
                        .substring(1) : s;
                pigLatin = s;
                resultList.add(pigLatin);
            }
        }
        pigLatin = resultList.toString();
        return pigLatin.substring(1, pigLatin.length() - 1).replace(",", "");
    }
}
