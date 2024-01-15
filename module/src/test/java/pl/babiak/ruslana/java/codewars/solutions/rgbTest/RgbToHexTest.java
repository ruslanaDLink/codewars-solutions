package pl.babiak.ruslana.java.codewars.solutions.rgbTest;

import org.junit.jupiter.api.Test;
import pl.babiak.ruslana.java.codewars.solutions.rgb.RgbToHex;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RgbToHexTest {

    @Test
    public void sampleTests() {
        assertEquals( "000000", RgbToHex.rgb(0, 0, 0));
        assertEquals( "010203", RgbToHex.rgb(1, 2, 3));
        assertEquals("FFFFFF", RgbToHex.rgb(255, 255, 255));
        assertEquals("FEFDFC", RgbToHex.rgb(254, 253, 252));
        assertEquals("00FF7D", RgbToHex.rgb(-20, 275, 125));
    }
}