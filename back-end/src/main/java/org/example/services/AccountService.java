package org.example.services;

import org.example.models.Account;
import org.example.models.User;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface AccountService {
    Optional<Account> findAccountById(Long id);

    void saveAccount(Account account, User user);

    void updateAccountBalance(Long id, BigDecimal balance);

    void deleteAccountById(Long id);
    List<Account> findAccountsByUser(User user);

}
