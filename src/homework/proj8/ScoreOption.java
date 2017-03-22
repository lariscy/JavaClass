package homework.proj8;

/**
 * @author Steven Lariscy
 * @projectNumber PL004T
 * @date 3.20.2017
 * @dueDate 3.23.2017
 * @description text based Yahtzee game
 */
public class ScoreOption {
    
    // instance variables
    private final String name;
    private final int id;
    private int score;
    private boolean picked;

    // contructor
    public ScoreOption(int id, String name) {
        this.id = id;
        this.name = name;
        this.score = 0;
        this.picked = false;
    } // end of constructor

    public String getName() {
        return this.name;
    } // end of getName

    public int getId() {
        return this.id;
    } // end of getId

    public int getScore() {
        return this.score;
    } // end of getScore

    public void setScore(int score) {
        this.score = score;
    } // end of setScore

    public boolean isPicked() {
        return this.picked;
    } // end of isPicked

    public void setPicked(boolean picked) {
        this.picked = picked;
    } // end of setPicked

} // end of class
