package com.Maarten;

public class Moon extends HeavenlyBody{

    public Moon(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, "moon");
    }

    public boolean addSatellite(Moon satellite) {
        return super.addToSatellites(satellite);
    }
}
