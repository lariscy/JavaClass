package homework.proj8;

import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @author Steven Lariscy
 */
public class GameRunner {

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

        for (int turnNum = 1; turnNum <= 39; turnNum++) {
            
            player1.getScorecard().setOnes(4);
            player1.getScorecard().setTwos(6);
            player1.getScorecard().setThrees(9);
            player1.getScorecard().setFours(16);
            player1.getScorecard().setFives(10);
            player1.getScorecard().setSixes(18);
            
            cup.roll();
            System.out.println("[Turn " + turnNum + " - " + player1.getName() + "] "
                    + "Current Scorecard");
            player1.getScorecard().printScoreCard();
            System.out.println("[Turn " + turnNum + " - " + player1.getName() + "] "
                    + "Rolled: " + this.getDiceValueString());
            System.out.print("[Turn " + turnNum + " - " + player1.getName() + "] "
                    + "Choose option: ");
            s.nextLine();
            
            System.out.println("");
            
            cup.roll();
            System.out.println("[Turn " + turnNum + " - " + player2.getName() + "] "
                    + "Current Scorecard");
            player2.getScorecard().printScoreCard();
            System.out.println("[Turn " + turnNum + " - " + player2.getName() + "] "
                    + "rolled: " + this.getDiceValueString());
            System.out.print("[Turn " + turnNum + " - " + player2.getName() + "] "
                    + "Choose option: ");
            s.nextLine();
            
            System.out.println("");
        }

        s.close();
    }

    private String getDiceValueString() {
        StringJoiner sj = new StringJoiner(", ");
        for (Die die : cup.getDice()) {
            sj.add(String.valueOf(die.getCurrentVal()));
        }
        return sj.toString();
    }

}
