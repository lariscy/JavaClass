package homework.proj8;

import java.util.Random;

/**
 * @author Steven Lariscy
 */
public class Die {

    public static final int MAX_SIDES = 6;

    private int currentVal;
    private final Random r;

    public Die() {
        this.currentVal = 0;
        this.r = new Random();
    }

    public void roll() {
        this.currentVal = this.r.nextInt(Die.MAX_SIDES) + 1;
        this.currentVal = this.r.nextInt(2) + 1;
    }

    public int getCurrentVal() {
        return currentVal;
    }

}
