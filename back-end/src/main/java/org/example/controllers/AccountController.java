package org.example.controllers;
import com.fasterxml.jackson.databind.JsonNode;
import org.example.models.Account;
import org.example.models.Transaction;
import org.example.models.User;
import org.example.services.AccountService;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/accounts")

public class AccountController {

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    @PostMapping("/add")
    public void saveAccount(@RequestBody Account account, Principal principal) {
        System.out.println("Principal: " + principal);
//        System.out.println(("Received account data: " + account.toString()));
        System.out.println("--------- Received account data: " + account);
        User currentUser = userService.findByUsername(principal.getName());
        account.setUser(currentUser);
        System.out.println("---the account id is set to" + account.getId());
        accountService.saveAccount(account);
    }

    @GetMapping("/{account_id}")
    public Account findAccountById (@PathVariable("account_id") Long account_id) {
        return accountService.findAccountById(account_id).get();
    }

    @GetMapping
    public List<Account> findAllAccountsByUser(Principal principal) {
        System.out.println(principal);
        User currentUser = userService.findByUsername(principal.getName());
        return accountService.findAccountsByUser(currentUser);
    }

    @DeleteMapping("/{account_id}")
    public void deleteAccount(@PathVariable("account_id") Long account_id) {
        accountService.deleteAccountById(account_id);
    }


}
