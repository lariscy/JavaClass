package homework.proj9;

/**
 * @author Steven Lariscy
 * @projectNumber PL004T
 * @date 3.27.2017
 * @dueDate 3.30.2017
 * @description RPSLS (Rock Paper Scissors Lizard Spock)
 */
public enum RPSLSOption {
    
    ROCK("Rock"),
    PAPER("Paper"),
    SCISSORS("Scissors"),
    SPOCK("Spock"), // re-ordered to work with modulus
    LIZARD("Lizard"),;
    
    // instance variable
    private final String simpleName;
    
    // constructor
    private RPSLSOption(String simpleName){
        this.simpleName = simpleName;
    } // end of constructor

    public String getSimpleName() {
        return simpleName;
    } // end getSimpleName
    
} // end class
