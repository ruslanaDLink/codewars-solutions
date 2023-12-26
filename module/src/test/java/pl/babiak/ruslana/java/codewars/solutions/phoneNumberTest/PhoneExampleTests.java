package pl.babiak.ruslana.java.codewars.solutions.phoneNumberTest;

import org.junit.jupiter.api.Test;
import pl.babiak.ruslana.java.codewars.solutions.phoneNumber.Kata;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneExampleTests {
  @Test
  public void tests() {
    assertEquals("(123) 456-7890", Kata.createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
  }
}