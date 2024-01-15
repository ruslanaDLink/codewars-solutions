package pl.babiak.ruslana.java.codewars.solutions.rgb;

import java.util.function.Predicate;

public class RgbToHex {

    public static String rgb(int r, int g, int b) {
        String color;

        String rHex = "";
        String gHex = "";
        String bHex = "";

        int rVal = checkValidity(r);
        int gVal = checkValidity(g);
        int bVal = checkValidity(b);

        if (rVal < 9) rHex = "0";
        rHex = rHex.concat(Integer.toHexString(rVal));
        if (gVal < 9) gHex = "0";
        gHex = gHex.concat(Integer.toHexString(gVal));
        if (bVal < 9) bHex = "0";
        bHex = bHex.concat(Integer.toHexString(bVal));

        color = rHex + gHex + bHex;
        return color.length() == 6 ? color.toUpperCase() : null;
    }

    private static int checkValidity(int number) {
        Predicate<Integer> isNegative = x -> x < 0;
        Predicate<Integer> isOutOfBounds = x -> x > 255;

        if (isNegative.test(number)) {
            number = 0;
        }
        return isNegative.test(number) ? 0 : isOutOfBounds.test(number) ? 255 : number;
    }
}