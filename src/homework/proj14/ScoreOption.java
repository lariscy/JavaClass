package homework.proj14;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * @author Steven Lariscy
 * @projectNumber PL004T
 * @date 5.3.2017
 * @dueDate 5.4.2017
 * @description Kismet
 */
public class ScoreOption {
    
    // instance variables
    private final int id;
    private final String name;
    private final String howToScore;
    private final SimpleIntegerProperty score = new SimpleIntegerProperty();
    private boolean picked;

    // contructor
    public ScoreOption(int id, String name, String howToScore) {
        this(id, name, howToScore, false);
    } // end constructor

    // contructor
    public ScoreOption(int id, String name, String howToScore, boolean picked) {
        this.id = id;
        this.name = name;
        this.howToScore = howToScore;
        this.setScore(0);
        this.setPicked(picked);
    } // end constructor

    public int getId() {
        return this.id;
    } // end getId
    
    public String getName() {
        return this.name;
    } // end getName

    public String getHowToScore() {
        return this.howToScore;
    } // end getHowToScore

    public int getScore() {
        return this.score.get();
    } // end getScore

    public final void setScore(int score) {
        this.score.set(score);
    } // end setScore

    public boolean isPicked() {
        return this.picked;
    } // end isPicked

    public final void setPicked(boolean picked) {
        this.picked = picked;
    } // end setPicked
    
    public SimpleIntegerProperty scoreProperty(){
        return this.score;
    } // end scoreProperty

} // end class
