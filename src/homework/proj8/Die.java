package homework.proj8;

import java.util.Random;

/**
 * @author Steven Lariscy
 * @projectNumber PL004T
 * @date 3.20.2017
 * @dueDate 3.23.2017
 * @description text based Yahtzee game
 */
public class Die {

    // constants
    public static final int MAX_SIDES = 6;

    // instance variables
    private int currentVal;
    private final Random r;

    // contructor
    public Die() {
        this.currentVal = 0;
        this.r = new Random();
    } // end of contructor

    public void roll() {
        this.currentVal = this.r.nextInt(Die.MAX_SIDES) + 1;
    } // end of roll

    public int getCurrentVal() {
        return this.currentVal;
    } // end of getCurrentVal

} // end of class
