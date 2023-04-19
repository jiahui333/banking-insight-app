package org.example.services;

import org.example.models.Account;
import org.example.models.Footprint;
import org.example.models.Transaction;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface TransactionService {
    void saveTransaction(Transaction transaction, Account account, BigDecimal footprint);
    Optional<Transaction> findTransactionById(Long id);

    List<Transaction> findAllTransactionsByAccount(Account account);

    void deleteTransactionById(Long id);

//    BigDecimal calculateFootprint(Transaction transaction);
}
