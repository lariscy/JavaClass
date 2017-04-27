package homework.proj13;

import java.util.Scanner;

/**
 * @author Steven Lariscy
 * @projectNumber PL004T
 * @date 4.21.2017
 * @dueDate 4.27.2017
 * @description Bank Program
 */
public class Input {
    
    // instance variables
    private final Scanner scanner;

    // constructor
    public Input(Scanner scanner) {
        this.scanner = scanner;
    } // end constructor
    
    public TransactionType getMenuOption(){
        boolean valid = false;
        TransactionType option = null;
        do { // while (!valid) 
            try {
                option = TransactionType.values()[Integer.parseInt(scanner.nextLine().trim())];
                valid = true;
            } catch (Exception e){ // end try
                System.err.println("Error: Invalid Option, choose again!");
            } // end catch
        } while (!valid);
        return option;
    } // end getMenuOption
    
    public String getUserInput(){
        return this.scanner.nextLine().trim();
    } // end getUserInput

    public Scanner getScanner() {
        return this.scanner;
    } // end getScanner
    
} // end class
