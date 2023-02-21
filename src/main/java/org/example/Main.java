package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

//        User lulu = new User("lulu", "lala", "luuu", "123");
//        System.out.println(lulu.getUsername());

    }

}

//
////        //Dependency
//        UserRepo inMemoryAccountHolderRepo = new InMemoryUserRepo();
////        //Injection
//        UserService accountHolderService = context.getBean(UserService.class);
//
//        accountHolderService.createAccountHolder("Lulu","Lala","lululala@gmail.com");
//
//        //Dependency
//        AccountRepo inMemoryAccountRepo = new InMemoryAccountRepo();
//        //Injection
//        AccountService accountService = new AccountServiceImpl();
//
//        User accountHolder = inMemoryAccountHolderRepo.getAccountHolder("lululala@gmail.com");
//
//        accountService.createAccount(accountHolder,"NL123");
//        List<Account> accounts = accountService.listAccounts(accountHolder);
//        for (Account account : accounts) {
//            System.out.println(account);
//        }
//
//        //Dependency
//        TransactionRepo inMemoryTransactionRepo = new InMemoryTransactionRepo();
//        //Injection
//        TransactionService transactionService = new TransactionServiceImpl(inMemoryTransactionRepo);
//        Category category1 = new Category("Grocery");
//        Category category2 = new Category("Health");
//        Account account = inMemoryAccountRepo.getAccount("NL123");
//        transactionService.createTransaction(account, BigDecimal.valueOf(6666), "income", category1);
//        transactionService.createTransaction(account, BigDecimal.valueOf(8888), "income", category2);
//        List<Transaction> transactions = transactionService.listTransactions(account);
//        for (Transaction transaction : transactions) {
//            System.out.println(transaction);
//        }
//
//
//        for (Account account1 : accounts) {
//            System.out.println(account1);
//        }
//
//
//    }
