package homework.proj9;

/**
 * @author Steven Lariscy
 * @projectNumber PL004T
 * @date 3.27.2017
 * @dueDate 3.30.2017
 * @description RPSLS (Rock Paper Scissors Lizard Spock)
 */
public enum RPSLSGameType {
    
    HUMAN_VS_HUMAN("Human vs. Human"),
    HUMAN_VS_COMPUTER("Human vs. Computer"),
    COMPUTER_VS_COMPUTER("Computer vs. Computer");
    
    // instance variable
    private final String simpleName;

    // constructor
    private RPSLSGameType(String simpleName) {
        this.simpleName = simpleName;
    } // end of constructor

    public String getSimpleName() {
        return this.simpleName;
    } // end of getSimpleName
    
} // end of class
