package homework.proj13;

/**
 * @author Steven Lariscy
 * @projectNumber PL004T
 * @date 4.21.2017
 * @dueDate 4.27.2017
 * @description Bank Program
 */
public abstract class Transaction implements TransactionInterface {

    @Override
    public abstract boolean doTransaction(Customer customer, double amount);
    
} // end class
