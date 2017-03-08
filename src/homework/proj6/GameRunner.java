package homework.proj6;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 * Main class
 * 
 * @author Steven Lariscy
 */
public class GameRunner {

    private final Player[] players;
    private final Spinner spinner;
    private final Random r;
    
    public static void main(String[] args) {
        new GameRunner().play();
    } // end of main

    public GameRunner() {
        players = new Player[2];
        spinner = new Spinner();
        r = new Random();
    }

    private void play() {
        this.log("Welcome to Chutes and Ladders!");
        
        this.setupPlayers();
        this.determinePlayerOrder();
        
        boolean someoneWon = false;
        while (!someoneWon){
            for (Player p : players){
                int spinAmount = spinner.spin();
                this.log(p.getName() + ": spun a " + spinAmount);
                
                int currentSquare = p.getCurrentSquareNumber();
                int currentPlusSpin = currentSquare + spinAmount;
                
                if (currentPlusSpin > BoardLogic.MAX_BOARD_NUMBER){
                    this.log(p.getName() + "'s current spin would have moved "
                        + "them past " + BoardLogic.MAX_BOARD_NUMBER + 
                        " so they will remain still");
                } else {
                    p.updateCurrentSquareNumber(BoardLogic.getNextSqure(currentPlusSpin));
                    this.log(p.getName() + ": moved to " + p.getCurrentSquareNumber());
                    
                    if (p.getCurrentSquareNumber() == BoardLogic.MAX_BOARD_NUMBER){
                        this.log(p.getName() + " has won the game! Congratulations!");
                        someoneWon = true;
                        break; // breaks out of for loop
                    }
                }
            }
        }
        
        this.log("Thanks for playing!");
    } // end of play
    
    private void setupPlayers(){
        Scanner s = new Scanner(System.in);
        Player p1 = null;
        while (p1 == null){
            //@TODO make this better
            this.logNoLine("Player 1, enter your name: ");
            p1 = new Player(s.nextLine());
            players[0] = p1;
        }
        Player p2 = null;
        while (p2 == null){
            //@TODO make this better
            this.logNoLine("Player 2, enter your name: ");
            p2 = new Player(s.nextLine());
            players[1] = p2;
        }
        s.close();
        
        this.log(
            String.format("Current match: %s vs. %s. Good luck!"
                , players[0].getName(), players[1].getName()));
    } // end of setupPlayers
    
    private void determinePlayerOrder() {
        this.log("Flipping a coin to see who goes first");
        
        char[] flipSegments = {'-', '\\', '|', '/'};
        
        for (int i = 0; i < (r.nextInt(15) + 1); i++){
            this.log(flipSegments[i % flipSegments.length]);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) { /* ignore exception */ }
        }
        
        boolean isHeads = r.nextBoolean();
        this.log("Flip landed on " + (isHeads ? "Heads" : "Tails") + 
            " so " + (isHeads ? players[0].getName() : players[1].getName()) + 
            " will start");
        
        if (!isHeads){
            // reverse order of players array
            Collections.reverse(Arrays.asList(players));
        }
    } // end of determinePlayerOrder
    
    /*
    Utility methods below
    @TODO fix all these - this is terrible
    */
    private void log(char c){
        log(Character.toString(c));
    }
    private void log(String line){
        System.out.println(line);
    }
    private void logNoLine(String line){
        System.out.print(line);
    }

} // end of class
