package ca.fcc.game.dice.model;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DiceGame {
  // Number of dice to be used in the game
  private final int numDice;
  // Random number generator for rolling dice
  private final Random random;

  // Constructor to initialize the number of dice and the random number generator
  public DiceGame(int numDice) {
    this.numDice = numDice;
    this.random = new Random();
  }

  protected Random getRandom() {
    return random;
  }

  // Method to play the game and calculate the total score
  public int playGame() {
    // Roll the initial set of dice
    List<Integer> dice = rollDice(numDice);
    int totalScore = 0;

    // Continue playing until all dice are removed
    while (!dice.isEmpty()) {
      // Remove all dice with a value of 3
      if (dice.contains(3)) {
        dice.removeIf(die -> die == 3);
      } else {
        // Find the minimum die value, add it to the total score, and remove it from the list
        int minDie = Collections.min(dice);
        totalScore += minDie;
        dice.remove(Integer.valueOf(minDie));
      }
      // Roll the remaining dice
      dice = rollDice(dice.size());
    }

    return totalScore;
  }

  // Method to roll a specified number of dice and return the results as a list
  private List<Integer> rollDice(int numDice) {
    return IntStream.range(0, numDice)
        .mapToObj(i -> getRandom().nextInt(6) + 1)
        .collect(Collectors.toList());
  }

  // Getter method to retrieve the number of dice
  public int getNumDice() {
    return numDice;
  }
}
