package com.Maarten;

public class Song {

    // Fields

    private String name;
    private double duration;

    // Constructors

    public Song(String name, double duration) {
        this.name = name;
        this.duration = duration;
    }


    // Getter Setter


    public String getName() {
        return name;
    }

    public double getDuration() {
        return duration;
    }

    // Methods

    public void playSong() {
        System.out.println("Now playing: " + this.name);
        System.out.println("Duration: " + this.duration);
    }
}
