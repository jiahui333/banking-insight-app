package org.example.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String iban;

    @Column(nullable = false)
    private BigDecimal balance = BigDecimal.ZERO;

    public Long getId() {
        return id;
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
    this.user = user;
}

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

//    @Override
//    public String toString() {
//        System.out.println("Value of someVariable: " + iban + user + balance);
//        return "Account{" +
//                "IBAN='" + iban + "\'" +
//                ", user=" + user.getUsername() +
//                ", balance=" + balance +
//                '}';
//    }


}
