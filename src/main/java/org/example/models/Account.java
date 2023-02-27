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
    private String iban;

    @Column(nullable = false)
    private BigDecimal balance = BigDecimal.ZERO;

    public Account() {
    }

    public Account(String iban, BigDecimal balance) {
        this.iban = iban;
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public String getIban() {
        return iban;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setUser(User user) {
    this.user = user;
}

//    public void addBalance(BigDecimal balance) {
//        this.balance = this.balance.add(balance);
//    }

    @Override
    public String toString() {
        return "Account{" +
                "IBAN='" + iban + "\'" +
                ", user=" + user.getUsername() +
                ", balance=" + balance +
                '}';
    }


}
