package org.example.models;

import java.math.BigDecimal;

public class Transaction {
    private Account account;
    private BigDecimal amount;
    private String type;
    private Category category;

    public Transaction(Account account, BigDecimal amount, String type, Category category) {
        this.account = account;
        this.amount = amount;
        this.type = type;
        this.category = category;
    }

    public Account getAccount() {
        return account;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "IBAN='" + account.getIBAN() + "'" +
                ", amount=" + amount +
                ", type=" + type +
                '}';
    }
}
