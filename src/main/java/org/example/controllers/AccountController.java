package org.example.controllers;
import org.example.models.Account;
import org.example.models.User;
import org.example.services.AccountService;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/accounts")

public class AccountController {

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    @PostMapping
    public void saveAccount(@RequestBody Account account) {
        User currentUser = userService.findUserById(1L).get();
        accountService.saveAccount(account, currentUser);
    }

    @GetMapping("/{account_id}")
    public Optional<Account> findAccountById (@PathVariable("account_id") Long account_id) {
        return accountService.findAccountById(account_id);
    }

}
