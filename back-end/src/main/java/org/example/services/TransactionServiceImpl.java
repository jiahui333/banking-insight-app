package org.example.services;
import org.example.models.Account;
import org.example.models.Category;
import org.example.models.Transaction;
import org.example.repositories.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private TransactionRepo transactionRepo;

    @Override
    public void saveTransaction(Transaction transaction, Account account) {
        transaction.setAccount(account);
        transactionRepo.save(transaction);
    }

    @Override
    public Optional<Transaction> findTransactionById(Long id) {
        return transactionRepo.findById(id);
    }

    @Override
    public List<Transaction> findAllTransactionsByAccount(Account account) {
        return transactionRepo.findAllByAccount(account);
    }

    @Override
    public void deleteTransactionById(Long id) {
        transactionRepo.deleteById(id);
    }
}
