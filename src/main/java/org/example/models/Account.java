package org.example.models;

import java.math.BigDecimal;

public class Account {
    private String IBAN;

    private final User user;
    private BigDecimal balance = BigDecimal.ZERO;

    public Account(User user, String IBAN) {
        this.user = user;
        this.IBAN = IBAN;
    }

    public User getUser() {
        return user;
    }

    public String getIBAN() {
        return IBAN;
    }

    @Override
    public String toString() {
        return "Account{" +
                "IBAN='" + IBAN + "\'" +
                ", user=" + user.getUsername() +
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
