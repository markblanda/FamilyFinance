package model;

import java.util.ArrayList;
import java.util.List;

public class AccountRegister {

    private final AccountType accountType;

    public enum AccountType {CHECKING, SAVINGS}

    private final String accountName;
    private final List<Transaction> transactions;

    public AccountRegister(String accountName, AccountType accountType) {
        this.accountName = accountName;
        this.accountType = accountType;
        transactions = new ArrayList<>();
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public int getTransactionCount() {
        return transactions.size();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public Transaction getTransaction(int index) {
        if (transactions.isEmpty()) {
            throw new AccountEmptyException();
        }
        return transactions.get(index);
    }

    public void deleteTransaction(int index) {
        if (transactions.size()<1) {
            throw new AccountEmptyException();
        }
        transactions.remove(index);
    }

    public String getAccountName() {
        return accountName;
    }

    public static class AccountEmptyException extends RuntimeException {

    }
}
