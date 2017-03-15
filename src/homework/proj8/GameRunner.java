package homework.proj8;

import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @author Steven Lariscy
 */
public class GameRunner {
    
    public static final int MAX_PLAYER_TURNS = 39;

    private Player player1;
    private Player player2;
    private final Scanner s;
    private final Cup cup;

    public GameRunner() {
        this.s = new Scanner(System.in);
        this.cup = new Cup();
    }

    public static void main(String[] args) {
        new GameRunner().play();
    }

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
                System.out.println("[Turn " + turnNum + " of " + MAX_PLAYER_TURNS + " - " 
                        + player1.getName() + "] " + "Scorecard already completed");
            }
            System.out.println("");
            
            // player2's turn
            if (!this.player2.getScorecard().isScoreboardComplete()){
                this.processPlayerTurn(this.player2, turnNum);
            } else {
                System.out.println("[Turn " + turnNum + " of " + MAX_PLAYER_TURNS + " - " 
                        + player2.getName() + "] " + "Scorecard already completed");
            }
            System.out.println("");
            
            if (this.player1.getScorecard().isScoreboardComplete() && 
                    this.player2.getScorecard().isScoreboardComplete()){
                System.out.println("Game Over! Printing final score cards");
                System.out.println("");
                break;
            }
        }
        
        System.out.println("[" + player1.getName() + "] " + "Current Scorecard");
        player1.getScorecard().printCurrentScorecard();
        
        System.out.println("[" + player2.getName() + "] " + "Current Scorecard");
        player2.getScorecard().printCurrentScorecard();
        
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.print("Winner: ");
        if (player1.getScorecard().getGrandTotal() > player2.getScorecard().getGrandTotal()){
            System.out.println(player1.getName());
        } else {
            System.out.println(player2.getName());
        }
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        s.close();
    }

    private String getDiceValueAsString() {
        StringJoiner sj = new StringJoiner(", ");
        for (Die die : cup.getDice()) {
            sj.add(String.valueOf(die.getCurrentVal()));
        }
        return sj.toString();
    }

    private void processPlayerTurn(Player player, int turnNum) {
        System.out.println("[Turn " + turnNum + " of " + MAX_PLAYER_TURNS + " - " 
                + player.getName() + "] " + "Current Scorecard");
        player.getScorecard().printCurrentScorecard();

        this.cup.roll();
        System.out.println("[Turn " + turnNum + " of " + MAX_PLAYER_TURNS + " - " 
                + player.getName() + "] " + "Rolled: " + this.getDiceValueAsString());
        player.getScorecard().printValidOptions();

        boolean validChoice = false;
        do {
            System.out.print("[Turn " + turnNum + " of " + MAX_PLAYER_TURNS + " - " 
                    + player.getName() + "] " + "Choose option: ");
            int playerOption = this.s.nextInt();
            if (player.getScorecard().isValidOption(playerOption)){
                switch (playerOption){
                    case 0:
                        // pass
                        // set 0 to picked if its not possible (becaue of lack of turns)
                        if (player.getScorecard().getValidOptionsLeft() >= (MAX_PLAYER_TURNS - turnNum)){
                            player.getScorecard().getScoreOption(playerOption).setPicked(true);
                        }
                        System.out.println("[Turn " + turnNum + " of " + MAX_PLAYER_TURNS + " - " 
                                    + player.getName() + "] Player passed");
                        break;
                    case 1:
                        // logic in case 6
                    case 2:
                        // logic in case 6
                    case 3:
                        // logic in case 6
                    case 4:
                        // logic in case 6
                    case 5:
                        // logic in case 6
                    case 6:
                        int numOfOption = 0;
                        for (Die die : this.cup.getDice()){
                            if (die.getCurrentVal() == playerOption){
                                numOfOption++;
                            }
                        }
                        player.getScorecard().getScoreOption(playerOption).setScore(playerOption * numOfOption);
                        player.getScorecard().getScoreOption(playerOption).setPicked(true);
                        break;
                    case 7:
                        // 3 of a kind
                        int[] numOfEachNumber = {0, 0, 0, 0, 0, 0};
                        for (Die die : this.cup.getDice()){
                            numOfEachNumber[die.getCurrentVal()-1]++;
                        }
                        boolean threeFound = false;
                        for (int num : numOfEachNumber){
                            if (num >= 3){
                                threeFound = true;
                                break;
                            }
                        }
                        if (threeFound){
                            player.getScorecard().getScoreOption(playerOption).setScore(this.cup.getDiceTotal());
                        } else {
                            player.getScorecard().getScoreOption(playerOption).setScore(0);
                        }
                        player.getScorecard().getScoreOption(playerOption).setPicked(true);
                        break;
                    case 8:
                        // 4 of a kind
                        int[] numOfEachNumber2 = {0, 0, 0, 0, 0, 0};
                        for (Die die : this.cup.getDice()){
                            numOfEachNumber2[die.getCurrentVal()-1]++;
                        }
                        boolean fourFound = false;
                        for (int num : numOfEachNumber2){
                            if (num >= 4){
                                fourFound = true;
                                break;
                            }
                        }
                        if (fourFound){
                            player.getScorecard().getScoreOption(playerOption).setScore(this.cup.getDiceTotal());
                        } else {
                            player.getScorecard().getScoreOption(playerOption).setScore(0);
                        }
                        player.getScorecard().getScoreOption(playerOption).setPicked(true);
                        break;
                    case 9:
                        // full house
                        int[] counts = new int[6];
                        for (Die dice : cup.getDice()) {
                            counts[dice.getCurrentVal() - 1]++;
                        }
                        boolean check2 = false;
                        boolean check3 = false;
                        for (int i: counts) {
                            check2 |= (i==2);
                            check3 |= (i==3);
                        }
                        if (check2 && check3){
                            player.getScorecard().getScoreOption(playerOption).setScore(Scorecard.SCORE_FOR_FULL_HOUSE);
                        } else {
                            player.getScorecard().getScoreOption(playerOption).setScore(0);
                        }
                        player.getScorecard().getScoreOption(playerOption).setPicked(true);
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
                                }
                            }
                            if (!foundNum){
                                isLowStraight = false;
                                break;
                            }
                        }
                        if (isLowStraight){
                            player.getScorecard().getScoreOption(playerOption).setScore(Scorecard.SCORE_FOR_LOW_STRAIGHT);
                        } else {
                            player.getScorecard().getScoreOption(playerOption).setScore(0);
                        }
                        player.getScorecard().getScoreOption(playerOption).setPicked(true);
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
                                }
                            }
                            if (!foundNum){
                                isHighStraight = false;
                                break;
                            }
                        }
                        if (isHighStraight){
                            player.getScorecard().getScoreOption(playerOption).setScore(Scorecard.SCORE_FOR_HIGH_STRAIGHT);
                        } else {
                            player.getScorecard().getScoreOption(playerOption).setScore(0);
                        }
                        player.getScorecard().getScoreOption(playerOption).setPicked(true);
                        break;
                    case 12:
                        // yahtzee
                        boolean allSame = true;
                        Die[] dice = this.cup.getDice();
                        for (int i = 1; i<dice.length; i++){
                            if (dice[0].getCurrentVal() != dice[i].getCurrentVal()){
                                allSame = false;
                                break;
                            }
                        }
                        if (allSame){
                            player.getScorecard().getScoreOption(playerOption).setScore(Scorecard.SCORE_FOR_YAHTZEE);
                        } else {
                            player.getScorecard().getScoreOption(playerOption).setScore(0);
                        }
                        player.getScorecard().getScoreOption(playerOption).setPicked(true);
                        break;
                    case 13:
                        int totalScore = 0;
                        for (Die die : this.cup.getDice()){
                            totalScore += die.getCurrentVal();
                        }
                        player.getScorecard().getScoreOption(playerOption).setScore(totalScore);
                        player.getScorecard().getScoreOption(playerOption).setPicked(true);
                        break;
                }
                validChoice = true;
            } else {
                System.out.println("[Turn " + turnNum + " of " + MAX_PLAYER_TURNS + " - " 
                        + player.getName() + "] Invalid Option! Choose again");
            }
        } while (!validChoice);
    }

}
