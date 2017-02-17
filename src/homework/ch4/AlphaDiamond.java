package homework.ch4;

import java.util.Scanner;

/**
 * @author Steven Lariscy
 */
public class AlphaDiamond {

    private Scanner scanner;

    private static final boolean DEBUG = true;

    public static void main(String[] args) {
        new AlphaDiamond().run();
    } // end of main method

    public void run() {
        scanner = new Scanner(System.in);

        char input = getUserInput();
        if (input != '!') {
            debug(String.format("printing diamond from %s to %s", 'A', input));

            int totalLetters = input - 'A' + 1;
            debug("totalLetters: " + totalLetters);

            int totalRows = totalLetters * 2 - 1;
            debug("totalRows: " + totalRows);
            // totalColumns would be implied by totalRows

            int numSpaces = 'A' - ('A' - totalLetters + 1);
            debug("numSpaces: " + numSpaces);

            char currentChar = 'A';
            for (int i = 1; i <= totalLetters; i++) { // rows
                if (numSpaces > 0) {
                    System.out.print(String.format("%" + numSpaces + "s", " "));
                }
                numSpaces--;
                currentChar = 'A';
                for (int j = 1; j <= (i * 2) - 1; j++) { // columns
                    System.out.print(currentChar);
                    if (j > ((i * 2) - 1) / 2) {
                        currentChar--;
                    } else {
                        currentChar++;
                    }
                }
                System.out.println();
            }

            numSpaces = 1;
            for (int i = 1; i <= (totalLetters - 1); i++) { // rows
                System.out.print(String.format("%" + numSpaces + "s", " "));
                numSpaces++;
                currentChar = 'A';
                for (int j = 1; j <= 2 * (totalLetters - i) - 1; j++) { // columns
                    System.out.print(currentChar);
                    if (j > (2 * (totalLetters - i) - 1) / 2) {
                        currentChar--;
                    } else {
                        currentChar++;
                    }
                }
                System.out.println();
            }
        }

        //System.out.print(String.format("%" + numSpaces + "s", " "));
        scanner.close();
    } // end of run method

    public char getUserInput() {
        System.out.print("Enter a single character from the alphabet: ");
        String input = scanner.next();
        if (input.length() == 1 && Character.isAlphabetic(input.charAt(0))) {
            return Character.toUpperCase(input.charAt(0));
        } else {
            System.err.println(String.format("You entered an invalid input String of [%s], exiting!", input));
            return '!';
        }
    } // end of getUserInput method

    private void debug(String line) {
        if (DEBUG) {
            System.out.println(String.format("DEBUG: %s", line));
        }
    } // end of debug method

} // end of class
