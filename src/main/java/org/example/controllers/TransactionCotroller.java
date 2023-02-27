package org.example.controllers;

import org.example.models.Account;
import org.example.models.Category;
import org.example.models.Transaction;
import org.example.services.AccountService;
import org.example.services.CategoryService;
import org.example.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionCotroller {

    @Autowired
    TransactionService transactionService;

    @Autowired
    AccountService accountService;

    @Autowired
    CategoryService categoryService;

    @PostMapping
    public void saveTransaction(@RequestBody Transaction transaction) {
        Account currentAccount = accountService.findAccountById(1L).get();
        Category selectedCategory = categoryService.findCategoryById(1L).get();
        transactionService.saveTransaction(transaction,currentAccount,selectedCategory);
    }

    @GetMapping("/{transaction_id}")
    public Transaction transaction(@PathVariable("transaction_id") Long transaction_id) {
        return transactionService.findTransactionById(transaction_id).get();
    }

    @GetMapping("/all")
    public List<Transaction> transactionList() {
        Account currentAccount = accountService.findAccountById(1L).get();
        return transactionService.findAllTransactions(currentAccount);
    }

}
