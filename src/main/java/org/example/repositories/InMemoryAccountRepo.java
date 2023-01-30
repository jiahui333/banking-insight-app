package org.example.repositories;

import org.example.models.Account;
import org.example.models.AccountHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class InMemoryAccountRepo implements AccountRepo{

    private List<Account> accounts = new ArrayList<>();


    @Override
    public List<Account> listAccounts(AccountHolder accountHolder) {
        List<Account> result = new ArrayList<>();
        for (Account account : accounts) {
            if (account.getAccountHolder() == accountHolder) {
                result.add(account);
            }
        }
        return result;
    }

    @Override
    public void storeAccount(Account account) {
        accounts.add(account);
    }
}
