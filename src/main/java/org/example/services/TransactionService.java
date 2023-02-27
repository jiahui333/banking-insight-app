package org.example.services;

import org.example.models.Account;
import org.example.models.Category;
import org.example.models.Transaction;
import org.example.models.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface TransactionService {
    void saveTransaction(Transaction transaction, Account account, Category category);
    Optional<Transaction> findTransactionById(Long id);

    List<Transaction> findAllTransactions(Account account);
}
