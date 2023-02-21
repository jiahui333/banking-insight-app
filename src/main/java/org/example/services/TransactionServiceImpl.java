package org.example.services;


import org.example.models.Account;
import org.example.models.Category;
import org.example.models.Transaction;
import org.example.repositories.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class TransactionServiceImpl implements TransactionService{

    private final TransactionRepo transactionRepository;

    public TransactionServiceImpl(TransactionRepo transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
    @Override
    public void createTransaction (Account account, BigDecimal amount, String type, Category category) {
        Transaction newTransaction = new Transaction(account, amount, type, category);
        transactionRepository.storeTransaction(newTransaction);
        if (Objects.equals(type, "income")) {
            account.addBalance(amount);
        }
    }

    @Override
    public List<Transaction> listTransactions(Account account) {
        return transactionRepository.listTransactions(account);
    }
}
