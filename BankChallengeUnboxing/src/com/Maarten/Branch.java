package com.Maarten;

import java.util.ArrayList;

public class Branch {

    // Fields

    private String name;

    private ArrayList<Customer> customers = new ArrayList<Customer>();

    // Static Methods

    public static Branch createBranch(String name) {
        return new Branch(name);
    }

    // Constructors


    private Branch(String name) {
        this.name = name;
    }



    // Getter Setter

    public String getName() {
        return name;
    }

    // Methods



    public void addCustomer(String name, double initialCredit) {
        if (customerPosition(name) == -1) {
            Customer customer = Customer.createCustomer(name, initialCredit);
            customers.add(customer);
            System.out.println("Customer " + name + " added to " + this.getName());
        } else {
            System.out.println("Customer " + name + " already exists.");
        }
    }

    public void addTransaction(String name, double transaction) {
        int position = customerPosition(name);
        if (position >= 0) {
                customers.get(position).addTransaction(transaction);
            } else {
                System.out.println("Customer not found.");
            }
    }


    private int customerPosition(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equals(name)) {
                return customers.indexOf(customer);
            }
        }
        return -1;
    }

    public void printCustomers() {
        System.out.println("List of customers in " + this.name);
        for (Customer customer : customers) {
            System.out.println(customer.getName());
        }
    }

    public void printCustomersAndTransactions() {
        System.out.println("List of customers and transactions in " + this.name);
        for (Customer customer : customers) {
            System.out.println(customer.getName());
            customer.printTransactions();
        }
    }

}
