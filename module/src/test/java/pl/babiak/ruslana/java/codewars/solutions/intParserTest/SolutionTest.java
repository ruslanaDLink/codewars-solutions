package pl.babiak.ruslana.java.codewars.solutions.intParserTest;

import org.junit.jupiter.api.Test;
import pl.babiak.ruslana.java.codewars.solutions.intParser.Parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    @Test
    public void fixedTests() {
        assertEquals(1 , Parser.parseInt("one"));
        assertEquals(20 , Parser.parseInt("twenty"));
        assertEquals(246 , Parser.parseInt("two hundred forty-six"));
    }
}