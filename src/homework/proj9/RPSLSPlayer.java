package homework.proj9;

/**
 * @author Steven Lariscy
 * @projectNumber PL004T
 * @date 3.27.2017
 * @dueDate 3.30.2017
 * @description RPSLS (Rock Paper Scissors Lizard Spock)
 */
public abstract class RPSLSPlayer {
    
    // instance variables
    private String name;
    private int currentPoints;

    // constructor
    public RPSLSPlayer(String name) {
        this.name = name;
    } // end constructor

    public String getName() {
        return this.name;
    } // end getName

    public void setName(String name) {
        this.name = name;
    } // end setName

    public int getCurrentPoints() {
        return this.currentPoints;
    } // end getCurrentPoints

    private void setCurrentPoints(int currentPoints) {
        this.currentPoints = currentPoints;
    } // end setCurrentPoints
    
    public void incrementPoints(){
        this.setCurrentPoints(this.getCurrentPoints() + 1);
    } // end incrementPoints
    
    public abstract RPSLSOption shoot();
    
} // end class
