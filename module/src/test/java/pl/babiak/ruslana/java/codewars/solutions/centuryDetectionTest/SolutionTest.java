package pl.babiak.ruslana.java.codewars.solutions.centuryDetectionTest;

import org.junit.jupiter.api.Test;
import pl.babiak.ruslana.java.codewars.solutions.centuryDetection.Solution;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void testSomething() {
      assertEquals("20th", Solution.whatCentury(1999));
      assertEquals("21st", Solution.whatCentury(2011));
      assertEquals("22nd", Solution.whatCentury(2154));
      assertEquals("23rd", Solution.whatCentury(2259));
    }
}