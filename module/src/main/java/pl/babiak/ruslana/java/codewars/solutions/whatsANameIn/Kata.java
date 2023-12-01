package pl.babiak.ruslana.java.codewars.solutions.whatsANameIn;

public class Kata {

    public static boolean nameInStr(String str, String name) {
        int strIndex = 0;
        int nameIndex = 0;

        while(strIndex < str.length() && nameIndex < name.length()) {
            if (str.charAt(strIndex) == name.charAt(nameIndex)) {
                nameIndex++;
            }
            strIndex++;
        }
        return nameIndex == name.length();
    }
}