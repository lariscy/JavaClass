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
        s = new Scanner(System.in);
        cup = new Cup();
    }

    public static void main(String[] args) {
        new GameRunner().play();
    }

    private void play() {
        System.out.print("Player 1 enter name: ");
        player1 = new Player(s.nextLine());

        System.out.print("Player 2 enter name: ");
        player2 = new Player(s.nextLine());

        System.out.println("");
        
        for (int turnNum = 1; turnNum <= MAX_PLAYER_TURNS; turnNum++) {
            
            player1.getScorecard().getScoreOption(1).setScore(4);
            player1.getScorecard().getScoreOption(1).setPicked(true);
            player1.getScorecard().getScoreOption(2).setScore(6);
            player1.getScorecard().getScoreOption(2).setPicked(true);
            player1.getScorecard().getScoreOption(3).setScore(9);
            player1.getScorecard().getScoreOption(4).setScore(16);
            player1.getScorecard().getScoreOption(5).setScore(10);
            player1.getScorecard().getScoreOption(6).setScore(18);
            
            cup.roll();
            System.out.println("[Turn " + turnNum + " of " + MAX_PLAYER_TURNS + " - " 
                    + player1.getName() + "] " + "Current Scorecard");
            player1.getScorecard().printCurrentScorecard();
            System.out.println("[Turn " + turnNum + " of " + MAX_PLAYER_TURNS + " - " 
                    + player1.getName() + "] " + "Rolled: " + this.getDiceValueAsString());
            player1.getScorecard().printValidOptions();
            System.out.print("[Turn " + turnNum + " of " + MAX_PLAYER_TURNS + " - " 
                    + player1.getName() + "] " + "Choose option: ");
            int p1Option = s.nextInt();
            
            System.out.println("");
            
            cup.roll();
            System.out.println("[Turn " + turnNum + " of " + MAX_PLAYER_TURNS + " - " 
                    + player2.getName() + "] " + "Current Scorecard");
            player2.getScorecard().printCurrentScorecard();
            System.out.println("[Turn " + turnNum + " of " + MAX_PLAYER_TURNS + " - " 
                    + player2.getName() + "] " + "Rolled: " + this.getDiceValueAsString());
            player2.getScorecard().printValidOptions();
            System.out.print("[Turn " + turnNum + " of " + MAX_PLAYER_TURNS + " - " 
                    + player2.getName() + "] " + "Choose option: ");
            int p2Option = s.nextInt();
            
            System.out.println("");
        }

        s.close();
    }

    private String getDiceValueAsString() {
        StringJoiner sj = new StringJoiner(", ");
        for (Die die : cup.getDice()) {
            sj.add(String.valueOf(die.getCurrentVal()));
        }
        return sj.toString();
    }

}
