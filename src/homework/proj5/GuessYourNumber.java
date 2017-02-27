package homework.proj5;

import java.util.Scanner;

/**
 * @author Steven Lariscy
 * @project 
 * @date 02.27.2017
 * @dueDate 03.02.2017
 * @description Program to guess your number between 0 - 999
 */
public class GuessYourNumber {

    private final Scanner s = new Scanner(System.in);
    private int lowerBound = 0;
    private int upperBound = 999;
    private int numGuesses = 0;

    public static void main(String[] args) {
        new GuessYourNumber().run();
    } // end of main

    public void run() {
        boolean isGuessCorrect = false;
        while (!isGuessCorrect) {
            int compGuess = (lowerBound + upperBound) / 2;
            char userInput = getUserInput(compGuess);

            switch (userInput) {
                case 'L':
                    upperBound = compGuess;
                    if (compGuess <= lowerBound) {
                        System.out.println("Do not cheat!");
                        System.exit(0);
                    }
                    break;
                case 'H':
                    lowerBound = compGuess;
                    if (compGuess >= upperBound) {
                        System.out.println("Do not cheat!");
                        System.exit(0);
                    }
                    break;
                case 'Y':
                    System.out.println("I guessed your number, "
                            + compGuess + " in " + numGuesses + " guess"
                            + (numGuesses > 1 ? "es" : "") + ".");
                    isGuessCorrect = true;
                    break;
                default:
                    System.out.println("Something terrible has happened!"
                            + "This should never be reached! Exiting!");
                    System.exit(-1);
            } // end switch
        } // end while

        s.close();
    } // end of run

    private char getUserInput(int compGuess) {
        System.out.println("Is it " + compGuess + "?");
        System.out.println("\tEnter 'y' if it is, 'l' if your number is lower, "
                + "or 'h' if your number is higher.");
        System.out.print("Enter: ");

        char inputChar = '!';
        boolean isValidInput = false;
        while (!isValidInput) {
            inputChar = s.next().toUpperCase().charAt(0);
            if (inputChar == 'L' || inputChar == 'H' || inputChar == 'Y') {
                isValidInput = true;
            } else {
                System.out.print("Enter 'y', 'l', or 'h' only! Try again: ");
            }
        } // end while

        numGuesses++;
        return inputChar;
    }

} // end of class
