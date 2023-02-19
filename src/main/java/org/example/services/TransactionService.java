package org.example.services;

import org.example.models.Account;
import org.example.models.Transaction;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public interface TransactionService {
    void createTransaction(Account account, BigDecimal amount, String type);

    List<Transaction> listTransactions(Account account);
}
