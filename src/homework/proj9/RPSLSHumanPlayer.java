package homework.proj9;

import java.util.Scanner;

/**
 * @author Steven Lariscy
 * @projectNumber PL004T
 * @date 3.27.2017
 * @dueDate 3.30.2017
 * @description RPSLS (Rock Paper Scissors Lizard Spock)
 */
public class RPSLSHumanPlayer extends RPSLSPlayer {
    
    // instance variables
    private final Scanner keyboard;

    // constructor
    public RPSLSHumanPlayer(String name, Scanner keyboard) {
        super(name);
        this.keyboard = keyboard;
    } // end of constructor

    @Override
    public RPSLSOption shoot() {
        System.out.println("--Options--");
        RPSLSOption[] options = RPSLSOption.values();
        for (RPSLSOption option : options){
            System.out.println(option.ordinal() + ") " + option.getSimpleName());
        } // end for
        System.out.print("Choose option: ");
        return options[Integer.parseInt(this.keyboard.nextLine())];
    } // end of shoot
    
} // end class
