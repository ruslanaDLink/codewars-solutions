package pl.babiak.ruslana.java.codewars.solutions.phoneNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Kata {
    public static String createPhoneNumber(int[] numbers) {
        String phoneNumber = "";
        List<Integer> intList = new ArrayList<>();
        List<String> strList = new ArrayList<>();
        StringBuilder builder = new StringBuilder();

        if (numbers.length == 10) {
            for (int number : numbers) {
                intList.add(number);
            }
            for (Integer i : intList) {
                strList.add(String.valueOf(i));
            }
            builder.append(strList
                    .stream()
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList()));
            phoneNumber = builder.substring(0, builder.length());
            if (phoneNumber.contains(",")
                    && phoneNumber.contains("[")
                    && phoneNumber.contains("]")
                    && phoneNumber.contains(" ")) {
                phoneNumber = phoneNumber
                        .replace(",", "")
                        .replace("[", "")
                        .replace("]", "")
                        .replace(" ", "");
            }
            String originalPhoneNumber = phoneNumber;
            phoneNumber = "(" + originalPhoneNumber.substring(0, 3) + ") "
                    + originalPhoneNumber.substring(3, 6) + "-" + originalPhoneNumber.substring(6, 10);
        }
        return phoneNumber;
    }
}