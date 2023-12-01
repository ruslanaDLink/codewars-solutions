package pl.babiak.ruslana.java.codewars.solutions.middleCharacter;

public class Kata {

    public static String getMiddle(String word) {
        String middleCharacter = "";
        int size = word.length();
        if (!word.isEmpty()) {
            for (int i = 0; i < size; i++) {
                if (size % 2 == 0) {
                    int x = size / 2 - 1;
                    int y = size / 2 + 1;
                    middleCharacter = word.substring(x, y);
                } else {
                    middleCharacter = word.substring(size / 2, size / 2 + 1);
                }
            }
        }
        return middleCharacter;
    }
}