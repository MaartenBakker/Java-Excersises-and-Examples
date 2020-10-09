package com.Maarten;

public class Circle {

    // Fields
    private double radius;



    // Constructors
    public Circle(double radius) {
        if (radius < 0) radius = 0;
        this.radius = radius;
    }

    // Methods

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return (radius * radius * Math.PI);
    }
}
