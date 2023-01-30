package org.example;

import org.example.models.Account;
import org.example.models.AccountHolder;
import org.example.repositories.AccountHolderRepo;
import org.example.repositories.AccountRepo;
import org.example.repositories.InMemoryAccountHolderRepo;
import org.example.repositories.InMemoryAccountRepo;
import org.example.services.AccountHolderServiceImpl;
import org.example.services.AccountServiceImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AccountHolderRepo inMemoryAccountHolderRepo = new InMemoryAccountHolderRepo();
        AccountHolderServiceImpl accountHolderService = new AccountHolderServiceImpl(inMemoryAccountHolderRepo);
        accountHolderService.createAccountHolder("Lulu","Lala","lululala@gmail.com");

        AccountRepo inMemoryAccountRepo = new InMemoryAccountRepo();
        AccountServiceImpl accountService = new AccountServiceImpl(inMemoryAccountRepo);
        AccountHolder accountHolder = inMemoryAccountHolderRepo.getAccountHolder("lululala@gmail.com");
        accountService.createAccount(accountHolder,"NL123");
        List<Account> accounts = accountService.listAccounts(accountHolder);
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}