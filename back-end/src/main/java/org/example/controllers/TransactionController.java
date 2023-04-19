package org.example.controllers;

import org.example.models.Account;
import org.example.models.Category;
import org.example.models.Footprint;
import org.example.models.Transaction;
import org.example.repositories.TransactionRepo;
import org.example.services.AccountService;
import org.example.services.CategoryService;
import org.example.services.FootprintService;
import org.example.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/accounts/{account_id}/transactions")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @Autowired
    AccountService accountService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    FootprintService footprintService;

    @PostMapping
    public void saveTransaction(@PathVariable("account_id") Long account_id, @RequestBody Transaction transaction) {
        Account currentAccount = accountService.findAccountById(account_id).get();
        BigDecimal currentFootprint = footprintService.saveAndReturnFootprintPerTrans(transaction);
        transactionService.saveTransaction(transaction, currentAccount,currentFootprint);
        accountService.updateBalanceWhenAdd(currentAccount, transaction);
    }

    @GetMapping("/{transaction_id}")
    public Transaction findTransactionById(@PathVariable("transaction_id") Long transaction_id) {
        return transactionService.findTransactionById(transaction_id).get();
        // add orElseThrow()
    }

    @GetMapping
    public List<Transaction> findAllTransactionsByAccount(@PathVariable("account_id") Long account_id) {
        Account currentAccount = accountService.findAccountById(account_id).get();
        return transactionService.findAllTransactionsByAccount(currentAccount);
    }

    @DeleteMapping("/{transaction_id}")
    public void deleteTransaction(@PathVariable("account_id") Long account_id, @PathVariable("transaction_id") Long transaction_id) {
        Account currentAccount = accountService.findAccountById(account_id).get();
        Transaction currentTransaction = transactionService.findTransactionById(transaction_id).get();
        transactionService.deleteTransactionById(transaction_id);
        accountService.updateBalanceWhenDelete(currentAccount, currentTransaction);
    }

}
