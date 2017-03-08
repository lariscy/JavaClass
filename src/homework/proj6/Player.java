package homework.proj6;

/**
 * @author Steven Lariscy
 */
public class Player {

    private String name;
    private int currentSquareNumber;
    private static final int STARTING_SQUARE = 0;

    public Player(String name) {
        this.setName(name);
        this.setCurrentSquareNumber(STARTING_SQUARE);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentSquareNumber() {
        return currentSquareNumber;
    }

    private void setCurrentSquareNumber(int currentSquareNumber) {
        this.currentSquareNumber = currentSquareNumber;
    }
    
    public void updateCurrentSquareNumber(int currentSquareNumber){
        this.setCurrentSquareNumber(currentSquareNumber);
    }

} // end of class
