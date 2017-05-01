package homework.proj14.old;

import java.util.Random;

/**
 * @author Steven Lariscy
 */
public class Die {
    
    public static final int DEFAULT_NUM_OF_SIDES = 6;
    
    private int currentValue;
    private final int numberOfSides;
    private final Random random = new Random();
    
    public Die(){
        this(Die.DEFAULT_NUM_OF_SIDES);
    }

    public Die(int numberOfSides) {
        this.setCurrentValue(0);
        this.numberOfSides = numberOfSides;
    }

    public int getCurrentValue() {
        return this.currentValue;
    }

    private void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }

    public int getNumberOfSides() {
        return this.numberOfSides;
    }
    
    public void roll(){
        this.setCurrentValue(this.random.nextInt(this.numberOfSides) + 1);
    }
    
}
