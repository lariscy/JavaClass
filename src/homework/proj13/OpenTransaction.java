package homework.proj13;

/**
 * @author Steven Lariscy
 * @projectNumber PL004T
 * @date 4.21.2017
 * @dueDate 4.27.2017
 * @description Bank Program
 */
public class OpenTransaction extends Transaction {

    @Override
    public boolean doTransaction(Customer customer, double amount) {
        boolean transactionValid = false;
        if (amount >= 200.0D){
            customer.setBalance(amount);
            transactionValid = true;
        } // end if
        return transactionValid;
    } // end doTrnsaction

} // end class
