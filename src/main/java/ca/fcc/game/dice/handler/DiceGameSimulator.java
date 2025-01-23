package ca.fcc.game.dice.handler;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ca.fcc.game.dice.model.DiceGame;

public class DiceGameSimulator {
  // Logger instance for logging information
  private static final Logger logger = LoggerFactory.getLogger(DiceGameSimulator.class);
  // Instance of DiceGame to simulate the game
  private final DiceGame diceGame;
  // Number of simulations to run
  private final int numSimulations;

  // Constructor to initialize the number of simulations and the number of dice
  public DiceGameSimulator(int numSimulations, int numDice) {
    this.diceGame = new DiceGame(numDice);
    this.numSimulations = numSimulations;
  }

  // Method to run the specified number of simulations
  public void runSimulations() {
    // Map to store the count of each score
    Map<Integer, Integer> scoreCounts = new HashMap<>();
    long startTime = System.nanoTime();

    // Run the simulations and record the scores using a lambda expression
    IntStream.range(0, numSimulations)
        .forEach(i -> {
          int score = diceGame.playGame();
          scoreCounts.put(score, scoreCounts.getOrDefault(score, 0) + 1);
        });

    long endTime = System.nanoTime();
    double duration = (endTime - startTime) / 1_000_000_000.0;

    // Print the results of the simulations
    printResults(scoreCounts, duration);
  }

  // Method to print the results of the simulations

  private void printResults(Map<Integer, Integer> scoreCounts, double duration) {
    logger.info("Number of simulations was {} using {} dice.", numSimulations, diceGame.getNumDice());
    scoreCounts.forEach((score, count) -> {
      double percentage = (double) count / numSimulations;
      logger.info("Total {} occurs {} occurred {} times.", score, String.format("%.4f", percentage), count);
    });
    logger.info("Total simulation took {} seconds.", duration);
  }


}
