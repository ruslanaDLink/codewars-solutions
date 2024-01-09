package pl.babiak.ruslana.java.codewars.solutions.squareError;

public class Solution {

    public static double solution(int[] arr1, int[] arr2) {
        double difference;
        int result = 0;
        double size = 0;

        if (arr1.length == arr2.length) {
            size = arr1.length;
            for (int i = 0; i < arr1.length; i++) {
                difference = Math.abs(arr2[i] - arr1[i]);
                result += difference * difference;
            }
        }
        return result / size;
    }
}