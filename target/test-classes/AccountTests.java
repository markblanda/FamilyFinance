import model.Account;
import model.Transaction;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class AccountTests {
    private Account checking;
    private Transaction mcdonalds;

    @Before
    public void setup() {
        checking = new Account("Checking", Account.AccountType.CHECKING);
        mcdonalds = new Transaction("McDonald's", 3.99);
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
        assertEquals(Account.AccountType.CHECKING, checking.getAccountType());
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
        Transaction burgerKing = new Transaction("Burger King", 3.75);
        checking.addTransaction(burgerKing);
        checking.addTransaction(mcdonalds);
        Transaction result = checking.getTransaction(0);
        assertEquals(burgerKing, result);
        result = checking.getTransaction(1);
        assertEquals(mcdonalds, result);
    }

    @Test(expected = Account.AccountEmptyException.class)
    public void getFromEmptyAccountThrowsAccountEmptyException() {
        checking.getTransaction(0);
    }
}
