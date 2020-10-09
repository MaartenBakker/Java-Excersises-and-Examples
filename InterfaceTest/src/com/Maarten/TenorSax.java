package com.Maarten;

public class TenorSax extends Sax {

    public TenorSax(String brand) {
        super(brand, 12, 30);
        System.out.println("Picking up new " + brand + " Tenor Sax.");
    }

}
