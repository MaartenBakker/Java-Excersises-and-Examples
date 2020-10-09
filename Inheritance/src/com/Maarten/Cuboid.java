package com.Maarten;

public class Cuboid extends Rectangle {

    // Fields

    private double height;

    // Constructors


    public Cuboid(double width, double length, double height) {
        super(width, length);
        if (height < 0) height = 0;
        this.height = height;
    }

    // Methods


    public double getHeight() {
        return height;
    }

    public double getVolume() {
        return height * this.getArea();
    }
}
