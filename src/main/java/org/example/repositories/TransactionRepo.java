package org.example.repositories;

import org.example.models.Account;
import org.example.models.Transaction;

import java.util.List;

public interface TransactionRepo {

    List<Transaction> listTransactions(Account account);
    void storeTransaction(Transaction transaction);

}
