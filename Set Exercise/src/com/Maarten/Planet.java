package com.Maarten;

public class Planet extends HeavenlyBody {


    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, "planet");
    }

    public Planet(String name){
        super(name, 0, "planet");
    }

    public boolean addSatellite(Moon satellite) {
        return super.addToSatellites(satellite);
    }


}
