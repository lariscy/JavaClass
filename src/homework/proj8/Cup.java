package homework.proj8;

/**
 * @author Steven Lariscy
 */
public class Cup {

    public static final int NUM_OF_DIE = 5;

    private final Die[] dice;

    public Cup() {
        this.dice = new Die[NUM_OF_DIE];
        this.initDice();
    }
    
    private void initDice(){
        for (int i = 0; i < Cup.NUM_OF_DIE; i++) {
            this.dice[i] = new Die();
        }
    }

    public void roll() {
        for (Die die : this.dice) {
            die.roll();
        }
    }

    public Die[] getDice() {
        return dice;
    }

}
