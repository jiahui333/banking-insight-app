package org.example.services;

import org.example.models.Account;
import org.example.models.AccountHolder;
import org.example.repositories.AccountRepo;
import org.example.repositories.InMemoryAccountRepo;

import java.util.List;

public class AccountServiceImpl implements AccountService {

    AccountRepo accountRepository;

    public AccountServiceImpl(AccountRepo accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void createAccount(AccountHolder accountHolder, String IBAN) {
        Account account = new Account(accountHolder, IBAN);
        accountRepository.storeAccount(account);
    }

    @Override
    public List<Account> listAccounts(AccountHolder accountHolder) {
        return accountRepository.listAccounts(accountHolder);
    }

//    @Override
//    public void sendMoney(String senderIBAN, String receiverIBAN, BigDecimal euro) {
//        Account senderAccount = accountRepository.get(senderIBAN);
//        Account receiverAccount = accountRepository.get(receiverIBAN);
//        senderAccount.sendMoney(receiverAccount, euro);
//    }
}
