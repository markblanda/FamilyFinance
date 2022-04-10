package model;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class TransactionTests {
    private TransactionCateogry category;
    private Transaction transaction;
    @Before
    public void init() {
        category = new TransactionCateogry("Rent");
        transaction = new Transaction(LocalDate.now(),"Description", category, 3.5);
    }
    @Test
    public void transactionConstructorHasDateDescriptionCategoryAndValue() {
        category = new TransactionCateogry("Rent");
        transaction = new Transaction(LocalDate.now(),"Description", category, 3.5);
        assertEquals(3.5, transaction.getAmount(),0.1);
        assertEquals("Description", transaction.getDescription());
        assertEquals(category, transaction.getCategory());
        assertEquals(LocalDate.now(), transaction.getTransactionDate());
    }

    @Test
    public void canUpdateTransactionDescription() {
        transaction.setDescription("New Description");
        assertEquals("New Description", transaction.getDescription());
    }

    @Test
    public void newTransactionIsPending() {
        assertEquals(Transaction.ReconcileStatus.PENDING, transaction.getReconcileStatus());
    }
}
