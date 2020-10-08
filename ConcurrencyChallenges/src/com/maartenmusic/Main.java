package com.maartenmusic;

import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {


        final BankAccount bankAccount = new BankAccount(1000.0, "1234");

        Thread t1 = new Thread(()-> {
            bankAccount.deposit(300.00);
            bankAccount.withDraw(50.00);
            System.out.println(bankAccount.getBalance() + " from t1");

        } );

        Thread t2 = new Thread(()-> {
            bankAccount.deposit(203.75);
            bankAccount.withDraw(100.00);
            System.out.println(bankAccount.getBalance() + " from t2");

        } );

        t1.start();
        t2.start();

        System.out.println(bankAccount.getBalance());

    }
}
