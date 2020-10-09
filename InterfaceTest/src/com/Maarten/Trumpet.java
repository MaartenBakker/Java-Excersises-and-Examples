package com.Maarten;

public class Trumpet extends Instrument implements Blowable{


    public Trumpet(String brand) {
        super(brand, 10, 17, 43);
        System.out.println("Picking up new " + brand + " Trumpet.");
    }

    @Override
    public void playNote() {
        System.out.println("Trumpet plays note.");
        play();
    }

    @Override
    public void playChord() {
        System.out.println("Trumpet cannot play chord.");
        stop();
    }


    public String toString() {
        return this.getClass().getSimpleName();
    }
}
