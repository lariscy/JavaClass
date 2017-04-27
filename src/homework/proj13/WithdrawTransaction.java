package homework.proj13;

/**
 * @author Steven Lariscy
 * @projectNumber PL004T
 * @date 4.21.2017
 * @dueDate 4.27.2017
 * @description Bank Program
 */
public class WithdrawTransaction extends Transaction {

    @Override
    public boolean doTransaction(Customer customer, double amount) {
        boolean transactionValid = false;
        double currentBalance = customer.getBalance();
        if (currentBalance - amount > 0){
            customer.setBalance(customer.getBalance() - amount);
            transactionValid = true;
        } // end if
        return transactionValid;
    } // end doTransaction
    
} // end class
