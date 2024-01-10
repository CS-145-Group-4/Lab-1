//Raymond Daniels, Mali Brunk, Emmal Lindsey
//Lab1
//CS 145
//01.08.2024


import java.util.*;
//This constant dictates random number generation range for game
//this program runs a command line based number guessing game
public class Lab1 {
    //This constant dictates random number generation range for game
    public static final int RANGE_MAX = 100;
    public static final int MAX_GUESSES = 9999; 
    // bestGuess = MAX_GUESSES and then will call bestGame method after each game

    //introduces the game. calls game method.
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("This program allows you to play a guessing game.");
        System.out.println("I will think of a number between 1 and");
        System.out.println("100 and will allow you to guess until");
        System.out.println("you get it. For each guess, I will tell you");
        System.out.println("whether the right answer is higher or lower");
        System.out.println("than your guess.");
        game(console);
    }

    //while statements to starts a new game. generates a random
    //number between 1 and 100. requests guess from player. calls inputChecker
    //compares user guess to generated number. Counts guesses and games.
    //congratulates player. When player chooses to end, displays results
    public static void game(Scanner console) {
        int guessCountTotal = 0;
        int guessCount = 0;
        int gameCount = 0;
        Random rand = new Random();
        int userInput;
        String response = "y";
        while (!response.equals("n")) {
            if (response.equals("y")) {
                int generatedNumber = rand.nextInt(100);
                System.out.println("I'm thinking of a number between " +
                        "1 and " + RANGE_MAX + "...");
                userInput = console.nextInt();
                while (userInput != generatedNumber) {
                    System.out.print("Your guess?");
                    userInput = inputCheck(console.nextInt(), console);
                    guessCount++;
                    if (userInput < generatedNumber) {
                        System.out.println("It's lower.");
                    } else if (userInput > generatedNumber) {
                        System.out.println("It's higher.");
                    }
                    System.out.println("You got it right in " + guessCount + "guesses");
                }
                guessCountTotal += guessCount;
                gameCount++;
                response = gameStatusCheck(console);
            }
        }
        results(guessCount, guessCountTotal, gameCount);
    }

    // compares number of guesses from one game to the "best" guess
    // reassigns value of bestGuess and returns
    public static int bestGame(int guessCount, int bestGuess) {
        if (guessCount <= bestGuess) {
            return guessCount;
        } else {
            return bestGuess;
        }
    }

    //This method analyzes game statistics, calculates average, and displays to user
    public static void results(int bestGuess, int guessCountTotal, int gameCount){ // changed first param
            double average = (guessCountTotal / gameCount);
            System.out.println("Overall results:");
            System.out.printf("\t%-13s = %d%n", "total games", gameCount);
            System.out.printf("\t%-13s = %d%n", "total guesses", guessCountTotal);
            System.out.printf("\t%-13s = %.1f%n", "guesses/game", average);
            System.out.printf("\t%-13s = %d%n", "best game", bestGuess);
    }

    //takes in user input from game, while command checks if input is an int
    //is between 1 and 100 returns valid response else states there's an error,
    //and requests a new input.
    public static int inputCheck(int userInput, Scanner console) {
        boolean goodInput = false;
        while (!goodInput) {
            userInput = Integer.parseInt(console.nextLine());
            if (userInput > 0 && userInput <= RANGE_MAX) {
                goodInput = true;
            }
        }
        return userInput;
    }

    //this method takes in the console, returns a string
    //determines if user wants to play another game by taking first letter of
    //what the user types into console. if first letter isn't y/n, tells user
    //to give a new command
    public static String gameStatusCheck(Scanner console) {
        System.out.println("Do you want to play again?");
        String userInput = console.nextLine();
        while(){
        }
    }
}
