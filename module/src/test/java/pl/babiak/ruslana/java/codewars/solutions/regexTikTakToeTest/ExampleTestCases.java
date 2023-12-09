package pl.babiak.ruslana.java.codewars.solutions.regexTikTakToeTest;

import org.junit.jupiter.api.Test;
import pl.babiak.ruslana.java.codewars.solutions.regexTikTakToe.RegexTicTacToeWinChecker;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExampleTestCases {
    @Test
    public void SomeBoardsWithWinnersTests () {
      String[] winners = new String[]{"XXX-O-O-O", "X--OOOX-X", "O--OO-XXX", "O-XOX-O-X", "OXOOXOXX-", "X-O-OOXXO", "XO--X-OOX", "X-OXOOOXX"};
      for (String winner : winners) {
            System.out.println("Testing with board " + winner);
            assertEquals(true, RegexTicTacToeWinChecker.regexTicTacToeWinChecker(winner));
      }
    }

    @Test
    public void SomeBoardsWithoutWinnersTests () {
      String[] notWinners = new String[]{"XO-------", "XX-XOO---", "-XX-OO-O-", "OXO--XXO-", "OOXXXO---", "OXXX-XOO-", "OOXXX----", "XXOOXXOO-", "OXOXOX---"};
      for (String notWinner : notWinners) {
            System.out.println("Testing with board " + notWinner);
            assertEquals(false, RegexTicTacToeWinChecker.regexTicTacToeWinChecker(notWinner));
      }
    }
}
