package homework.proj14;

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
        this.setScore(0);
        this.setPicked(false);
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

    public final void setScore(int score) {
        this.score = score;
    } // end of setScore

    public boolean isPicked() {
        return this.picked;
    } // end of isPicked

    public final void setPicked(boolean picked) {
        this.picked = picked;
    } // end of setPicked

} // end of class
