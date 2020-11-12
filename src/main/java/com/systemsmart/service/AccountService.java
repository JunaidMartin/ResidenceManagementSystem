package com.systemsmart.service;

import com.systemsmart.entity.Account;

import java.util.Set;

public interface AccountService extends IService <Account, String> {
    Set<Account> getAll();
}
