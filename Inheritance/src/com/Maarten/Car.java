package com.Maarten;

public class Car extends Vehicle {

    private int doors;
    private int wheels;
    private String color;
    private boolean manual;
    private boolean alarmIsOn;

    public Car(double weight, String name, String type, int doors, String color, boolean manual) {
        super(weight, name, "car");
        this.doors = doors;
        this.wheels = 4;
        this.color = color;
        this.manual = manual;
        this.alarmIsOn = false;
    }

    private void steer(double degrees){
        System.out.println("Steering at " + degrees + " degrees.");
    }

    private void gas(int speed) {
        System.out.println("Pressing gas.");
        super.move(speed);
    }

    @Override
    public void crash() {
        System.out.println("Oh no, car crashed!");;
    }

    public void turnOnAlarm() {
        alarmIsOn = true;
    }

    public void turnOffAlarm() {
        alarmIsOn = false;
    }

}
