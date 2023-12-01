package pl.babiak.ruslana.java.codewars.solutions.requiredData;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static Object[] countSel(int[] array) {
        if (array.length > 0) {
            int length = array.length;
            int distinct = (int) Arrays.stream(array).distinct().count();

            Map<Integer, Integer> map = new HashMap<>();

            for (int i : array) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }

            int amountOfOnceOccurrenceNumbers = (int) map.keySet().stream().filter(a -> map.get(a) == 1).count();
            int countOfMaxOccurrenceValues = map.values().stream().mapToInt(x -> x).max().getAsInt();
            int[] maxOccurrenceValue = Arrays.stream(array).filter(x -> map.get(x) == countOfMaxOccurrenceValues).distinct().sorted().toArray();

            return new Object[]{length, distinct, amountOfOnceOccurrenceNumbers,
                    new Object[]{maxOccurrenceValue, countOfMaxOccurrenceValues}};
        }
        return null;
    }
}
