package org.example.repositories;

import org.example.models.Account;
import org.example.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryAccountRepo implements AccountRepo{

    private final List<Account> accounts = new ArrayList<>();


    @Override
    public List<Account> listAccounts(User user) {
        List<Account> accountList = new ArrayList<>();
        for (Account account : accounts) {
            if (account.getUser() == user) {
                accountList.add(account);
            }
        }
        return accountList;
    }

    @Override
    public void storeAccount(Account account) {
        accounts.add(account);
    }

    @Override
    public Account getAccount(String IBAN) {
        Account resultAccount = null;
        for (Account account : accounts) {
            if (account.getIBAN() == IBAN) {
                resultAccount = account;
            }
        }
        return resultAccount;
    }
}
