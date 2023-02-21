package org.example.models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String IBAN;

    @Column(nullable = false)
    private BigDecimal balance = BigDecimal.ZERO;

    public Account() {
    }

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

//    public BigDecimal getBalance() {
//        return balance;
//    }
//
//    public void setBalance(BigDecimal balance) {
//        this.balance = balance;
//    }

    public void addBalance(BigDecimal balance) {
        this.balance = this.balance.add(balance);
    }

    @Override
    public String toString() {
        return "Account{" +
                "IBAN='" + IBAN + "\'" +
                ", user=" + user.getUsername() +
                ", balance=" + balance +
                '}';
    }


}
