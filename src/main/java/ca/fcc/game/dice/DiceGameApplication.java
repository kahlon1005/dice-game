
package ca.fcc.game.dice;

import ca.fcc.game.dice.handler.DiceGameSimulator;

public class DiceGameApplication {
  public static void main(String[] args) {
    final int numSimulations = 10000; // You can change this value to run a different number of simulations
    final int numDice = 5; // You can change this value to use a different number of dice
    final DiceGameSimulator simulator = new DiceGameSimulator(numSimulations, numDice);
    simulator.runSimulations();
  }
}


