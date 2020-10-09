package com.Maarten;

import java.awt.event.HierarchyEvent;
import java.util.*;

public class Main {
    public static Map<Integer, HeavenlyBody> solarSystem = new HashMap<>();
    public static Set<HeavenlyBody> heavenlyBodies = new HashSet<>();


    public static void main(String[] args) {

        TestPlanet testPlanet = new TestPlanet("Aarde", TestPlanet.SoortLichaam.PLANEET);


//        Planet earth = new Planet("Earth", 365);
//        heavenlyBodies.add(earth);
//        solarSystem.put(earth.hashCode(), earth);
//
//        Moon moon = new Moon("Moon", 29);
//        heavenlyBodies.add(moon);
//        solarSystem.put(moon.hashCode(), moon);
//
//        earth.addSatellite(moon);
//
//        Set<HeavenlyBody> moonsOfEarth = new HashSet<>();
//        moonsOfEarth.addAll(earth.getSatellites());
//
//        for (HeavenlyBody moonOfEarth: moonsOfEarth) {
//            System.out.println(moonOfEarth.getName());
//        }




         Planet temp = new Planet("Mercury", 88);
         solarSystem.put(temp.hashCode(), temp);
         heavenlyBodies.add(temp);

         temp = new Planet("Venus", 225);
         solarSystem.put(temp.hashCode() , temp);
         heavenlyBodies.add(temp);

         temp = new Planet("Earth", 365);
         solarSystem.put(temp.hashCode() , temp);
         heavenlyBodies.add(temp);

        Moon tempMoon = new Moon("Moon", 27);
        solarSystem.put(tempMoon.hashCode(), tempMoon);
        temp.addSatellite(tempMoon);

        temp = new Planet("Mars", 687);
        solarSystem.put(temp.hashCode() , temp);
        heavenlyBodies.add(temp);

        tempMoon = new Moon("Deimos", 1.3);
        solarSystem.put(tempMoon.hashCode(), tempMoon);
        temp.addSatellite(tempMoon);

        tempMoon = new Moon("Phobos", 0.3);
        solarSystem.put(tempMoon.hashCode(), tempMoon);
        temp.addSatellite(tempMoon);

        temp = new Planet("Jupiter", 4332);
        solarSystem.put(temp.hashCode() , temp);
        heavenlyBodies.add(temp);

        tempMoon = new Moon("Io", 1.8);
        solarSystem.put(tempMoon.hashCode(), tempMoon);
        temp.addSatellite(tempMoon);

        tempMoon = new Moon("Europa", 3.5);
        solarSystem.put(tempMoon.hashCode(), tempMoon);
        temp.addSatellite(tempMoon);

        tempMoon = new Moon("Ganymede", 7.1);
        solarSystem.put(tempMoon.hashCode(), tempMoon);
        temp.addSatellite(tempMoon);

        tempMoon = new Moon("Callisto", 16.7);
        solarSystem.put(tempMoon.hashCode(), tempMoon);
        temp.addSatellite(tempMoon);

        temp = new Planet("Saturn", 10759);
        solarSystem.put(temp.hashCode() , temp);
        heavenlyBodies.add(temp);

        temp = new Planet("Uranus", 30660);
        solarSystem.put(temp.hashCode() , temp);
        heavenlyBodies.add(temp);

        temp = new Planet("Neptune", 165);
        solarSystem.put(temp.hashCode() , temp);
        heavenlyBodies.add(temp);

        temp = new Planet("Pluto", 248);
        solarSystem.put(temp.hashCode() , temp);
        heavenlyBodies.add(temp);

        temp = new Planet("Pluto", -1);
        solarSystem.put(temp.hashCode() , temp);
        heavenlyBodies.add(temp);

        Star tempStar = new Star("Pluto", 0);
        solarSystem.put(temp.hashCode(), temp);
        heavenlyBodies.add(temp);


        System.out.println("Planets :");
        for (HeavenlyBody planet : heavenlyBodies){
            System.out.println("\t" + planet.getName() + " " + planet.getOrbitalPeriod());
        }

        Planet planet = new Planet("Jupiter");
        HeavenlyBody body = solarSystem.get(planet.hashCode());
        System.out.println("Moons of " + body.getName() + ":");
        for (HeavenlyBody moon : body.getSatellites()) {
            System.out.println("\t" + moon.getName());
        }

        temp = new Planet("Jupiter", -1);
        solarSystem.put(temp.hashCode(), temp);

        tempMoon = new Moon("Popiejopie", 16.7);
        solarSystem.put(tempMoon.hashCode(), tempMoon);

        temp.addSatellite(tempMoon);

        planet = new Planet("Jupiter");
        body = solarSystem.get(planet.hashCode());
        System.out.println("Moons of " + body.getName() + ":");
        for (HeavenlyBody moon : body.getSatellites()) {
            System.out.println("\t" + moon.getName());
        }

        planet = new Planet("Pluto");
        body = solarSystem.get(planet.hashCode());
        System.out.println(body.getName() + " " + body.getOrbitalPeriod());

        Star star = new Star("Pluto");
        body = solarSystem.get(star.hashCode());
            if (body != null) {
                System.out.println(body.getName() + " " + body.getOrbitalPeriod());
            }

        Planet xenox = new Planet("Xenox", -24);
        Planet rorax = new Planet("Rorax", -1000);
        Moon monax = new Moon("Monax", -12);

        xenox.addSatellite(monax);

        ArrayList<HeavenlyBody> testList = new ArrayList<>();
        testList.add(xenox);
        testList.add(rorax);

        for (HeavenlyBody testBody: testList) {
            System.out.println(testBody.getName());
        }


//        xenox.addSatellite(monax);
//        xenox.addSatellite(rorax);




//        planet = new Planet("Mars");
//        body = solarSystem.get(planet.hashCode());
//        System.out.println("Moons of " + body.getName() + ":");
//        for (HeavenlyBody moon : body.getSatellites()) {
//            System.out.println("\t" + moon.getName());
//        }
//
//        Set<HeavenlyBody> moons = new HashSet<>();
//
//        for (HeavenlyBody heavenlyBody : heavenlyBodies) {
//            moons.addAll(heavenlyBody.getSatellites());
//        }
//
//        System.out.println("List of all moons");
//
//        for (HeavenlyBody moon : moons) {
//            System.out.println("\t" + moon.getName());
//        }


    }





}
