package pl.babiak.ruslana.java.codewars.solutions.requiredDataTest;

import org.junit.jupiter.api.Test;
import pl.babiak.ruslana.java.codewars.solutions.requiredData.Solution;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {
    private void doTest(int[] input, Object[] expected) {
        String message = "for array: " + Arrays.toString(input) + "\n";
        Object[] actual = Solution.countSel(input);
        assertArrayEquals(expected, actual, message);
    }

    @Test
    public void basicTests() {
        doTest(
            new int[]{-3, -2, -1, 3, 4, -5, -5, 5, -1, -5},
            new Object[] { 10, 7, 5, new Object[]{new int[]{-5}, 3} }
        );
        doTest(
            new int[]{5, -1, 1, -1, -2, 5, 0, -2, -5, 3},
            new Object[]{10, 7, 4, new Object[]{new int[]{-2, -1, 5}, 2}}
        );
        doTest(
            new int[]{-2, 4, 4, -2, -2, -1, 3, 5, -5, 5},
            new Object[]{10, 6, 3, new Object[]{new int[]{-2}, 3}}
        );
        doTest(
            new int[]{4, -5, 1, -5, 2, 4, -1, 4, -1, 1},
            new Object[]{10, 5, 1, new Object[]{new int[]{4}, 3}}
        );
        doTest(
            new int[]{4, 4, 2, -3, 1, 4, 3, 2, 0, -5, 2, -2, -2, -5},
            new Object[]{14, 8, 4, new Object[]{new int[]{2, 4}, 3}}
        );
    }
}