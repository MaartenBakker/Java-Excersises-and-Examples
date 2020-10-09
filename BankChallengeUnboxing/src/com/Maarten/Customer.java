package com.Maarten;

import java.util.ArrayList;

public class Customer {

    // Fields

    private String name;
    private ArrayList<Double> transactions;

    // Static methods

    public static Customer createCustomer(String name, double initialCredit) {
        ArrayList<Double> list = new ArrayList<Double>();
        list.add(initialCredit);
        System.out.println("Customer " + name + " created with initial credit of " + initialCredit);
        return new Customer(name, list);

    }

    // Constructor

    private Customer(String name, ArrayList<Double> transactions) {
        this.name = name;
        this.transactions = transactions;
    }

    // Getter Setter

    public String getName() {
        return name;
    }


    // Methods

    public void addTransaction(double transaction) {
        this.transactions.add(transaction);
        System.out.println("Transaction of " + transaction + " added to " + this.getName());
    }

    public void printTransactions() {
        double sum = 0;

        System.out.println("Customer name " + this.name);
        System.out.println("List of transactions:");

        for (Double transaction : transactions) {
            System.out.println(transaction);
            sum += transaction;
        }

        System.out.println("Total amount is: " + sum);
    }




}
