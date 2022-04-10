package model;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class AccountRegisterTests {
    private AccountRegister checking;
    private Transaction mcdonalds;
    private final TransactionCateogry dinning = new TransactionCateogry("Dinning");

    @Before
    public void setup() {
        checking = new AccountRegister("Checking", AccountRegister.AccountType.CHECKING);
        mcdonalds = new Transaction(LocalDate.now(), "McDonald's", dinning, 3.99);
    }

    @Test
    public void newlyCreatedAccountIsEmpty() {
        assertEquals(0, checking.getTransactionCount());
    }

    @Test
    public void newCreatedAccountHasProperties() {
        assertEquals("Checking", checking.getAccountName());
    }

    @Test
    public void newlyCreatedCheckingAccountIsTypeChecking() {
        assertEquals(AccountRegister.AccountType.CHECKING, checking.getAccountType());
    }

    @Test
    public void addTransactionToAccountSizeIsOne() {
        checking.addTransaction(mcdonalds);
        assertEquals(1, checking.getTransactionCount());
    }

    @Test
    public void addTransactionAndGetTransaction() {
        checking.addTransaction(mcdonalds);
        Transaction result = checking.getTransaction(0);
        assertEquals(mcdonalds, result);
        assertSame(mcdonalds, result);
    }

    @Test
    public void addMultipleTransactions_ReturnsTransactions() {
        Transaction burgerKing = new Transaction(LocalDate.now(), "Burger King", dinning, 3.75);
        checking.addTransaction(burgerKing);
        checking.addTransaction(mcdonalds);
        Transaction result = checking.getTransaction(0);
        assertEquals(burgerKing, result);
        result = checking.getTransaction(1);
        assertEquals(mcdonalds, result);
    }

    @Test(expected = AccountRegister.AccountEmptyException.class)
    public void getFromEmptyAccountThrowsAccountEmptyException() {
        checking.getTransaction(0);
    }

    @Test
    public void canDeleteTransactionFromAccountRegister() {
        checking.addTransaction(mcdonalds);
        assertEquals(1,checking.getTransactionCount());
        checking.deleteTransaction(0);
        assertEquals(0, checking.getTransactionCount());
    }

    @Test (expected = AccountRegister.AccountEmptyException.class)
    public void deleteFromEmptyRegisterThrowsException() {
        checking.deleteTransaction(0);
    }
}
