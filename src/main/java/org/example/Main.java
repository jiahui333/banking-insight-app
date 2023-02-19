package org.example;

import org.example.models.Account;
import org.example.models.AccountHolder;
import org.example.models.Transaction;
import org.example.repositories.*;
import org.example.services.*;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Dependency
        AccountHolderRepo inMemoryAccountHolderRepo = new InMemoryAccountHolderRepo();
        //Injection
        AccountHolderService accountHolderService = new AccountHolderServiceImpl(inMemoryAccountHolderRepo);

        accountHolderService.createAccountHolder("Lulu","Lala","lululala@gmail.com");

        //Dependency
        AccountRepo inMemoryAccountRepo = new InMemoryAccountRepo();
        //Injection
        AccountService accountService = new AccountServiceImpl(inMemoryAccountRepo);

        AccountHolder accountHolder = inMemoryAccountHolderRepo.getAccountHolder("lululala@gmail.com");

        accountService.createAccount(accountHolder,"NL123");
        List<Account> accounts = accountService.listAccounts(accountHolder);
        for (Account account : accounts) {
            System.out.println(account);
        }

        //Dependency
        TransactionRepo inMemoryTransactionRepo = new InMemoryTransactionRepo();
        //Injection
        TransactionService transactionService = new TransactionServiceImpl(inMemoryTransactionRepo);

        Account account = inMemoryAccountRepo.getAccount("NL123");
        transactionService.createTransaction(account, BigDecimal.valueOf(6666), "income");
        transactionService.createTransaction(account, BigDecimal.valueOf(8888), "income");
        List<Transaction> transactions = transactionService.listTransactions(account);
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }


        for (Account account1 : accounts) {
            System.out.println(account1);
        }


    }
}