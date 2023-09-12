package org.example.services;

import org.example.models.Account;
import org.example.models.Transaction;
import org.example.models.User;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface AccountService {
    Optional<Account> findAccountById(Long id);

    void saveAccount(Account account);

    void deleteAccountById(Long id);
    List<Account> findAccountsByUser(User user);

    Long findMaxAccountId();

    void updateBalanceWhenAdd(Account account, Transaction transaction);

    void updateBalanceWhenDelete(Account account, Transaction transaction);

}
