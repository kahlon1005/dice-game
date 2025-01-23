
// ExampleTest.java
package ca.fcc.game.dice.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.Test;

public class ExampleTest {

  @Test
  public void testPlayGame() {
    // Define the sequence of dice rolls
    final List<Integer> rolls = Arrays.asList(3, 1, 3, 6, 6, 2, 5, 5, 6, 6, 3);

    // Create a DiceGame instance with a custom Random implementation
    final DiceGame diceGame = new DiceGame(5) {
      private int index = 0;

      @Override
      protected Random getRandom() {
        return new Random() {
          private static final long serialVersionUID = 1L;

          @Override
          public int nextInt(int bound) {
            // Return the next value from the predefined rolls list
            return rolls.get(index++) - 1;
          }
        };
      }
    };

    // Play the game and assert the final score
    final int finalScore = diceGame.playGame();
    assertEquals(8, finalScore, "The final score should be 8.");
  }
}
