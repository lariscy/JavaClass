package homework.proj6;

import java.util.Random;

/**
 * @author Steven Lariscy
 */
public class Spinner {

    private int value;
    private final Random r;

    public Spinner() {
        r = new Random();
    }

    private void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public int spin() {
        this.setValue(r.nextInt(6) + 1);
        return this.getValue();
    }

} // end of class
