package homework.proj8;

/**
 * @author Steven Lariscy
 * @projectNumber PL004T
 * @date 3.20.2017
 * @dueDate 3.23.2017
 * @description text based Yahtzee game
 */
public class Cup {

    // constants
    public static final int NUM_OF_DIE = 5;

    // instance variables
    private final Die[] dice;

    // constructor
    public Cup() {
        this.dice = new Die[NUM_OF_DIE];
        this.initDice();
    } // end of constructor
    
    private void initDice(){
        for (int i = 0; i < Cup.NUM_OF_DIE; i++) {
            this.dice[i] = new Die();
        }
    } // end of initDice

    public void roll() {
        for (Die die : this.dice) {
            die.roll();
        }
    } // end of roll

    public Die[] getDice() {
        return this.dice;
    } // end of getDice
    
    public int getDiceTotal(){
        int total = 0;
        for (Die die : this.getDice()){
            total += die.getCurrentVal();
        }
        return total;
    } // end of getDiceTotal

} // end class
