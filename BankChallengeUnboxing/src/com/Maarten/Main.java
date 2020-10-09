package com.Maarten;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Bank ING = new Bank("ING");
        ING.addBranch("Utrecht");
        ING.addBranch("Amsterdam");
        ING.addBranch("Oudewater");

        ING.addCustomer("Utrecht", "Maarten Bakker", 12000.00);
        ING.addCustomer("Utrecht", "Anna Zeijlemaker", 4500);
        ING.addCustomer("Oudewater", "Berend Bakker", 300);
        ING.addCustomer("Oudewater", "Kasper Bakker", 500.45 );
        ING.addCustomer("Oudewater", "Ella Bakker", 3000);

        ING.printBraches();

        ING.printCustomers("Oudewater");

        ING.addTransaction("Oudewater", "Kasper Bakker", -50.30);
        ING.addTransaction("Utrecht", "Maarten Bakker", 5000);
        ING.addTransaction("Utrecht", "Anna Zeijlemaker", 600.60);
        ING.addTransaction("Amsterdam", "Popoe", 500);
        ING.addTransaction("Vlaardingen", "Jopier", 50);
        ING.printCustomersAndTransactions("Utrecht");
        ING.printCustomersAndTransactions("Oudewater");
        ING.printCustomersAndTransactions("Rotterdam");


    }
}
