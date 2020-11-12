package com.systemsmart.service.impl;

import com.systemsmart.entity.Account;
import com.systemsmart.repository.AccountRepository;
import com.systemsmart.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

/*
 * Author: Junaid Martin <216178606@mycput.ac.za>
 * Date: 07 September 2020
 */

@Service
public class AccountServiceImpl implements AccountService {
    private static AccountService service = null;
    @Autowired
    private AccountRepository repository;

    @Override
    public Set<Account> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Account create(Account account) {
        return this.repository.save(account);
    }

    @Override
    public Account read(String s) {
        return this.repository.findById(s).orElseGet(null);
    }

    @Override
    public Account update(Account account) {
        if (this.repository.existsById(account.getAccountId())){
            return this.repository.save(account);
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        this.repository.deleteById(s);
        if (this.repository.existsById(s)) return false;
        else return true;

    }
}
