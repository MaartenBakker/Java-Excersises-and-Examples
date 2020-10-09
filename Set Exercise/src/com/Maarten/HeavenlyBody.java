package com.Maarten;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class HeavenlyBody {
    private final String name;
    private final Double orbitalPeriod;
    private final String bodyType;
    private final Set<HeavenlyBody> satellites;


    //Constructor

    public HeavenlyBody(String name, double orbitalPeriod, String bodyType) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.bodyType = bodyType;
        this.satellites = new HashSet<>();
    }

    //Get Set

    public String getName() {
        return name;
    }

    public Double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public String getBodyType() {
        return bodyType;
    }


    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<HeavenlyBody>(this.satellites);
    }

    protected boolean addToSatellites(HeavenlyBody satellite){
        return this.satellites.add(satellite);
    }



    //Methods
//
//    public boolean addSatellite (HeavenlyBody satellite){
//        return this.satellites.add(satellite);
//    }

    //Overrides


//    @Override
//    public int hashCode() {
//        return Objects.hash(name);
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        } else if (obj instanceof HeavenlyBody) {
//            HeavenlyBody anotherBody = (HeavenlyBody) obj;
//            return this.getName().equals(anotherBody.getName());
//        }
//        else return false;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeavenlyBody that = (HeavenlyBody) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(bodyType, that.bodyType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, bodyType);
    }
}
