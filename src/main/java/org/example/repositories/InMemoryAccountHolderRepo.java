package org.example.repositories;

import org.example.models.AccountHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class InMemoryAccountHolderRepo implements AccountHolderRepo{
    private List<AccountHolder> accountHolders = new ArrayList<>();
    @Override
    public void storeAccountHolder(AccountHolder accountHolder) {
        accountHolders.add(accountHolder);
    }

    @Override
    public AccountHolder getAccountHolder(String email) throws NoSuchElementException {
        for (AccountHolder accountHolder : accountHolders) {
            if (accountHolder.getEmail() == email) {
                return accountHolder;
            }
        }
        throw new NoSuchElementException("Cannot find the account holder with this email");
    }
}
