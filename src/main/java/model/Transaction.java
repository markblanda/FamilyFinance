package model;

import java.time.LocalDate;

public class Transaction {

    public ReconcileStatus getReconcileStatus() {
        return reconcileStatus;
    }

    public enum ReconcileStatus {PENDING, CLEARED, RECONCILED}
    private double amount;
    private String description;
    private TransactionCateogry category;
    private LocalDate transactionDate;
    private ReconcileStatus reconcileStatus = ReconcileStatus.PENDING;

    public Transaction(LocalDate transactionDate, String description, TransactionCateogry category, double amount) {
        this.amount = amount;
        this.description = description;
        this.category = category;
        this.transactionDate = transactionDate;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public TransactionCateogry getCategory() {
        return category;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
