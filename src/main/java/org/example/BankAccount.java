package org.example;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private String accountType; // Savings, Current, etc.
    private List<Transaction> transactions;

    public BankAccount(String accountNumber, String accountHolderName, double balance, String accountType) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.accountType = accountType;
        this.transactions = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add(new Transaction("Deposit", amount));
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions.add(new Transaction("Withdrawal", amount));
            return true;
        } else {
            System.out.println("Invalid withdrawal amount.");
            return false;
        }
    }

    public void printTransactions() {
        System.out.println("Transactions for Account: " + accountNumber);
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    // Add this method to return the list of transactions
    public List<Transaction> getTransactions() {
        return transactions;
    }
}
