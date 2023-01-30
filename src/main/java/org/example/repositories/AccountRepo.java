package org.example.repositories;

import org.example.models.Account;
import org.example.models.AccountHolder;

import java.util.List;

public interface AccountRepo {

    List<Account> listAccounts(AccountHolder accountHolder);

    void storeAccount(Account account);

}
