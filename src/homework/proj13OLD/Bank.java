package homework.proj13OLD;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Steven Lariscy
 */
public class Bank {
    
    public static final Random RANDOM = new Random();
    private static final int MIN_CUSTOMER_ID = 100;
    private static final int MAX_CUSTOMER_ID = 999;
    private static final String VALID_ALPHA_CHARS = 
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final int MIN_INITIAL_DEPOSIT_DOLLARS = 200;
    
    private final List<Customer> customers;

    public Bank() {
        this.customers = new ArrayList<>();
    }
    
    private int generateCustomerId(){
        return Bank.RANDOM.nextInt(
                (Bank.MAX_CUSTOMER_ID - Bank.MIN_CUSTOMER_ID) + 1) 
                    + Bank.MIN_CUSTOMER_ID;
    }
    
    private String generateAccountNumber(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<2; i++){
            sb.append(Bank.VALID_ALPHA_CHARS.charAt(
                    Bank.RANDOM.nextInt(Bank.VALID_ALPHA_CHARS.length())));
        }
        sb.append(this.generateCustomerId());
        return sb.toString();
    }
    
    private boolean isCustomerIdValid(int customerId){
        boolean isValid = true;
        for (Customer cust : this.customers){
            if (cust.getCustomerId() == customerId){
                isValid = false;
                break;
            }
        }
        return isValid;
    }
    
    private boolean isAccountNumberValid(String accountNumber){
        boolean isValid = true;
        for (Customer cust : this.customers){
            if (cust.getAccountNumber() != null && 
                    cust.getAccountNumber().equals(accountNumber)){
                isValid = false;
                break;
            }
        }
        return isValid;
    }
    
    public int getUniqueCustomerId(){
        int custId;
        do { // while (!this.bank.isCustomerIdValid(this.customerId))
            custId = this.generateCustomerId();
        } while (!this.isCustomerIdValid(custId));
        return custId;
    }
    
    public String getUniqueAccountNumber(){
        String actNum;
        do { // while (!this.bank.isAccountNumberValid(this.accountNumber))
            actNum = this.generateAccountNumber();
        } while (!this.isAccountNumberValid(actNum));
        return actNum;
    }
    
    public void addCustomer(Customer customer){
        this.customers.add(customer);
    }
    
}
