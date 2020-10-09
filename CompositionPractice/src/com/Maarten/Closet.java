package com.Maarten;

public class Closet {

    // Fields;

    boolean isClosed;
    Cup cup;
    Plate plate;


    // Constructor

    public Closet(Cup cup, Plate plate) {
        this.isClosed = true;
        this.cup = cup;
        this.plate = plate;
    }


    // Methods

    public void close() {
        System.out.println("Closet.close(): The door has closed.");
        isClosed = true;
    }

    public void open() {
        System.out.println("Closet.open(): The door has opened.");
        isClosed = false;
    }

    public boolean isClosed() {
        System.out.println("Closet.isClosed() returning boolean.");
        return isClosed;
    }

    private Cup getCup() {
        return cup;
    }

    public Plate getPlate() {
        return plate;
    }
}
