package com.systemsmart.factory;

import com.systemsmart.entity.Account;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountFactoryTest {

    @Test
    public void buildAccount() {
        Account account = AccountFactory.buildAccount("1", "Fee", 39469.00,
                37567.00, 1902.00, "11-NOV-2020");
        Assert.assertNotEquals(39469.00, account.getCreditAmount());
    }
}