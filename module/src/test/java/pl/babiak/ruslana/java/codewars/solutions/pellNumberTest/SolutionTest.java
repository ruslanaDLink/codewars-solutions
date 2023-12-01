package pl.babiak.ruslana.java.codewars.solutions.pellNumberTest;

import java.math.BigInteger;
import org.junit.jupiter.api.Test;
import pl.babiak.ruslana.java.codewars.solutions.pellNumber.Solution;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void testSomething() {
        assertEquals(BigInteger.ONE, Solution.pell(1));
        assertEquals(BigInteger.TWO, Solution.pell(2));
        assertEquals(BigInteger.valueOf(5), Solution.pell(3));
        assertEquals(BigInteger.valueOf(12), Solution.pell(4));
    }
}
