package com.maartenmusic;

public class Main {

    public static void main(String[] args) {
	// write your code here


        Team<footballPlayer> ajax = new Team("Ajax", 1);
        Team<footballPlayer> feyenoord = new Team("Feyenoord", 2);
        Team<footballPlayer> fcUtrecht = new Team("FC Utrecht", 0);
        Team<baseballPlayer> whatever = new Team("poep", 10);


        LeagueTable<Team> championsLeague = new LeagueTable<>("Champions League");

        championsLeague.addTeamToList(ajax);
        championsLeague.addTeamToList(feyenoord);
        championsLeague.addTeamToList(fcUtrecht);
//        championsLeague.addTeamToList(whatever);

        championsLeague.printListOfTeams();



    }
}
