//Raymond Daniels, Mali Brunk, Emmal Lindsey
//Lab1
//CS 145
//01.08.2024


import java.util.*;

//this program runs a command line based number guessing game
public class GuessingGame {

    //This constant dictates random number generation range for game
    public static final int RANGE_MAX = 100;

    //Introduces the game. Initializes variables to be used for the results
    //of gameplay, and sets variables based on gameplay analysis.
    public static void main(String[] args) {
        intro();

        Scanner console = new Scanner(System.in);
        int guessCount;
        int guessCountTotal = 0;
        int gameCount = 0;
        int bestGuess = 0;
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
        System.out.println("I will think of a number between 1 and");
        System.out.println("100 and will allow you to guess until");
        System.out.println("you get it. For each guess, I will tell you");
        System.out.println("whether the right answer is higher or lower");
        System.out.println("than your guess.");
    }

    //runs the guessing game. takes in the console, returns number of guesses
    //for each game.
    public static int game(Scanner console) {
        int userInput = 0;
        int guessCount = 0;
        Random rand = new Random();
        int generatedNumber = rand.nextInt(RANGE_MAX);
        System.out.println("I'm thinking of a number between " +
                "1 and " + RANGE_MAX + "...");
        while (userInput != generatedNumber) {
            System.out.print("Your guess?");
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

    //This method analyzes game statistics and displays to user
    public static void results(int bestGuess, int guessCountTotal, int gameCount) {
        double average = (double) guessCountTotal / gameCount;
        System.out.println("\nOverall results:");
        System.out.printf("    %-13s = %d%n", "total games", gameCount);
        System.out.printf("    %-13s = %d%n", "total guesses", guessCountTotal);
        System.out.printf("    %-13s = %.1f%n", "guesses/game", average);
        System.out.printf("    %-13s = %d%n", "best game", bestGuess);
    }

    //this method takes in the console, returns a string
    //determines if user wants to play another game by taking first letter of
    //what the user types into console.
    public static String gameStatusCheck(Scanner console) {
        System.out.print("Do you want to play again? ");
        String userInput = console.next();
        return userInput.toLowerCase();
    }
}
