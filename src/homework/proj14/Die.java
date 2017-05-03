package homework.proj14;

import java.util.Random;

/**
 * @author Steven Lariscy
 * @projectNumber PL004T
 * @date 5.3.2017
 * @dueDate 5.4.2017
 * @description Kismet
 */
public class Die {
    
    // constants
    public static final int DEFAULT_NUM_OF_SIDES = 6;
    
    // instance variables
    private int currentValue;
    private final int numberOfSides;
    private final Random random = new Random();
    
    // constructor
    public Die(){
        this(Die.DEFAULT_NUM_OF_SIDES);
    } // end constructor

    // constructor
    public Die(int numberOfSides) {
        this.setCurrentValue(0);
        this.numberOfSides = numberOfSides;
    } // end constructor

    public int getCurrentValue() {
        return this.currentValue;
    } // end getCurrentValue

    private void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    } // end setCurrentValue

    public int getNumberOfSides() {
        return this.numberOfSides;
    } // end getNumberOfSides
    
    public void roll(){
        this.setCurrentValue(this.random.nextInt(this.numberOfSides) + 1);
    } // end roll
    
} // end of class
