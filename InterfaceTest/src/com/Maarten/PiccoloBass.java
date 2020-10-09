package com.Maarten;

public class PiccoloBass extends Bass {



    public PiccoloBass(String brand) {
        super(brand, 7 , 33);
        System.out.println("Picking up new" + brand + " Piccolo Bass.");
    }

    @Override
    public void playNote() {
        super.playNote();
    }

    @Override
    public void playChord() {
        System.out.println("Piccolo Bass plays chord.");
        play();
    }



    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void Slap() {
        super.Slap();
    }
}
