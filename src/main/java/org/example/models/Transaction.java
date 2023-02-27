package org.example.models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "transactions")

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(name = "flow_type", nullable = false)
    private String flowType;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

//    public Transaction() {
//    }

//    public Transaction(BigDecimal amount, String flowType, Category category) {
//
//        this.amount = amount;
//        this.flowType = flowType;
//        this.category = category;
//    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getFlowType() {
        return flowType;
    }

    public Category getCategory() {
        return category;
    }

    public Account getAccount() {
        return account;
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
