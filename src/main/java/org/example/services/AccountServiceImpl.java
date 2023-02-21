package org.example.services;

import org.example.models.Account;
import org.example.models.User;
import org.example.repositories.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepo accountRepository;

//    public AccountServiceImpl(AccountRepo accountRepository) {
//        this.accountRepository = accountRepository;
//    }

    @Override
    public void createAccount(User user, String IBAN) {
        Account account = new Account(user, IBAN);
        accountRepository.storeAccount(account);
    }

    @Override
    public List<Account> listAccounts(User user) {
        return accountRepository.listAccounts(user);
    }

}
