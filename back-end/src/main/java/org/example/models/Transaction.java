package org.example.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "transactions")

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Account account;

    @Column
    private String receiver;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(name = "flow_type", nullable = false)
    private String flowType;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column
    private LocalDate localDate = LocalDate.now();

    public BigDecimal getAmount() {
        return amount;
    }

    public String getFlowType() {
        return flowType;
    }

    public String getReceiver() {
        return receiver;
    }

    public Category getCategory() {
        return category;
    }

    public Account getAccount() {
        return account;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "IBAN='" + account.getIban() + "'" +
                ", amount=" + amount +
                ", type=" + flowType +
                '}';
    }
}
