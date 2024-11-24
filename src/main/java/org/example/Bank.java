package org.example;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    public Map<String, BankAccount> accounts;

    public Bank() {
        this.accounts = new HashMap<>();
    }

    public void addAccount(BankAccount account) {
        if (!accounts.containsKey(account.getAccountNumber())) {
            accounts.put(account.getAccountNumber(), account);
            System.out.println("Account added successfully.");
        } else {
            System.out.println("Account already exists.");
        }
    }

    public BankAccount getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public void removeAccount(String accountNumber) {
        if (accounts.remove(accountNumber) != null) {
            System.out.println("Account removed successfully.");
        } else {
            System.out.println("Account not found.");
        }
    }

    public void printAllAccounts() {
        System.out.println("All Accounts in the Bank:");
        for (BankAccount account : accounts.values()) {
            System.out.println("Account: " + account.getAccountNumber() + " - " + account.getAccountHolderName());
        }
    }
}