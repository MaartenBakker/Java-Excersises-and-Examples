package com.maartenmusic;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class Main {
    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();


    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();

    }

    private static class Thread1 extends Thread {
        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println("Thread 1 has lock 1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException exception) {
                }
                System.out.println("Thread 1 waiting for lock 2.");
                synchronized (lock2) {
                    System.out.println("Thread 1 has lock 1 and lock 2");
                }
                System.out.println("Thread 1 has released lock 2");
            }
            System.out.println("Thread 1 has released lock 1. Exiting.....");
        }
    }

    private static class Thread2 extends Thread {
        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println("Thread 2 has lock 1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException exception) {
                }
                System.out.println("Thread 2 waiting for lock 2.");
                synchronized (lock2) {
                    System.out.println("Thread 2 has lock 1 and lock 2");
                }
                System.out.println("Thread 2 has released lock 2");
            }
            System.out.println("Thread 2 has released lock 1. Exiting.....");
        }
    }
}