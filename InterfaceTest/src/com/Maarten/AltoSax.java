package com.Maarten;

public class AltoSax extends Sax {

    public AltoSax(String brand) {
        super(brand, 16, 34);
        System.out.println("Picking up new " + brand + " Alto Sax.");
    }
}
