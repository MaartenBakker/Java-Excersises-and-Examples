package com.Maarten;

public class Printer {

    // Fields

    private int tonerLevel = 100;
    private int numberOfPagesPrinted = 0;
    private boolean isDuplexPrinter;

    // Constructors

    public Printer(boolean isDuplexPrinter) {
        this.isDuplexPrinter = isDuplexPrinter;
    }

    // Getters


    public boolean isDuplexPrinter() {
        return isDuplexPrinter;
    }

    // Methods

    public void printPage(int numberOfPages) {
        if (isDuplexPrinter) System.out.println("This printer is a duplex printer");
        else System.out.println("This printer is not a duplex printer");

        System.out.println(numberOfPages + " pages being printed");
        this.numberOfPagesPrinted += numberOfPages;

        this.tonerLevel -= (numberOfPages * 2);
    }

    public void refillToner(int amountOfInk) {
        if (amountOfInk < 0) {
            System.out.println("Refilling ink.");
            tonerLevel += amountOfInk;

            if (tonerLevel > 100) {
                System.out.println("Ink limit reached, discarding surplus.");
                tonerLevel = 100;
            }
        }
    }

    public void showTonerLevel() {
        System.out.println("The toner level is " + tonerLevel);
    }
}
