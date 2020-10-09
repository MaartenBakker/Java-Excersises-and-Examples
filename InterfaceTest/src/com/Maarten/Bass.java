package com.Maarten;

public class Bass extends Instrument implements Strummable {


    public Bass(String brand) {
        super(brand, 3, 0, 26);
        System.out.println("Picking up new " + brand + " Bass.");
    }

    public Bass(String brand, int lowestNote, int highestNote) {
        super(brand, 3, lowestNote, highestNote);
    }

    @Override
    public void playNote() {
        System.out.println("Bass plays note.");
        play();
    }

    @Override
    public void playChord() {
        System.out.println("Bass can't play chords.");
        stop();
    }


    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    public void Slap() {
        System.out.println("Slappa da bass!!!");
    }


}
