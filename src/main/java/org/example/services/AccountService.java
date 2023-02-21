package org.example.services;

import org.example.models.Account;
import org.example.models.User;

import java.util.List;

public interface AccountService {
    void createAccount(User user, String IBAN);

    //list
    List<Account> listAccounts(User user);
}
