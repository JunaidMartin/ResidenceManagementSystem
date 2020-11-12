package com.systemsmart.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Account implements Serializable {
    @Id
    private String accountId;
    private String statementType;
    private double debitAmount, creditAmount, balanceAmount;
    private String balanceDate;

    protected Account(){
    }
    public Account(Builder builder) {
        this.accountId = builder.accountId;
        this.statementType = builder.statementType;
        this.debitAmount = builder.debitAmount;
        this.creditAmount = builder.creditAmount;
        this.balanceAmount = builder.balanceAmount;
        this.balanceDate = builder.balanceDate;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getStatementType() {
        return statementType;
    }

    public double getDebitAmount() {
        return debitAmount;
    }

    public double getCreditAmount() {
        return creditAmount;
    }

    public double getBalanceAmount() {
        return balanceAmount;
    }

    public String getBalanceDate() {
        return balanceDate;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId='" + accountId + '\'' +
                ", statementType='" + statementType + '\'' +
                ", debitAmount=" + debitAmount +
                ", creditAmount=" + creditAmount +
                ", balanceAmount=" + balanceAmount +
                ", balanceDate='" + balanceDate + '\'' +
                '}';
    }

    public static class Builder{
        private String accountId;
        private String statementType;
        private double debitAmount, creditAmount, balanceAmount;
        private String balanceDate;

        public Builder setAccountId(String accountId) {
            this.accountId = accountId;
            return this;
        }

        public Builder setStatementType(String statementType) {
            this.statementType = statementType;
            return this;
        }

        public Builder setDebitAmount(double debitAmount) {
            this.debitAmount = debitAmount;
            return this;
        }

        public Builder setCreditAmount(double creditAmount) {
            this.creditAmount = creditAmount;
            return this;
        }

        public Builder setBalanceAmount(double balanceAmount) {
            this.balanceAmount = balanceAmount;
            return this;
        }

        public Builder setBalanceDate(String balanceDate) {
            this.balanceDate = balanceDate;
            return this;
        }

        public Builder copy(Account account){
            this.accountId = account.accountId;
            this.statementType = account.statementType;
            this.debitAmount = account.debitAmount;
            this.creditAmount = account.creditAmount;
            this.balanceAmount = account.balanceAmount;
            this.balanceDate = account.balanceDate;
            return this;
        }

        public Account build(){
            return new Account(this);
        }
    }
}
