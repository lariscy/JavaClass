package homework.ch4;

import java.util.Scanner;

/**
 * @author Steven Lariscy
 * @project 
 * @dueDate 02.23.2017
 */
public class AlphaDiamond {

    private Scanner scanner;

    private static final boolean DEBUG = false;

    public static void main(String[] args) {
        new AlphaDiamond().run();
    } // end of main method

    public void run() {
        scanner = new Scanner(System.in);

        char input = getUserInput();
        if (input != '!') {
            debug(String.format("printing diamond from %s to %s", 'A', input));

            int totalLetters = input - 'A' + 1;
            int totalRows = totalLetters * 2 - 1;
            int numSpaces = 'A' - ('A' - totalLetters + 1);
            debug(String.format("totalLetters: %s, totalRows: %s, numSpaces: %s", totalLetters, totalRows, numSpaces));
            
            // top of diamond
            char currentChar = 'A';
            for (int rowNum = 1; rowNum <= totalLetters; rowNum++, numSpaces--) { // rows
                if (numSpaces > 0) {
                    System.out.print(String.format("%" + numSpaces + "s", " "));
                }
                
                currentChar = 'A';
                for (int colNum = 1; colNum <= (2 * rowNum) - 1; colNum++) { // columns
                    System.out.print(currentChar);
                    if (colNum > ((2 * rowNum) - 1) / 2) {
                        currentChar--;
                    } else {
                        currentChar++;
                    }
                }
                System.out.println();
            }

            // bottom of diamond
            numSpaces = 1;
            for (int rowNum = 1; rowNum <= (totalLetters - 1); rowNum++, numSpaces++) { // rows
                System.out.print(String.format("%" + numSpaces + "s", " "));
                
                currentChar = 'A';
                for (int colNum = 1; colNum <= 2 * (totalLetters - rowNum) - 1; colNum++) { // columns
                    System.out.print(currentChar);
                    if (colNum > (2 * (totalLetters - rowNum) - 1) / 2) {
                        currentChar--;
                    } else {
                        currentChar++;
                    }
                }
                System.out.println();
            }
        }
        
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
