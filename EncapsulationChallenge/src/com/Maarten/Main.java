package com.Maarten;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Printer printer = new Printer(true);
        printer.showTonerLevel();
        printer.printPage(12);
        printer.showTonerLevel();
        printer.refillToner(40);
        printer.showTonerLevel();

    }
}
