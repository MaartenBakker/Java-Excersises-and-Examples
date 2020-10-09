package com.Maarten;

public class Trombone extends Instrument implements Blowable {


    public Trombone(String brand) {
        super(brand, 8, 9, 29);
        System.out.println("Picking up new " + brand + " Trombone.");
    }

    @Override
    public void playNote() {
        System.out.println("Trombone plays note.");
        play();
    }

    @Override
    public void playChord() {
        System.out.println("Trombone cannot play chord.");
        stop();
    }



    public String toString() {
        return this.getClass().getSimpleName();
    }
}
