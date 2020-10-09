package com.Maarten;

public class KiaCeed extends Car {
    private String brand;
    private String model;
    private boolean hasNavigation;

    public KiaCeed(String color) {
        super(4000, "KiaCeed", "Station", 4, color, true);
        this.brand = "Kia";
        this.model = "Ceed";
        this.hasNavigation = true;
    }

    public void goToRockskool() {
        System.out.println("Aan het werk!");
    }

    @Override
    public void crash() {
        System.out.println("Oh no, Kia Ceed crashed!");
    }
}


