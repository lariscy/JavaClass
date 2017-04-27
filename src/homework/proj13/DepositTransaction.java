package homework.proj13;

/**
 * @author Steven Lariscy
 * @projectNumber PL004T
 * @date 4.21.2017
 * @dueDate 4.27.2017
 * @description Bank Program
 */
public class DepositTransaction extends Transaction {

    @Override
    public boolean doTransaction(Customer customer, double amount) {
        customer.setBalance(customer.getBalance() + amount);
        return true;
    } // end doTransaction
    
} // end class
