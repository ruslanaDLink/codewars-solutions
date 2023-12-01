package pl.babiak.ruslana.java.codewars.solutions.whatsANameInTest;

import org.junit.jupiter.api.Test;
import pl.babiak.ruslana.java.codewars.solutions.whatsANameIn.Kata;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void sampleTest() {
        assertEquals(true, Kata.nameInStr("Across the rivers", "chris"));
        assertEquals(false, Kata.nameInStr("Next to a lake", "chris"));
        assertEquals(false, Kata.nameInStr("Under a sea", "chris"));
        assertEquals(false, Kata.nameInStr("A crew that boards the ship", "chris"));
        assertEquals(false, Kata.nameInStr("A live son", "Allison"));
    }
}