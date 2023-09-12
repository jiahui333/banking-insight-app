package org.example.services;

import org.example.models.Account;
import org.example.models.Transaction;
import org.example.models.User;
import org.example.repositories.AccountRepo;
import org.example.repositories.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepo accountRepo;

    private BigDecimal updatedBalance;

    private BigDecimal accountBalance;
    private BigDecimal transactionAmount;

    @Override
    public void saveAccount(Account account) {
        accountRepo.save(account);
    }

    @Override
    public void deleteAccountById(Long id) {
        accountRepo.deleteById(id);
    }

    @Override
    public List<Account> findAccountsByUser(User user) {
        return accountRepo.findAllByUser(user);
    }

    @Override
    public Long findMaxAccountId() {
        return accountRepo.findMaxAccountId();
    }


    @Override
    public Optional<Account> findAccountById(Long id) {
        return accountRepo.findById(id);
    }

    @Override
    public void updateBalanceWhenAdd(Account account, Transaction transaction) {
        //get account balance
        accountBalance = account.getBalance();
        //get transaction amount
        transactionAmount = transaction.getAmount();
        //add amount to balance
        if (Objects.equals(transaction.getFlowType(), "inflow")) {
            updatedBalance = accountBalance.add(transactionAmount);
        } else {
            updatedBalance = accountBalance.subtract(transactionAmount);
        }
        account.setBalance(updatedBalance);
        accountRepo.save(account);
    }

    @Override
    public void updateBalanceWhenDelete(Account account, Transaction transaction) {
        //get account balance
        accountBalance = account.getBalance();
        //get transaction amount
        transactionAmount = transaction.getAmount();
        //add amount to balance
        if (Objects.equals(transaction.getFlowType(), "inflow")) {
            updatedBalance = accountBalance.subtract(transactionAmount);
        } else if (Objects.equals(transaction.getFlowType(), "outflow")){
            updatedBalance = accountBalance.add(transactionAmount);
        }
        account.setBalance(updatedBalance);
        accountRepo.save(account);
    }
}

