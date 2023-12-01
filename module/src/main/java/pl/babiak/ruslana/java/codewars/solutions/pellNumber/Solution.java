package pl.babiak.ruslana.java.codewars.solutions.pellNumber;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static BigInteger pell(int n) {
        List<BigInteger> list = new ArrayList<>();
        list.add(BigInteger.ZERO);
        list.add(BigInteger.ONE);

        for (int i = 2; i <= n; i++) {
            list.add(list.get(i - 1).multiply(BigInteger.TWO).add(list.get(i - 2)));
        }
        return list.get(n);
    }
}
