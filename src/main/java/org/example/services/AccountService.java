package org.example.services;

import org.example.models.Account;
import org.example.models.AccountHolder;

import java.math.BigDecimal;
import java.util.List;

public interface AccountService {
    void createAccount(AccountHolder accountholder, String IBAN);

    //list
    List<Account> listAccounts(AccountHolder accountHolder);
}
