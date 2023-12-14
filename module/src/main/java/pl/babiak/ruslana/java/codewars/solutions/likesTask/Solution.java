package pl.babiak.ruslana.java.codewars.solutions.likesTask;

public class Solution {
    public static String whoLikesIt(String... names) {
        int length = names.length;
        int len = length - 2;
        if (length > 0) {
            switch (length) {
                case 1:
                    return names[0] + " likes this";
                case 2:
                    return names[0] + " and " + names[1] + " like this";
                case 3:
                    return names[0] + ", " + names[1] + " and " + names[2] + " like this";
                default:
                    return names[0] + ", " + names[1] + " and " + len + " others like this";
            }
        } else {
            return "no one likes this";
        }
    }
}