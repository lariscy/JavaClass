package homework.proj13;

/**
 * @author Steven Lariscy
 * @projectNumber PL004T
 * @date 4.21.2017
 * @dueDate 4.27.2017
 * @description Bank Program
 */
public enum TransactionType {
    
    WITHDRAW("Withdraw"), 
    OPEN("Open"), 
    DEPOSIT("Deposit"), 
    QUIT("Quit"), 
    SHOW_BALANCE("Show Balance");
    
    // instance variables
    private final String simpleName;

    // constructor
    private TransactionType(String simpleName) {
        this.simpleName = simpleName;
    } // end constructor

    public String getSimpleName() {
        return simpleName;
    } // end getSimpleName
    
} // end enum
