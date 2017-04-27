package homework.proj13;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Steven Lariscy
 * @projectNumber PL004T
 * @date 4.21.2017
 * @dueDate 4.27.2017
 * @description Bank Program
 */
public class Bank {
    
    // constants
    public static final Random RANDOM = new Random();
    private static final int MIN_CUSTOMER_ID = 100;
    private static final int MAX_CUSTOMER_ID = 999;
    private static final String VALID_ALPHA_CHARS = 
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final int MIN_INITIAL_DEPOSIT_DOLLARS = 200;
    
    // instance variables
    private final List<Customer> customers;
    private Customer currentCustomer;

    // constructor
    public Bank() {
        this.customers = new ArrayList<>();
    } // end constructor
    
    private int generateCustomerId(){
        return Bank.RANDOM.nextInt(
                (Bank.MAX_CUSTOMER_ID - Bank.MIN_CUSTOMER_ID) + 1) 
                    + Bank.MIN_CUSTOMER_ID;
    } // end generateCustomerId
    
    private String generateAccountNumber(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<2; i++){
            sb.append(Bank.VALID_ALPHA_CHARS.charAt(
                    Bank.RANDOM.nextInt(Bank.VALID_ALPHA_CHARS.length())));
        } // end for
        sb.append(this.generateCustomerId());
        return sb.toString();
    } // end generateAccountNumber
    
    private boolean isCustomerIdValid(int customerId){
        boolean isValid = true;
        for (Customer cust : this.customers){
            if (cust.getCustomerId() == customerId){
                isValid = false;
                break;
            } // end if
        } // end for
        return isValid;
    } // end isCustomerIdValid
    
    private boolean isAccountNumberValid(String accountNumber){
        boolean isValid = true;
        for (Customer cust : this.customers){
            if (cust.getAccountNumber() != null & 
                    cust.getAccountNumber().equals(accountNumber)){
                isValid = false;
                break;
            } // end if
        } // end for
        return isValid;
    } // end isAccountNumberValid
    
    public int getUniqueCustomerId(){
        int custId;
        do { // while (!this.bank.isCustomerIdValid(this.customerId))
            custId = this.generateCustomerId();
        } while (!this.isCustomerIdValid(custId));
        return custId;
    } // end getUniqueCustomerId
    
    public String getUniqueAccountNumber(){
        String actNum;
        do { // while (!this.bank.isAccountNumberValid(this.accountNumber))
            actNum = this.generateAccountNumber();
        } while (!this.isAccountNumberValid(actNum));
        return actNum;
    } // end getUniqueAccountNumber
    
    public void addCustomer(Customer customer){
        this.customers.add(customer);
    } // end addCustomer
    
    public Customer getCustomerById(int customerId){
        Customer retCustomer = null;
        for (Customer cust : this.customers){
            if (cust.getCustomerId() == customerId){
                retCustomer = cust;
                break;
            } // end if
        } // end for
        return retCustomer;
    } // end getCustomerById
    
    public Customer getCurrentCustomer() {
        return this.currentCustomer;
    } // end getCurrentCustomer

    public void setCurrentCustomer(Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
    } // end setCurrentCustomer
    
} // end class
