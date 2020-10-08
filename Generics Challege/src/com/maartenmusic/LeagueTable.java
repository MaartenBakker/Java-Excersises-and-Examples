package com.maartenmusic;

import java.util.ArrayList;

public class LeagueTable<T extends Team> {

    // fields

    private String name;
    private ArrayList<T> listOfTeams;


    // constructor

    public LeagueTable(String name) {
        this.name = name;
        this.listOfTeams = new ArrayList<T>();
    }

    // get set

    public String getName() {
        return name;
    }

    // methods

    public void addTeamToList(T team) {
        listOfTeams.add(team);
    }

    public void printListOfTeams() {
        for (Team team : listOfTeams) {
            System.out.println(team.getName());
        }
    }
}
