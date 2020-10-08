package com.maartenmusic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    static BankAccount account;

    @BeforeEach
    void initialize() {
        account = new BankAccount("Maarten", "Bakker", 1000.00, BankAccount.CHECKING);
    }

    @Test
    void deposit() {
        double balance = account.deposit(200.00, true);
        assertEquals(1200.00, balance, 0);
    }

    @Test
    void withdraw_branch() throws Exception {
        double balance = account.withdraw(600.00, true);
        assertEquals(400.00, balance, 0);
    }

    @Test
    void withdraw_notBranch() {
        assertThrows(IllegalArgumentException.class, ()-> account.withdraw(600.00, false));
    }

    @Test
    void getBalance_deposit() {
        account.deposit(200.00, true);
        assertEquals(1200.00, account.getBalance(), 0);    }

    @Test
    void getBalance_withdraw() {
        account.withdraw(200.00, true);
        assertEquals(800.00, account.getBalance(), 0);    }

    @Test
    void isChecking_true(){
        assertTrue(account.isChecking(), "The account is NOT a checking account.");
    }
}