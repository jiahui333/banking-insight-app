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
import java.util.Objects;

@RestController
@CrossOrigin("http://localhost:3000")
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
        if ((transaction.getFlowType().equals("inflow"))) {
            accountService.updateAccountBalance(transaction);
        }
    }

    @GetMapping("/{transaction_id}")
    public Transaction findTransactionById(@PathVariable("transaction_id") Long transaction_id) {
        return transactionService.findTransactionById(transaction_id).get();
    }

    @GetMapping
    public List<Transaction> findAllTransactionsByAccount() {
        Account currentAccount = accountService.findAccountById(1L).get();
        return transactionService.findAllTransactionsByAccount(currentAccount);
    }

    @DeleteMapping("/{transaction_id}")
    public void deleteTransaction(@PathVariable("transaction_id") Long transaction_id) {
        transactionService.deleteTransactionById(transaction_id);
    }

}
