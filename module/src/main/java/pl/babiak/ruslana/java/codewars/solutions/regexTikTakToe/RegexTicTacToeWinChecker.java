package pl.babiak.ruslana.java.codewars.solutions.regexTikTakToe;

public class RegexTicTacToeWinChecker {

    public static boolean regexTicTacToeWinChecker(String board) {
        if (board.length() == 9) {
            String firstPart = board.substring(0, 3);
            String secondPart = board.substring(3, 6);
            String thirdPart = board.substring(6, 9);

            String firstPartVertical = String.valueOf(board.charAt(0)) + board.charAt(3) +
                    board.charAt(6);
            String secondPartVertical = String.valueOf(board.charAt(1)) + board.charAt(4) +
                    board.charAt(7);
            String thirdPartVertical = String.valueOf(board.charAt(2)) + board.charAt(5) +
                    board.charAt(8);

            String firstPartDiagonal = String.valueOf(board.charAt(0)) + board.charAt(4) +
                    board.charAt(8);
            String secondPartDiagonal = String.valueOf(board.charAt(2)) + board.charAt(4) +
                    board.charAt(6);

            System.out.println(firstPartDiagonal);
            System.out.println(secondPartDiagonal);
            if (firstPart.equals("XXX") || (firstPart.equals("OOO"))
                    || secondPart.equals("XXX") || (secondPart.equals("OOO"))
                    || thirdPart.equals("XXX") || (thirdPart.equals("OOO"))) {
                return true;
            } else if (firstPartVertical.equals("XXX") || (firstPartVertical.equals("OOO"))
                    || secondPartVertical.equals("XXX") || (secondPartVertical.equals("OOO"))
                    || thirdPartVertical.equals("XXX") || (thirdPartVertical.equals("OOO"))) {
                return true;
            } else if (firstPartDiagonal.equals("XXX") || (firstPartDiagonal.equals("OOO"))
                    || secondPartDiagonal.equals("XXX") || (secondPartDiagonal.equals("OOO"))) {
                return true;
            }
        }
        return false;
    }
}
