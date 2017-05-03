package homework.proj14;

import javafx.beans.property.SimpleBooleanProperty;

public class ScoreOption {
    
    // instance variables
    private final int id;
    private final String name;
    private final String howToScore;
    private int score;
    private final SimpleBooleanProperty picked;
    //private boolean picked;

    // contructor
    public ScoreOption(int id, String name, String howToScore) {
        this.id = id;
        this.name = name;
        this.howToScore = howToScore;
        this.setScore(0);
        picked = new SimpleBooleanProperty(false);
//        this.setPicked(false);
    } // end of constructor

    public int getId() {
        return this.id;
    } // end of getId
    
    public String getName() {
        return this.name;
    } // end of getName

    public String getHowToScore() {
        return this.howToScore;
    }

    public int getScore() {
        return this.score;
    } // end of getScore

    public final void setScore(int score) {
        this.score = score;
    } // end of setScore

    public boolean isPicked() {
        return this.picked.get();
    } // end of isPicked

    public final void setPicked(boolean picked) {
        this.picked.set(picked);
    } // end of setPicked
    
    public SimpleBooleanProperty pickedProperty(){
        return this.picked;
    }

} // end of class
