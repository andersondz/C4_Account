package com.misiontic.account_ms.controllers;

import com.misiontic.account_ms.models.Account;
import com.misiontic.account_ms.repositories.AccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//Sirve para que exponga este controlador como api rest
@RestController
public class AccountController {
    private final AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @PostMapping("/accounts")
    Account newAccount(@RequestBody Account account){
        return accountRepository.save(account);
    }

    @GetMapping("/accounts/{username}")
    Optional<Account> getAccount(@PathVariable String username){
        return accountRepository.findById(username);
    }

    @DeleteMapping("/accounts/{username}")
    void deleteAccount(@PathVariable String username){
        accountRepository.deleteById(username);
    }

//    @PutMapping("/accounts/{username}")
//    Account updateAccount(@PathVariable String username, @RequestBody Account new_account){
//        Optional<Account> account = accountRepository.findById(username);
//
//    }
}
