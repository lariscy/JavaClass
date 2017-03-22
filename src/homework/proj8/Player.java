package homework.proj8;

/**
 * @author Steven Lariscy
 * @projectNumber PL004T
 * @date 3.20.2017
 * @dueDate 3.23.2017
 * @description text based Yahtzee game
 */
public class Player {

    // instance variables
    private final String name;
    private final Scorecard scorecard;

    // constructor
    public Player(String name) {
        this.name = name;
        this.scorecard = new Scorecard();
    } // end of constructor

    public String getName() {
        return this.name;
    } // end of getName

    public Scorecard getScorecard() {
        return this.scorecard;
    } // end of getScorecard

} // end of class
