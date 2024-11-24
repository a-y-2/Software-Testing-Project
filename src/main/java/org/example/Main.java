package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nBanking System");
            System.out.println("1. Add Account");
            System.out.println("2. Remove Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Print Account Details");
            System.out.println("6. Print All Accounts");
            System.out.println("7. Print Transactions");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Account Number: ");
                    String accountNumber = scanner.next();
                    System.out.print("Enter Account Holder Name: ");
                    String holderName = scanner.next();
                    System.out.print("Enter Initial Balance: ");
                    double balance = scanner.nextDouble();
                    System.out.print("Enter Account Type (Savings/Current): ");
                    String type = scanner.next();
                    bank.addAccount(new BankAccount(accountNumber, holderName, balance, type));
                }
                case 2 -> {
                    System.out.print("Enter Account Number: ");
                    String accountNumber = scanner.next();
                    bank.removeAccount(accountNumber);
                }
                case 3 -> {
                    System.out.print("Enter Account Number: ");
                    String accountNumber = scanner.next();
                    System.out.print("Enter Deposit Amount: ");
                    double amount = scanner.nextDouble();
                    BankAccount account = bank.getAccount(accountNumber);
                    if (account != null) account.deposit(amount);
                    else System.out.println("Account not found.");
                }
                case 4 -> {
                    System.out.print("Enter Account Number: ");
                    String accountNumber = scanner.next();
                    System.out.print("Enter Withdrawal Amount: ");
                    double amount = scanner.nextDouble();
                    BankAccount account = bank.getAccount(accountNumber);
                    if (account != null) account.withdraw(amount);
                    else System.out.println("Account not found.");
                }
                case 5 -> {
                    System.out.print("Enter Account Number: ");
                    String accountNumber = scanner.next();
                    BankAccount account = bank.getAccount(accountNumber);
                    if (account != null)
                        System.out.println("Account Holder: " + account.getAccountHolderName() +
                                ", Balance: " + account.getBalance());
                    else System.out.println("Account not found.");
                }
                case 6 -> bank.printAllAccounts();
                case 7 -> {
                    System.out.print("Enter Account Number: ");
                    String accountNumber = scanner.next();
                    BankAccount account = bank.getAccount(accountNumber);
                    if (account != null) account.printTransactions();
                    else System.out.println("Account not found.");
                }
                case 0 -> {
                    System.out.println("Exiting Banking System. Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}