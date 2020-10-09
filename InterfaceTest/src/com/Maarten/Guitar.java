package com.Maarten;

public class Guitar extends Instrument implements Strummable {


    public Guitar(String brand) {
        super(brand, 10, 10, 38);
        System.out.println("Picking up new " + brand + " Guitar.");
    }

    @Override
    public void playNote() {
        System.out.println("Guitar plays note.");
        play();
    }

    @Override
    public void playChord() {
        System.out.println("Guitar plays chord.");
        play();
    }



    public String toString() {
        return this.getClass().getSimpleName();
    }


}
