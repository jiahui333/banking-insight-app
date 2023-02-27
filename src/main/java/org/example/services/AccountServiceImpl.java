package org.example.services;

import org.example.models.Account;
import org.example.models.User;
import org.example.repositories.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Account findAccountByUser(User user) {
        return accountRepo.findByUser(user);
    }

    @Override
    public Optional<Account> findAccountById(Long id) {
        return accountRepo.findById(id);
    }


}
