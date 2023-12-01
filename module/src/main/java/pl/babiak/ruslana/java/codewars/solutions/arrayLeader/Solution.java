package pl.babiak.ruslana.java.codewars.solutions.arrayLeader;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static List<Integer> arrayLeaders(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            int sum = 0;
            for (int j = i + 1; j < numbers.length; j++) {
                sum += numbers[j];
            }
            if (numbers[i] > sum) {
                list.add(numbers[i]);
            }
        }
        return list;
    }
}
