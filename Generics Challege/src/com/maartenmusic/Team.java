package com.maartenmusic;

import java.util.ArrayList;

public class Team<T> implements Comparable<Team<T>>{
    //fields
    private String name;
    private int score;
    private ArrayList<T> players = new ArrayList<>();

    //constructor

    public Team(String name, int score) {
        this.name = name;
        this.score = score;
    }

    //get & set

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Team o) {
        return 0;
    }

    //methods
}
