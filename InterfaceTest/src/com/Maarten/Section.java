package com.Maarten;

import java.util.ArrayList;


public class Section<T extends Playable> {
    ArrayList<T> section;

    public Section() {
        this.section = new ArrayList<>();
    }

    public void addInstrumentToSection(T instrument) {
        section.add(instrument);

        Class[] interfaces = instrument.getClass().getInterfaces();
        String iface;

        if (interfaces.length != 0) {
            iface = interfaces[0].getSimpleName();
        } else {
            Class[] superInterfaces = super.getClass().getInterfaces();

            if (superInterfaces.length != 0) {
                iface = superInterfaces[0].getSimpleName();
            } else {
                iface = "noName";
            }
        }


        System.out.println(instrument.toString() + " added to " + iface + "-section");
    };

    public void removeInstrumentFromSection(T instrument) {
        section.remove(instrument);
        System.out.println(instrument.toString() + " removed from " + section.getClass().getSimpleName());
    }

    public void playChord(String chord){

        if (section.size() >= 3) {
            Playable typeTestObject = section.get(0);

            if (typeTestObject instanceof Blowable) {
                System.out.println("Hornsection is playing a " + chord + " chord.");

                for (T instrument : section) {
                    instrument.play();
                }
            } else {
                System.out.println("Each instrument of Stringsection is playing a " + chord + " chord.");
                for (T instrument : section) {
                    instrument.playChord();
                }
            }

        } else {

            System.out.println("Not enough members in section to play a chord.");
            for (T instrument : section) {
                instrument.stop();
                }

        }
    }

}
