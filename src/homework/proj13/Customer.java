package homework.proj13;

/**
 * @author Steven Lariscy
 * @projectNumber PL004T
 * @date 4.21.2017
 * @dueDate 4.27.2017
 * @description Bank Program
 */
public class Customer {
    
    // instance variables
    private final Bank bank;
    private int customerId;
    private String accountNumber;
    private double balance = 0.0D;
    
    // constructor
    public Customer(Bank bank) {
        this.bank = bank;
        this.setCustomerId(this.bank.getUniqueCustomerId());
    } // end constructor
    
    private void setCustomerId(int customerId) {
        this.customerId = customerId;
    } // end setCustomerId

    public int getCustomerId() {
        return this.customerId;
    } // end getCustomerId
    
    private void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    } // end setAccountNumber

    public String getAccountNumber() {
        if (this.accountNumber == null){
            this.setAccountNumber(this.bank.getUniqueAccountNumber());
        } // end if
        return this.accountNumber;
    } // end getAccountNumber

    public double getBalance() {
        return this.balance;
    } // end getBalance

    public void setBalance(double balance) {
        this.balance = balance;
    } // end setBalance
    
} // end class
