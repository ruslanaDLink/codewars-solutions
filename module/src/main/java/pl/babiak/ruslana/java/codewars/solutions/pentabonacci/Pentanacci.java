package pl.babiak.ruslana.java.codewars.solutions.pentabonacci;

import java.util.Arrays;

public class Pentanacci {
    private static long n;

    public static long countOddPentaFib(long n) {
        long[] array = new long[(int) n + 1];
        array[0] = 0;
        array[1] = 1;
        array[2] = 1;
        array[3] = 2;
        array[4] = 4;

        for (int i = 5; i < array.length; i++) {
            array[i] = array[i - 1] + array[i - 2] + array[i - 3] + array[i - 4] + array[i - 5];
        }
        return Arrays.stream(array).filter(x -> x % 2 != 0).count() - 1;
    }
}