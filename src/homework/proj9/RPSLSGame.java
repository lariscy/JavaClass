package homework.proj9;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Steven Lariscy
 * @projectNumber PL004T
 * @date 3.27.2017
 * @dueDate 3.30.2017
 * @description RPSLS (Rock Paper Scissors Lizard Spock)
 */
public class RPSLSGame {
    
    // constants
    public static final Random RANDOM = new Random();
    public static final int POINTS_TO_WIN = 5;
    
    // instance variables
    private final Scanner keyboard;
    private int turnNumber = 1;

    // constructor
    public RPSLSGame(Scanner keyboard) {
        this.keyboard = keyboard;
    } // end of constructor
    
    public void play(){
        this.showWelcome();
        
        RPSLSPlayer player1 = null;
        RPSLSPlayer player2 = null;
        
        switch(this.decideGameType()){
            case HUMAN_VS_HUMAN:
                System.out.print("Player1 enter your name: ");
                player1 = new RPSLSHumanPlayer(this.keyboard.nextLine(), this.keyboard);
                System.out.print("Player2 enter your name: ");
                player2 = new RPSLSHumanPlayer(this.keyboard.nextLine(), this.keyboard);
                break;
            case HUMAN_VS_COMPUTER:
                System.out.print("Player1 enter your name: ");
                player1 = new RPSLSHumanPlayer(this.keyboard.nextLine(), this.keyboard);
                player2 = new RPSLSComputerPlayer();
                break;
            case COMPUTER_VS_COMPUTER:
                player1 = new RPSLSComputerPlayer();
                player2 = new RPSLSComputerPlayer();
                break;
            default:
                // this should never happen but just in case someone adds a new
                // game type in the future
                System.err.println("Invalid game type choosen!");
                return; // leave the method
        } // end switch
        
        if (player1 != null && player2 != null){
            System.out.println("Game will be " + player1.getName() + " vs. " + 
                    player2.getName());
            
            RPSLSOption player1Option = null;
            RPSLSOption player2Option = null;
            RPSLSOption[] options = RPSLSOption.values();
            
            do { // while no player has won
                System.out.println("**ROUND " + this.turnNumber + "**");
                
                player1Option = player1.shoot();
                System.out.println(this.turnNumber + "- " + player1.getName() + 
                        " : " + player1Option.getSimpleName());
                player2Option = player2.shoot();
                System.out.println(this.turnNumber + "- " + player2.getName() + 
                        " : " + player2Option.getSimpleName());
                
                int winResult = (options.length + player1Option.ordinal() - 
                        player2Option.ordinal()) % options.length;
                
                if (winResult == 0){
                    System.out.println("Players tied!");
                } else if ((winResult % 2) != 0){ // end if
                    // winResult is odd (player1 wins)
                    System.out.println(player1.getName() + " wins hand");
                    player1.incrementPoints();
                } else { // end else if
                    // winResult is even (player2 wins)
                    System.out.println(player2.getName() + " wins hand");
                    player2.incrementPoints();
                } // end else
                
                this.turnNumber++;
            } while (player1.getCurrentPoints() < RPSLSGame.POINTS_TO_WIN && 
                    player2.getCurrentPoints() < RPSLSGame.POINTS_TO_WIN);
        } else { // end if
            System.err.println("There was an error while setting up player information!");
            return; // leave method
        } // end else
        
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println((player1.getCurrentPoints() >= RPSLSGame.POINTS_TO_WIN ?
                player1.getName() : player2.getName()) + " wins the game with a score of " + 
                player1.getCurrentPoints() + " : " + player2.getCurrentPoints() + "!");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    } // end of play
    
    private void showWelcome(){
        System.out.println("*************************************************");
        System.out.println("Rock-Paper-Scissors-Lizard-Spock");
        System.out.println("*************************************************");
    } // end of showWelcome
    
    private RPSLSGameType decideGameType(){
        System.out.println("--Game Type Menu--");
        RPSLSGameType[] gameTypes = RPSLSGameType.values();
        for (RPSLSGameType type : gameTypes){
            System.out.println(type.ordinal() + ") " + type.getSimpleName());
        } // end for
        System.out.print("Choose game type: ");
        return gameTypes[Integer.parseInt(this.keyboard.nextLine())];
    } // end of decideGameType

    public Scanner getKeyboard() {
        return this.keyboard;
    } // end getKeyboard
    
} // end class
