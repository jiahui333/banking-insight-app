package org.example.repositories;

import org.example.models.Account;
import org.example.models.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryTransactionRepo implements TransactionRepo{

    private List<Transaction> transactions = new ArrayList<>();

    @Override
    public void storeTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    @Override
    public List<Transaction> listTransactions(Account account) {
        List<Transaction> transactionList = new ArrayList<>();
        for (Transaction oneTransaction : transactions) {
            if (oneTransaction.getAccount() == account) {
                transactionList.add(oneTransaction);
            }
        }
        return transactionList;
    }
}
