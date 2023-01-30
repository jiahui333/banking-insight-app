package org.example.repositories;

import org.example.models.AccountHolder;

public interface AccountHolderRepo {
    //create a new account holder
    void storeAccountHolder(AccountHolder accountHolder);
    //read an account holder
    AccountHolder getAccountHolder(String email);
}
