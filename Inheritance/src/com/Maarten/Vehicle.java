package com.Maarten;

public class Vehicle {
    private double weight;
    private String name;
    private String type;

    public void move(int speed) {
        System.out.println("The vehicle is moving at " + speed + "km/h.");
    }

    public void crash() {
        System.out.println("Oh no, vehicle crashed!");

    }

    public Vehicle(double weight, String name, String type) {
        this.weight = weight;
        this.name = name;
        this.type = type;
    }
}
