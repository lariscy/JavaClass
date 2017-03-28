package homework.proj9;

import java.util.Scanner;

/**
 * @author Steven Lariscy
 * @projectNumber PL004T
 * @date 3.27.2017
 * @dueDate 3.30.2017
 * @description RPSLS (Rock Paper Scissors Lizard Spock)
 */
public class RPSLSDriver {
    
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        new RPSLSGame(keyboard).play();
        keyboard.close();
    } // end of main
    
} // end class
