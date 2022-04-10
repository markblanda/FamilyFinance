package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class TransactionCategoryTests {
    @Test
    public void canSetTransactionCategoryName() {
        TransactionCateogry rent = new TransactionCateogry("Rent");
        assertEquals("Rent", rent.getCategoryTitle());
        assertEquals("Rent", rent.toString());
    }
}
