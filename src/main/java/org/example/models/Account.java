package org.example.models;

import java.math.BigDecimal;

public class Account {
    private String IBAN;

    private final AccountHolder accountHolder;
    private BigDecimal balance = BigDecimal.ZERO;

    public Account(AccountHolder accountHolder, String IBAN) {
        this.accountHolder = accountHolder;
        this.IBAN = IBAN;
    }

    public AccountHolder getAccountHolder() {
        return accountHolder;
    }

    public String getIBAN() {
        return IBAN;
    }

    @Override
    public String toString() {
        return "Account{" +
                "IBAN='" + IBAN + "\'" +
                ", accountHolder=" + accountHolder.getEmail() +
                ", balance=" + balance +
                '}';
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void addBalance(BigDecimal balance) {
        this.balance = this.balance.add(balance);
    }


}
