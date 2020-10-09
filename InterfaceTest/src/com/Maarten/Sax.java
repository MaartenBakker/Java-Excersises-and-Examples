package com.Maarten;

public class Sax extends Instrument implements Blowable {

    public Sax(String brand, int lowestNote, int highestNote) {
        super(brand, 9, lowestNote, highestNote);
    }

    @Override
    public void playNote() {
        System.out.println("Sax plays note.");
        play();
    }

    @Override
    public void playChord() {
        System.out.println("Sax cannot play chord.");
        stop();
    }


    public String toString() {
        return this.getClass().getSimpleName();
    }


}
