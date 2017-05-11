package homework.proj13;

/**
 * @author Steven Lariscy
 */
public class TestLogger {
    
    public static void main(String[] args) {
        Logger.getInstance().log("Starting Bank Program");
        Logger.getInstance().log("Showing Welcome Message");
        Logger.getInstance().log("Initializing Menu");
        Logger.getInstance().log("Selected: CREATE_ACCOUNT");
        Logger.getInstance().log("Initializing Menu");
        Logger.getInstance().log("Selected: OPEN");
        Logger.getInstance().log("Asking customer for initial deposit");
        Logger.getInstance().log("Amount given: 200");
        Logger.getInstance().log("Amount valid. Opening account");
        Logger.getInstance().log("Initializing Menu");
        Logger.getInstance().log("Selected: SHOW_BALANCE");
        Logger.getInstance().log("Balance: $200.00");
        Logger.getInstance().log("Initializing Menu");
        Logger.getInstance().log("Selected: QUIT");
        Logger.getInstance().log("Ending Bank Program");
        Logger.getInstance().closeLogger();
    }
    
}
