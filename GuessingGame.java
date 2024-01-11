//Raymond Daniels, Mali Brunk
//Lab 1
//CS 145
//01.08.2024
//this program runs a command line based number guessing game

import java.util.*;

public class GuessingGame {

    //Constants dictate random number generation range for game and
    //the maximum number of guesses in a single game
    public static final int RANGE_MAX = 100;
    public static final int MAX_GUESSES = 9999;

    //Introduces the game. Initializes variables to be used for the results
    //of gameplay, and sets variables based on gameplay analysis.
    public static void main(String[] args) {
        intro();

        Scanner console = new Scanner(System.in);
        int guessCount;
        int guessCountTotal = 0;
        int gameCount = 0;
        int bestGuess = MAX_GUESSES;
        String response = "y";

        while (!response.startsWith("n")) {
            System.out.println();
            guessCount = game(console);
            bestGuess = Math.min(guessCount, bestGuess);
            guessCountTotal += guessCount;
            gameCount++;

            response = gameStatusCheck(console);
        }

        results(bestGuess, guessCountTotal, gameCount);
    }

    //Introduces the user to what the program does and how to play.
    public static void intro() {
        System.out.println("This program allows you to play a guessing game.");
        System.out.println("I will think of a number between 1 and ");
        System.out.println("100 and will allow you to guess until");
        System.out.println("you get it.  For each guess, I will tell you");
        System.out.println("whether the right answer is higher or lower");
        System.out.println("than your guess.");
    }

    //Runs the guessing game. Takes in the console, returns number of guesses
    //for each game.
    public static int game(Scanner console) {
        int userInput = 0;
        int guessCount = 0;
        Random rand = new Random();
        int generatedNumber = rand.nextInt(RANGE_MAX) + 1;
        System.out.println("I'm thinking of a number between " +
                "1 and " + RANGE_MAX + "...");

        while (userInput != generatedNumber) {
            System.out.print("Your guess? ");
            userInput = console.nextInt();
            guessCount++;
            if (userInput < generatedNumber) {
                System.out.println("It's higher.");
            } else if (userInput > generatedNumber) {
                System.out.println("It's lower.");
            } else if (guessCount == 1) {
                System.out.println("You got it right in " + guessCount
                        + " guess");
            } else {
                    System.out.println("You got it right in " + guessCount
                            + " guesses");
            }
        }
        return guessCount;
    }

    //Takes in game statistics as parameters, calculates average, and displays to user
    public static void results(int bestGuess, int guessCountTotal, int gameCount) {
        double average = (double) guessCountTotal / gameCount;
        System.out.println();
        System.out.println("Overall results:");
        System.out.printf("    %-13s = %d%n", "total games", gameCount);
        System.out.printf("    %-13s = %d%n", "total guesses", guessCountTotal);
        System.out.printf("    %-13s = %.1f%n", "guesses/game", average);
        System.out.printf("    %-13s = %d%n", "best game", bestGuess);
    }

    //Takes in the console, prompts to play game again
    //converts user input to lowercase and returns the string
    public static String gameStatusCheck(Scanner console) {
        System.out.print("Do you want to play again? ");
        String userInput = console.next();
        return userInput.toLowerCase();
    }
}
