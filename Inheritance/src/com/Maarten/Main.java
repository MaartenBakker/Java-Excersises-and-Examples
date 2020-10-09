package com.Maarten;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Circle circle = new Circle(100);
        System.out.println(circle.getRadius());
        System.out.println(circle.getArea());

        Cylinder cylinder = new Cylinder(200, 20);
        System.out.println(cylinder.getArea());
        System.out.println(cylinder.getVolume());

    }
}
