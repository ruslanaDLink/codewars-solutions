package pl.babiak.ruslana.java.codewars.solutions.simpleLatinTest;

import org.junit.jupiter.api.Test;
import pl.babiak.ruslana.java.codewars.solutions.simpleLatin.PigLatin;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PigLatinTests {
    @Test
    public void FixedTests() {
        assertEquals("igPay atinlay siay oolcay", PigLatin.pigIt("Pig latin is cool"));
        assertEquals("hisTay siay ymay tringsay", PigLatin.pigIt("This is my string"));
    }
}