package com.maartenmusic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private double balance;
    private String accountNumber;
    private Lock lock;

    public BankAccount(double balance, String accountNumber) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.lock = new ReentrantLock();
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void printAccountNumber() {
        System.out.println("AccountNumber = " + accountNumber);
    }

    public  void deposit (double amount) {
        boolean status;

        lock.lock();
        try {
            status = false;
        } finally {
            lock.unlock();
        }


        try {
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    balance += amount;
                    status = true;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Could not get the lock.");
            }
        } catch (InterruptedException e) {

        }
        System.out.println("Transaction status = " + status);
    }

    public  void withDraw (double amount) {

        boolean status = false;

        try {
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    balance -= amount;
                    status = true;

                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Could not get the lock.");
            }
        } catch (InterruptedException e) {

        }
        System.out.println("Transaction status = " + status);

    }
}
