package com.Maarten;

public class Piano extends Instrument implements Playable {


    public Piano(String brand) {
        super(brand, 6, -1, 47);
        System.out.println("Sitting down at new " + brand + " Piano.");
    }

    @Override
    public void playNote() {
        System.out.println("Piano plays note.");
        play();
    }

    @Override
    public void playChord() {
        System.out.println("Piano plays chord.");
        play();
    }



    public String toString() {
        return this.getClass().getSimpleName();
    }
}
