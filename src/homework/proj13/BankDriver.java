package homework.proj13;

import java.util.Scanner;

/**
 * @author Steven Lariscy
 * @projectNumber PL004T
 * @date 4.21.2017
 * @dueDate 4.27.2017
 * @description Bank Program
 */
public class BankDriver {
    
    // instance variables
    private final Bank bank;
    private final Input input;

    // constructor
    public BankDriver(Input input) {
        this.bank = new Bank();
        this.input = input;
    } // end constructor
    
    public static void main(String[] args) {
        BankDriver driver = new BankDriver(new Input(new Scanner(System.in)));
        driver.run();
        driver.input.getScanner().close();
    } // end main

    private void run() {
        Output.showWelcome();
        
        TransactionType option;
        do { // while (option != TransactionType.QUIT)
            Output.showOptions();
            option = this.input.getMenuOption();
            switch(option){
                case CREATE_ACCOUNT:
                    Customer customer = new Customer(this.bank);
                    this.bank.addCustomer(customer);
                    Output.showCustomerInfo(customer);
                    break;
                case OPEN:
                    Output.showEnterCustomerIdPrompt();
                    String custIdEntered = this.input.getUserInput();
                    if (custIdEntered != null){
                        customer = this.bank.getCustomerById(Integer.parseInt(custIdEntered));
                        this.bank.setCurrentCustomer(customer);
                        Output.showOpenAmountPrompt();
                        double openAccountAmount = Double.parseDouble(input.getUserInput());
                        OpenTransaction openTrans = new OpenTransaction();
                        if (openTrans.doTransaction(customer, openAccountAmount)){
                            System.out.println("Amount valid. Opened account #"+customer.getAccountNumber());
                        } else { // end if
                            System.out.println("Invalid amount. Try again");
                        } // end else
                    } // end if
                    break;
                case SHOW_BALANCE:
                    if (this.bank.getCurrentCustomer() != null){
                        Output.showCustomerBalance(this.bank.getCurrentCustomer());
                    } else { // end if
                        System.out.println("Error: Need to login first!");
                    } // end else
                    break;
                case DEPOSIT:
                    if (this.bank.getCurrentCustomer() != null){
                        Output.showDepositPrompt();
                        Double depositAmount = Double.parseDouble(this.input.getUserInput());
                        DepositTransaction depositTransaction = new DepositTransaction();
                        if (depositTransaction.doTransaction(this.bank.getCurrentCustomer(), depositAmount)){
                            System.out.println("Transaction successful");
                        } else { // end if
                            System.out.println("Transaction error. Try again");
                        } // end else
                    } else { // end if
                        System.out.println("Error: Need to login first!");
                    } // end else
                    break;
                case WITHDRAW:
                    if (this.bank.getCurrentCustomer() != null){
                        Output.showWithdrawPrompt();
                        Double withdrawAmount = Double.parseDouble(this.input.getUserInput());
                        Transaction withdrawTransaction = new WithdrawTransaction();
                        if (withdrawTransaction.doTransaction(this.bank.getCurrentCustomer(), withdrawAmount)){
                            System.out.println("Transaction successful");
                        } else { // end if
                            System.out.println("Error: Need to login first!");
                        } // end else
                    } else { // end if
                        System.out.println("Error: Need to login first!");
                    } // end else
                    break;
                case QUIT:
                default:
                        // will just exit do loop and exit program
            } // end switch
        } while (option != TransactionType.QUIT);
    } // end run
    
} // end class
