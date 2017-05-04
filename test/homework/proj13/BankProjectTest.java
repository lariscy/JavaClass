package homework.proj13;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author Steven Lariscy
 */
public class BankProjectTest {
    
    @Test
    public void testBaseline(){
        assertTrue("baseline true test", true);
    }
    
    @Test
    public void testNumberOfTransactionTypes(){
        assertEquals("number of TransactionTypes is 6", 6, TransactionType.values().length);
    }
    
    @Test
    public void testMinimumAccountStartingBalance(){
        assertEquals("ensure minimum starting balance is 200", 200, Bank.MIN_INITIAL_DEPOSIT_DOLLARS);
    }
    
    @Test
    public void testMenuOption1() {
        assertEquals("test menu option 1 returns TransactionType.CREATE_ACCOUNT",
                TransactionType.CREATE_ACCOUNT, TransactionType.values()[0]);
    }
    
    @Test
    public void testMenuOption2() {
        assertEquals("test menu option 2 returns TransactionType.OPEN",
                TransactionType.OPEN, TransactionType.values()[1]);
    }
    
    @Test
    public void testMenuOption3() {
        assertEquals("test menu option 2 returns TransactionType.OPEN",
                TransactionType.WITHDRAW, TransactionType.values()[2]);
    }
    
    @Test
    public void testMenuOption4() {
        assertEquals("test menu option 2 returns TransactionType.OPEN",
                TransactionType.DEPOSIT, TransactionType.values()[3]);
    }
    
    @Test
    public void testMenuOption5() {
        assertEquals("test menu option 2 returns TransactionType.OPEN",
                TransactionType.SHOW_BALANCE, TransactionType.values()[4]);
    }
    
    @Test
    public void testMenuOption6() {
        assertEquals("test menu option 2 returns TransactionType.OPEN",
                TransactionType.QUIT, TransactionType.values()[5]);
    }
    
    @Test
    public void testInitialCurrentCustomerIsNull(){
        assertNull("verify no initial customer is set when bank is created", 
                new Bank().getCurrentCustomer());
    }
    
    @Test
    public void testCustomerRemainsSame(){
        Bank bank = new Bank();
        Customer customer1 = new Customer(bank);
        bank.setCurrentCustomer(customer1);
        assertSame("verify customer returned is the same", customer1, 
                bank.getCurrentCustomer());
    }
    
}
