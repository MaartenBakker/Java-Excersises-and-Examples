package com.Maarten;

public class Star extends HeavenlyBody {
    public Star(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, "star");
    }

    public Star(String name) {
        super(name, -1, "star");
    }

    public boolean addSatellite(HeavenlyBody satellite) {
        return super.addToSatellites(satellite);
    }

}
