package org.example.services;

import org.example.models.AccountHolder;
import org.example.repositories.AccountHolderRepo;
import org.example.repositories.InMemoryAccountHolderRepo;

public class AccountHolderServiceImpl implements AccountHolderService{
    AccountHolderRepo accountHolderRepo;

    public AccountHolderServiceImpl(AccountHolderRepo accountHolderRepo) {
        this.accountHolderRepo = accountHolderRepo;
    }


    @Override
    public void createAccountHolder(String firstName, String secondName, String email) {
        AccountHolder accountHolder = new AccountHolder(firstName, secondName, email);
        accountHolderRepo.storeAccountHolder(accountHolder);
    }
}
