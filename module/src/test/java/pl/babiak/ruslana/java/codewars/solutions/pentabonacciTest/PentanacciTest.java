package pl.babiak.ruslana.java.codewars.solutions.pentabonacciTest;

import org.junit.jupiter.api.Test;
import pl.babiak.ruslana.java.codewars.solutions.pentabonacci.Pentanacci;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PentanacciTest {

    private static void testing(long actual, long expected) {
        assertEquals(expected, actual);
    }
    @Test
    public void test1() {
        System.out.println("Fixed Tests: countOddPentaFib, low values");    
        long[] lstI = new long[] {45, 68, 76, 100, 121};
        long[] resultsI = new long[] {15, 23, 25, 33, 40};
        for (int i = 0; i <= 4; i++) {
            testing(Pentanacci.countOddPentaFib(lstI[i]), resultsI[i]);
        }
    }
}
