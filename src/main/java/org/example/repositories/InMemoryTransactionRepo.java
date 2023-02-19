package org.example.repositories;

import org.example.models.Account;
import org.example.models.Transaction;

import java.util.ArrayList;
import java.util.List;

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
