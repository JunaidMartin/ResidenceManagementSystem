package com.systemsmart.controller;

import com.systemsmart.entity.Account;
import com.systemsmart.factory.AccountFactory;
import com.systemsmart.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountServiceImpl accountService;

    @PostMapping("/create")
    public Account create(@RequestBody Account account){
        Account newAccount = AccountFactory.buildAccount(account.getAccountId(), account.getStatementType(), account.getDebitAmount(),
                account.getCreditAmount(), account.getBalanceAmount(), account.getBalanceDate());
        return accountService.create(newAccount);
    }

    @GetMapping("/read/{id}")
    public Account read(@PathVariable String id){
        return accountService.read(id);
    }

    @PostMapping ("/update")
    public Account update(@RequestBody Account account){
        return accountService.update(account);
    }

    @GetMapping("/all")
    public Set<Account> getall(){
        return accountService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return accountService.delete(id);
    }
}
