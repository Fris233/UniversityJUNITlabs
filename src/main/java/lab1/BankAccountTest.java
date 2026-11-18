package lab1;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BankAccountTest {

    @Test
    public void withdrawTest() {
        BankAccount bankAccount = new BankAccount(67);
        bankAccount.withdraw(67);
        assertEquals(0, bankAccount.getBalance(), 0.001);
    }

    @Test
    public void depositTest() {
        BankAccount bankAccount = new BankAccount(67);
        bankAccount.deposit(67);
        assertEquals(67+67, bankAccount.getBalance(), 0.001);
    }

    @Test
    public void constructorTest() {
        BankAccount bankAccount = new BankAccount(67);
        assertEquals(67, bankAccount.getBalance(), 0.001);
    }


}
