package homework.proj13;

/**
 * @author Steven Lariscy
 * @projectNumber PL004T
 * @date 4.21.2017
 * @dueDate 4.27.2017
 * @description Bank Program
 */
public class Output {
    
    public static void showWelcome(){
        System.out.println("");
        System.out.println("Welcome to Bank App!");
        System.out.println("");
    } // end showWelcome
    
    public static void showOptions(){
        System.out.println("Menu Options: ");
        for (TransactionType type : TransactionType.values()){
            System.out.println(type.ordinal()+") "+type.name());
        } // end for
        System.out.print("Option: ");
    } // end showOptions
    
    public static void showCustomerInfo(Customer customer){
        System.out.println("-Customer Info-");
        System.out.println("Customer ID: "+customer.getCustomerId());
    } // end showCustomerInfo
    
    public static void showEnterCustomerIdPrompt(){
        System.out.print("Enter customer id: ");
    } // end showEnterCustomerIdPrompt
    
    public static void showOpenAmountPrompt(){
        System.out.println("Initial deposit amount: ");
    } // end showOpenAmountPrompt
    
    public static void showDepositPrompt(){
        System.out.println("Amount to deposit: ");
    } // end showDepositPrompt
    
    public static void showWithdrawPrompt(){
        System.out.println("Amount to withdraw: ");
    } // end showWithdrawPrompt
    
    public static void showCustomerBalance(Customer customer){
        System.out.println("Current balance: "+customer.getBalance());
    } // end showCustomerBalance
    
} // end class
