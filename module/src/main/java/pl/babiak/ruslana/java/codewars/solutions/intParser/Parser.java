package pl.babiak.ruslana.java.codewars.solutions.intParser;

import java.util.HashMap;
import java.util.Map;

public class Parser {

    private static Map<String, Integer> convertToNumber() {
        Map<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        map.put("ten", 10);
        map.put("eleven", 11);
        map.put("twelve", 12);
        map.put("thirteen", 13);
        map.put("fourteen", 14);
        map.put("fifteen", 15);
        map.put("sixteen", 16);
        map.put("seventeen", 17);
        map.put("eighteen", 18);
        map.put("nineteen", 19);
        map.put("twenty", 20);
        map.put("thirty", 30);
        map.put("forty", 40);
        map.put("fifty", 50);
        map.put("sixty", 60);
        map.put("seventy", 70);
        map.put("eighty", 80);
        map.put("ninety", 90);
        return map;
    }

    public static int parseInt(String numStr) {
        Map<String, Integer> map = convertToNumber();
        String[] values = numStr.split("\\s+");
        int result = 0;
        int currentNumber = 0;

        for (String value : values) {
            if (value.equals("and")) continue;
            switch (value) {
                case "thousand":
                    result += currentNumber * 1000;
                    currentNumber = 0;
                    break;
                case "million":
                    result += 1000000;
                    currentNumber = 0;
                    break;
                case "hundred":
                    currentNumber *= 100;
                    break;
                default:
                    if (value.contains("-")) {
                        value = value.replace("-", " ");
                        String[] s = value.split(" ");
                        for (String s1 : s) {
                            currentNumber += map.getOrDefault(s1, 0);
                        }
                    } else {
                        currentNumber += map.getOrDefault(value, 0);
                    }
                    break;
            }
        }
        result += currentNumber;
        return result;
    }
}