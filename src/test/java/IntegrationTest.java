import org.example.Bank;
import org.example.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IntegrationTest {

    private Bank bank;
    private BankAccount account1;
    private BankAccount account2;

    @BeforeEach
    public void setUp() {
        // Initialize Bank and accounts for testing
        bank = new Bank();
        account1 = new BankAccount("12345", "John Doe", 1000.0, "Savings");
        account2 = new BankAccount("67890", "Jane Smith", 2000.0, "Current");

        // Add accounts to the bank
        bank.addAccount(account1);
        bank.addAccount(account2);
    }

    @Test
    public void testAddAccount() {
        // Act: Add a new account
        BankAccount newAccount = new BankAccount("11223", "Sam Wilson", 500.0, "Savings");
        bank.addAccount(newAccount);

        // Assert: Check if the new account is added
        BankAccount retrievedAccount = bank.getAccount("11223");
        assertNotNull(retrievedAccount);
        assertEquals("Sam Wilson", retrievedAccount.getAccountHolderName());
    }

    @Test
    public void testRemoveAccount() {
        // Act: Remove an existing account
        bank.removeAccount("12345");

        // Assert: Ensure the account is removed from the bank
        BankAccount removedAccount = bank.getAccount("12345");
        assertNull(removedAccount);  // Account should be null after removal
    }

    @Test
    public void testDeposit() {
        // Act: Deposit money into an account
        account1.deposit(500.0);

        // Assert: Verify the balance after deposit
        assertEquals(1500.0, account1.getBalance(), "Balance should be updated after deposit");
    }

    @Test
    public void testWithdraw() {
        // Act: Withdraw money from an account
        boolean success = account2.withdraw(500.0);

        // Assert: Verify the withdrawal success and new balance
        assertTrue(success);
        assertEquals(1500.0, account2.getBalance(), "Balance should be updated after withdrawal");
    }

    @Test
    public void testWithdrawMoreThanBalance() {
        // Act: Try to withdraw more than available balance
        boolean success = account1.withdraw(2000.0);

        // Assert: Verify that the withdrawal is unsuccessful
        assertFalse(success);
        assertEquals(1000.0, account1.getBalance(), "Balance should remain unchanged after failed withdrawal");
    }

    @Test
    public void testPrintTransactions() {
        // Arrange: Make some transactions
        account1.deposit(300.0);
        account1.withdraw(100.0);

        // Act: Print transactions (this will print to the console)
        account1.printTransactions();  // This would print the transactions, so no assertion here
    }

    @Test
    public void testPrintAllAccounts() {
        // Act: Print all accounts (this will print to the console)
        bank.printAllAccounts();  // This will print the account details, so no assertion here
    }
}
