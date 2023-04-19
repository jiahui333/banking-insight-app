package org.example.services;
import org.example.models.*;
import org.example.repositories.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private TransactionRepo transactionRepo;

    @Override
    public void saveTransaction(Transaction transaction, Account account, BigDecimal footprint) {
        // when saving the transaction, I want to save the footprint, so I need the footprint here.
        transaction.setAccount(account);
        transaction.setFootprint(footprint);
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

//    @Override
//    public BigDecimal calculateFootprint(Transaction transaction) {
//        Map<String, Long> footprintVariables= FootprintVariableConstants.getFootprintVariableConstants();
//        for (Map.Entry<String, Long> entry : footprintVariables.entrySet()) {
//            if (Objects.equals(entry.getKey(), transaction.getCategory().getName())) {
//                footprintVariable = entry.getValue();
//            }
//        }
//        return transaction.getAmount().multiply(BigDecimal.valueOf(footprintVariable));
//    }
}
