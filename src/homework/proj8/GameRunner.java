package homework.proj8;

import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @author Steven Lariscy
 * @projectNumber PL004T
 * @date 3.20.2017
 * @dueDate 3.23.2017
 * @description text based Yahtzee game
 */
public class GameRunner {
    
    // constants
    public static final int MAX_PLAYER_TURNS = 39;

    // instance variables
    private Player player1;
    private Player player2;
    private final Scanner s;
    private final Cup cup;

    // constructor
    public GameRunner() {
        this.s = new Scanner(System.in);
        this.cup = new Cup();
    } // end of constructor

    public static void main(String[] args) {
        new GameRunner().play();
    } // end of main

    private void play() {
        System.out.print("Player 1 enter name: ");
        this.player1 = new Player(this.s.nextLine());

        System.out.print("Player 2 enter name: ");
        this.player2 = new Player(this.s.nextLine());

        System.out.println("");
        
        for (int turnNum = 1; turnNum <= GameRunner.MAX_PLAYER_TURNS; turnNum++) {
            
            // player1's turn
            if (!this.player1.getScorecard().isScoreboardComplete()){
                this.processPlayerTurn(this.player1, turnNum);
            } else {
                System.out.println("[Turn " + turnNum + " of " + GameRunner.MAX_PLAYER_TURNS + " - " 
                        + this.player1.getName() + "] " + "Scorecard already completed");
            }
            System.out.println("");
            
            // player2's turn
            if (!this.player2.getScorecard().isScoreboardComplete()){
                this.processPlayerTurn(this.player2, turnNum);
            } else {
                System.out.println("[Turn " + turnNum + " of " + GameRunner.MAX_PLAYER_TURNS + " - " 
                        + this.player2.getName() + "] " + "Scorecard already completed");
            }
            System.out.println("");
            
            if (this.player1.getScorecard().isScoreboardComplete() && 
                    this.player2.getScorecard().isScoreboardComplete()){
                System.out.println("Game Over! Printing final score cards");
                System.out.println("");
                break;
            }
        }
        
        System.out.println("[" + this.player1.getName() + "] " + "Final Scorecard");
        this.player1.getScorecard().printCurrentScorecard();
        
        System.out.println("[" + this.player2.getName() + "] " + "Final Scorecard");
        this.player2.getScorecard().printCurrentScorecard();
        
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.print("Winner: ");
        if (this.player1.getScorecard().getGrandTotal() > this.player2.getScorecard().getGrandTotal()){
            System.out.println(this.player1.getName());
        } else {
            System.out.println(this.player2.getName());
        }
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        this.s.close();
    } // end of play

    private String getDiceValueAsString() {
        StringJoiner sj = new StringJoiner(", ");
        for (Die die : this.cup.getDice()) {
            sj.add(String.valueOf(die.getCurrentVal()));
        } // end for
        return sj.toString();
    } // end of getDiceValueAsString

    private void processPlayerTurn(Player player, int turnNum) {
        System.out.println("[Turn " + turnNum + " of " + GameRunner.MAX_PLAYER_TURNS + " - " 
                + player.getName() + "] " + "Current Scorecard");
        player.getScorecard().printCurrentScorecard();

        this.cup.roll();
        System.out.println("[Turn " + turnNum + " of " + GameRunner.MAX_PLAYER_TURNS + " - " 
                + player.getName() + "] " + "Rolled: " + this.getDiceValueAsString());
        
        player.getScorecard().printValidOptions();

        boolean validChoice = false;
        do { // while (!validChoice)
            System.out.print("[Turn " + turnNum + " of " + GameRunner.MAX_PLAYER_TURNS + " - " 
                    + player.getName() + "] " + "Choose option: ");
            int playerOption = this.s.nextInt();
            if (player.getScorecard().isValidOption(playerOption)){
                switch (playerOption){
                    case 0:
                        // pass
                        // set 0 to picked if its not possible (becaue of lack of turns)
                        if (player.getScorecard().getValidOptionsLeft() >= (GameRunner.MAX_PLAYER_TURNS - turnNum)){
                            player.getScorecard().getScoreOption(playerOption).setPicked(true);
                        }
                        System.out.println("[Turn " + turnNum + " of " + GameRunner.MAX_PLAYER_TURNS + " - " 
                                    + player.getName() + "] Player passed");
                        break;
                    case 1:
                        // ones
                        // logic in case 6
                    case 2:
                        // twos
                        // logic in case 6
                    case 3:
                        // threes
                        // logic in case 6
                    case 4:
                        // fours
                        // logic in case 6
                    case 5:
                        // fives
                        // logic in case 6
                    case 6:
                        // sixes
                        // logic for ones through sixes
                        int numOfOption = 0;
                        for (Die die : this.cup.getDice()){
                            if (die.getCurrentVal() == playerOption){
                                numOfOption++;
                            } //end if
                        } // end for
                        player.getScorecard().getScoreOption(playerOption).setScore(playerOption * numOfOption);
                        player.getScorecard().getScoreOption(playerOption).setPicked(true);
                        this.checkIfPlayerScoredZero(player, turnNum, playerOption);
                        break;
                    case 7:
                        // 3 of a kind
                        int[] numOfEachNumber = {0, 0, 0, 0, 0, 0};
                        for (Die die : this.cup.getDice()){
                            numOfEachNumber[die.getCurrentVal()-1]++;
                        } // end for
                        boolean threeFound = false;
                        for (int num : numOfEachNumber){
                            if (num >= 3){
                                threeFound = true;
                                break;
                            } // end if
                        } // end for
                        player.getScorecard().getScoreOption(playerOption)
                                .setScore(threeFound ? this.cup.getDiceTotal() : 0);
                        player.getScorecard().getScoreOption(playerOption).setPicked(true);
                        this.checkIfPlayerScoredZero(player, turnNum, playerOption);
                        break;
                    case 8:
                        // 4 of a kind
                        int[] numOfEachNumber2 = {0, 0, 0, 0, 0, 0};
                        for (Die die : this.cup.getDice()){
                            numOfEachNumber2[die.getCurrentVal()-1]++;
                        } // end for
                        boolean fourFound = false;
                        for (int num : numOfEachNumber2){
                            if (num >= 4){
                                fourFound = true;
                                break;
                            } // end if
                        } // end for
                        player.getScorecard().getScoreOption(playerOption)
                                .setScore(fourFound ? this.cup.getDiceTotal() : 0);
                        player.getScorecard().getScoreOption(playerOption).setPicked(true);
                        this.checkIfPlayerScoredZero(player, turnNum, playerOption);
                        break;
                    case 9:
                        // full house
                        int[] counts = new int[6];
                        for (Die dice : this.cup.getDice()) {
                            counts[dice.getCurrentVal() - 1]++;
                        } // end for
                        boolean check2 = false;
                        boolean check3 = false;
                        for (int i: counts) {
                            check2 |= (i==2);
                            check3 |= (i==3);
                        } // end for
                        player.getScorecard().getScoreOption(playerOption)
                                .setScore((check2 && check3) ? Scorecard.SCORE_FOR_FULL_HOUSE : 0);
                        player.getScorecard().getScoreOption(playerOption).setPicked(true);
                        this.checkIfPlayerScoredZero(player, turnNum, playerOption);
                        break;
                    case 10:
                        // low straight
                        boolean isLowStraight = true;
                        for (int i=1; i<=5; i++){
                            boolean foundNum = false;
                            for (Die die : this.cup.getDice()){
                                if (die.getCurrentVal() == i){
                                    foundNum = true;
                                    break;
                                } // end if
                            } // end for
                            if (!foundNum){
                                isLowStraight = false;
                                break;
                            } // end if
                        } // end for
                        player.getScorecard().getScoreOption(playerOption)
                                .setScore(isLowStraight ? Scorecard.SCORE_FOR_LOW_STRAIGHT : 0);
                        player.getScorecard().getScoreOption(playerOption).setPicked(true);
                        this.checkIfPlayerScoredZero(player, turnNum, playerOption);
                        break;
                    case 11:
                        // high straight
                        boolean isHighStraight = true;
                        for (int i=2; i<=6; i++){
                            boolean foundNum = false;
                            for (Die die : this.cup.getDice()){
                                if (die.getCurrentVal() == i){
                                    foundNum = true;
                                    break;
                                } // end if
                            } // end for
                            if (!foundNum){
                                isHighStraight = false;
                                break;
                            } // end if
                        } // end for
                        player.getScorecard().getScoreOption(playerOption)
                                .setScore(isHighStraight ? Scorecard.SCORE_FOR_HIGH_STRAIGHT : 0);
                        player.getScorecard().getScoreOption(playerOption).setPicked(true);
                        this.checkIfPlayerScoredZero(player, turnNum, playerOption);
                        break;
                    case 12:
                        // yahtzee
                        boolean allSame = true;
                        Die[] dice = this.cup.getDice();
                        for (int i = 1; i<dice.length; i++){
                            if (dice[0].getCurrentVal() != dice[i].getCurrentVal()){
                                allSame = false;
                                break;
                            } // end if
                        } // end for
                        player.getScorecard().getScoreOption(playerOption)
                                .setScore(allSame ? Scorecard.SCORE_FOR_YAHTZEE: 0);
                        player.getScorecard().getScoreOption(playerOption).setPicked(true);
                        this.checkIfPlayerScoredZero(player, turnNum, playerOption);
                        break;
                    case 13:
                        // chance
                        int totalScore = 0;
                        for (Die die : this.cup.getDice()){
                            totalScore += die.getCurrentVal();
                        } // end for
                        player.getScorecard().getScoreOption(playerOption).setScore(totalScore);
                        player.getScorecard().getScoreOption(playerOption).setPicked(true);
                        this.checkIfPlayerScoredZero(player, turnNum, playerOption);
                        break;
                } // end switch
                validChoice = true;
            } else { // end if
                System.out.println("[Turn " + turnNum + " of " + GameRunner.MAX_PLAYER_TURNS + " - " 
                        + player.getName() + "] Invalid Option! Choose again");
            } // end else
        } while (!validChoice); // end of while
    } // end of processPlayerTurn
    
    private void checkIfPlayerScoredZero(Player player, int turnNum, int playerOption){
        if (player.getScorecard().getScoreOption(playerOption).getScore() == 0){
            System.out.println("[Turn " + turnNum + " of " + GameRunner.MAX_PLAYER_TURNS + " - " 
                    + player.getName() + "] Roll did not meet criteria. Score will be 0");
        }
    }

} // end class
