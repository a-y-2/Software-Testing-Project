//package org.example;

import org.example.Bank;
import org.example.BankAccount;
import org.example.Transaction;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class BankingSystemTest {

    private Bank bank;
    private BankAccount account;

    @BeforeEach
    void setup() {
        bank = new Bank();
        account = new BankAccount("12345", "John Doe", 1000.0, "Savings");
        bank.addAccount(account);
    }

    @Nested
    @DisplayName("Bank Tests")
    class BankTests {

        @Test
        @DisplayName("Test Add Account")
        void testAddAccount() {
            BankAccount newAccount = new BankAccount("67890", "Jane Smith", 2000.0, "Current");
            bank.addAccount(newAccount);
            assertNotNull(bank.getAccount("67890"), "Account should be added to the bank");
        }

        @Test
        @DisplayName("Test Remove Account - Existing Account")
        void testRemoveAccountExisting() {
            bank.removeAccount("12345");
            assertNull(bank.getAccount("12345"), "Account should be removed from the bank");
        }

        @Test
        @DisplayName("Test Remove Account - Non-Existing Account")
        void testRemoveAccountNonExisting() {
            bank.removeAccount("99999");
            // We can't check for "null" here since removeAccount prints a message.
            assertNull(bank.getAccount("99999"), "Non-existing account should not be removed");
        }

        @Test
        @DisplayName("Test Print All Accounts")
        void testPrintAllAccounts() {
            BankAccount newAccount = new BankAccount("67890", "Jane Smith", 2000.0, "Current");
            bank.addAccount(newAccount);
            // Check the number of accounts
            assertEquals(2, bank.accounts.size(), "There should be 2 accounts in the bank");
        }
    }

    @Nested
    @DisplayName("BankAccount Tests")
    class BankAccountTests {

        @Test
        @DisplayName("Test Deposit - Valid Amount")
        void testDepositValidAmount() {
            account.deposit(500.0);
            assertEquals(1500.0, account.getBalance(), "Balance mismatch after deposit");
        }

        @Test
        @DisplayName("Test Deposit - Negative Amount")
        void testDepositNegativeAmount() {
            account.deposit(-200.0);
            assertEquals(1000.0, account.getBalance(), "Balance should not change with negative deposit");
        }

        @Test
        @DisplayName("Test Withdraw - Valid Amount")
        void testWithdrawValidAmount() {
            account.withdraw(200.0);
            assertEquals(800.0, account.getBalance(), "Balance mismatch after withdrawal");
        }

        @Test
        @DisplayName("Test Withdraw - Exceeding Balance")
        void testWithdrawExceedingBalance() {
            boolean result = account.withdraw(2000.0);
            assertFalse(result, "Withdrawal should fail when exceeding balance");
            assertEquals(1000.0, account.getBalance(), "Balance should remain the same after failed withdrawal");
        }

        @Test
        @DisplayName("Test Withdraw - Negative Amount")
        void testWithdrawNegativeAmount() {
            boolean result = account.withdraw(-100.0);
            assertFalse(result, "Withdrawal should fail with negative amounts");
            assertEquals(1000.0, account.getBalance(), "Balance should remain unchanged after failed withdrawal");
        }

        @Test
        @DisplayName("Test Transaction History After Deposit and Withdraw")
        void testTransactionHistory() {
            account.deposit(500.0);
            account.withdraw(200.0);

            assertEquals(2, account.getTransactions().size(), "There should be 2 transactions");
            assertEquals("Deposit", account.getTransactions().get(0).getType(), "First transaction should be a deposit");
            assertEquals("Withdrawal", account.getTransactions().get(1).getType(), "Second transaction should be a withdrawal");
        }
    }

    @Nested
    @DisplayName("Transaction Tests")
    class TransactionTests {

        @Test
        @DisplayName("Test Transaction Creation")
        void testTransactionCreation() {
            Transaction transaction = new Transaction("Deposit", 500.0);
            assertEquals("Deposit", transaction.getType(), "Transaction type mismatch");
            assertEquals(500.0, transaction.getAmount(), "Transaction amount mismatch");
            assertNotNull(transaction.getTimestamp(), "Transaction timestamp should not be null");
        }
    }

    @Nested
    @DisplayName("Main Application Tests")
    class MainApplicationTests {

        @Test
        @DisplayName("Test Adding Multiple Accounts")
        void testAddingMultipleAccounts() {
            BankAccount account2 = new BankAccount("67890", "Jane Smith", 500.0, "Current");
            bank.addAccount(account2);
            BankAccount account3 = new BankAccount("11111", "Alice Brown", 1500.0, "Savings");
            bank.addAccount(account3);

            assertEquals(3, bank.accounts.size(), "There should be 3 accounts after adding three accounts");
        }

        @Test
        @DisplayName("Test Printing Account Details")
        void testPrintingAccountDetails() {
            account.deposit(200.0);
            assertEquals(1200.0, account.getBalance(), "Balance mismatch after deposit");
            // Assuming the print happens via System.out (you can mock stdout if needed for testing)
            assertDoesNotThrow(() -> account.printTransactions(), "Transactions should print without error");
        }

        @Test
        @DisplayName("Test Removing Account and Re-checking Balance")
        void testRemoveAndCheckAccount() {
            bank.removeAccount("12345");
            assertNull(bank.getAccount("12345"), "Account should be removed and not found");
        }
    }
}
