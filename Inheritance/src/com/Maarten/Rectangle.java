package com.Maarten;

public class Rectangle {

    // Fields
    private double width;
    private double length;

    // Constructors

    public Rectangle(double width, double length) {
        if (width < 0) width = 0;
        this.width = width;
        if (length < 0) length = 0;
        this.length = length;
    }

    // Methods


    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public double getArea() {
        return (width * length);
    }
}
