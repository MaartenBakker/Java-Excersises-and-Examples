package com.Maarten;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {

    // Fields

    private String name;
    private ArrayList<Branch> branches = new ArrayList<Branch>();

    // Constructor

    public Bank(String name) {
        this.name = name;
    }

    // Getter Setter

    public String getName() {
        return name;
    }

    // Methods

    public void addBranch(String name) {
        if (branchPosition(name) == -1) {
            Branch branch = Branch.createBranch(name);
            branches.add(branch);
            System.out.println("Branch " + name + " added to " + this.getName());
        } else {
            System.out.println("Branch " + name + " already exists.");
        }
    }

    public void addCustomer(String branchName, String customerName, double initialAmount) {
        int position = branchPosition(branchName);
        if (position >= 0) {
            branches.get(position).addCustomer(customerName, initialAmount);
        } else {
            System.out.println("Branch not found.");
        }

    }

    public void addTransaction(String branchName, String customerName, double transaction) {
        int position = branchPosition(branchName);
        if (position >= 0) {
            branches.get(position).addTransaction(customerName, transaction);
        } else {
            System.out.println("Branch not found.");
        }
    }

    public void printCustomers(String branch) {
        int position = branchPosition(branch);
        if (position >= 0) {
            branches.get(position).printCustomers();
        } else {
            System.out.println("Branch not found.");
        }
    }

    public void printCustomersAndTransactions(String branch) {
        int position = branchPosition(branch);
        if (position >= 0) {
            branches.get(position).printCustomersAndTransactions();
        } else {
            System.out.println("Branch not found.");
        }
    }

    public void printBraches() {
        System.out.println("List of branches.");
        for (Branch branch : branches) {
            System.out.println(branch.getName());
        }
    }


    private int branchPosition(String name) {
        for (Branch branch : branches) {
            if (branch.getName().equals(name)) {
                return branches.indexOf(branch);
            }
        }
        return -1;
    }
}
