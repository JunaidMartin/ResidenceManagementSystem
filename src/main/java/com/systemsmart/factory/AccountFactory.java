package com.systemsmart.factory;

import com.systemsmart.entity.Account;

public class AccountFactory {
    public static Account buildAccount(String accountId, String statementType,double debitAmount, double creditAmount, double balanceAmount, String balanceDate){
        Account account = new Account.Builder()
                .setAccountId(accountId)
                .setStatementType(statementType)
                .setDebitAmount(debitAmount)
                .setCreditAmount(creditAmount)
                .setBalanceAmount(balanceAmount)
                .setBalanceDate(balanceDate)
                .build();
        return account;
    }
}
