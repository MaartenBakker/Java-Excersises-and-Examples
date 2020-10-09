package com.Maarten;

public class Cylinder extends Circle {

    // Fields

    private double height;

    // Constructor


    public Cylinder(double radius, double height) {
        super(radius);
        if (height < 0) height = 0;
        this.height = height;
    }

    // Methods


    public double getHeight() {
        return height;
    }

    public  double getVolume() {
        return this.getArea() * height;
    }
}
