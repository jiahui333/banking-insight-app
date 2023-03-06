package org.example.services;

import org.example.models.Account;
import org.example.models.Transaction;
import org.example.models.User;
import org.example.repositories.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepo accountRepo;

    @Override
    public void saveAccount(Account account, User user) {
        account.setUser(user);
        accountRepo.save(account);
    }

    @Override
    public void updateAccountBalance(Transaction transaction) {
        Account currentAccount = transaction.getAccount();
        BigDecimal currentBalance = currentAccount.getBalance();
        BigDecimal transactionAmount = transaction.getAmount();
        BigDecimal newBalance = currentBalance.add(transactionAmount);
        currentAccount.setBalance(newBalance);
        accountRepo.save(currentAccount);
    }

    @Override
    public void deleteAccountById(Long id) {
        accountRepo.deleteById(id);
    }

    @Override
    public List<Account> findAccountsByUser(User user) {
        return accountRepo.findAllByUser(user);
    }


    @Override
    public Optional<Account> findAccountById(Long id) {
        return accountRepo.findById(id);
    }

}
