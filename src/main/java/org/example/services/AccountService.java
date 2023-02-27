package org.example.services;

import org.example.models.Account;
import org.example.models.User;

import java.util.Optional;

public interface AccountService {
    Optional<Account> findAccountById(Long id);
    void saveAccount(Account account, User user);

    Account findAccountByUser(User user);
}
