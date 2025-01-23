
# Dice Game Simulation

This project simulates a dice game and runs multiple simulations to analyze the results.

## Project Structure

- `src/main/java/ca/fcc/game/dice/` - Contains the main application and game logic.
- `src/test/java/ca/fcc/game/dice/` - Contains unit tests for the application.

## Prerequisites

- Java 11 or higher
- Maven 3.6.0 or higher

## Dependencies

The project uses the following dependencies:

- JUnit 5 for testing
- SLF4J and Logback for logging

## Building the Project

To build the project, run the following command:

```
mvn clean install
```

## Running the Application

To run the application, use the following command:

```
mvn exec:java -Dexec.mainClass="ca.fcc.game.dice.DiceGameApplication"
```

## Running Tests

To run the tests, use the following command:

```
mvn test
```

## Customizing the Simulation

You can customize the number of simulations and the number of dice used in the simulation by modifying the `main` method in `DiceGameApplication.java`:

public static void main(String[] args) { int numberOfSimulations = 10000; int numberOfDice = 2; DiceGameSimulation simulation = new DiceGameSimulation(numberOfSimulations, numberOfDice); simulation.run(); }

## Simulation Results

For a simulation with 10,000 runs using 2 dice, refer to the following document:

[Simulation Results](document/simulation-for-num-10000-with-2-dice.jpg)

## License

This project is licensed under the MIT License.
