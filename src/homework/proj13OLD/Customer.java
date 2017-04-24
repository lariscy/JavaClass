package homework.proj13OLD;

/**
 * @author Steven Lariscy
 */
public class Customer {
    
    private final Bank bank;
    private int customerId;
    private String accountNumber;
    private Balance balance;
    
    public static void main(String[] args) {
        Bank bank = new Bank();
        Customer me;
        for(int i=0; i<100; i++){
            me = new Customer(bank);
            bank.addCustomer(me);
            me.setupAccount();
            System.out.println(me.customerId + " : " + me.getAccountNumber());
        }
    }

    public Customer(Bank bank) {
        this.bank = bank;
        this.setCustomerId(this.bank.getUniqueCustomerId());
    }
    
    private void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCustomerId() {
        return this.customerId;
    }
    
    private void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    public void setupAccount(){
        if (this.getAccountNumber() == null){
            this.setAccountNumber(this.bank.getUniqueAccountNumber());
        }
        this.balance = new Balance();
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    @Override
    public String toString() {
        return "Customer{" + "bank=" + bank + ", customerId=" + customerId + ", accountNumber=" + accountNumber + '}';
    }
    
}
