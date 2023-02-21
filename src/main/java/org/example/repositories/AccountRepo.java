package org.example.repositories;

import org.example.models.Account;
import org.example.models.User;

import java.util.List;

public interface AccountRepo {

    List<Account> listAccounts(User user);

    void storeAccount(Account account);
    Account getAccount(String IBAN);

}
