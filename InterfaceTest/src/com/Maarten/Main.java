package com.Maarten;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Strummable bass = new Bass("De Gier");
        Strummable guitar = new Guitar("Gibson");
        Strummable piccoloBass = new PiccoloBass("Alembic");

        Blowable altoSax = new AltoSax("Selmer");
        Blowable tenorSax = new TenorSax("Selmer");
        Blowable trumpet = new Trumpet("Bach");
        Blowable trombone = new Trombone("Bach");

        Piano piano = new Piano("Yamaha");


        Section<Strummable> stringSection = new Section<>() {};
        stringSection.addInstrumentToSection(bass);
        stringSection.addInstrumentToSection(guitar);
        stringSection.addInstrumentToSection(piccoloBass);


        Section<Blowable> hornSection = new Section<>();
        hornSection.addInstrumentToSection(altoSax);
        hornSection.addInstrumentToSection(tenorSax);
        hornSection.addInstrumentToSection(trumpet);
        hornSection.addInstrumentToSection(trombone);

        hornSection.playChord("Cmaj7");
        stringSection.playChord("Fmaj7");

        hornSection.removeInstrumentFromSection(altoSax);
        hornSection.removeInstrumentFromSection(tenorSax);

        hornSection.playChord("Cmaj7");


        Section hornSection1 = new HornSection(altoSax, trumpet, trombone);



//        ArrayList<Playable> playables = new ArrayList<>();
//        playables.add(bass);
//        playables.add(guitar);
//        playables.add(piccoloBass);
//
//        for (Playable playable : playables) {
//            playable.playNote();
//            System.out.println(playable + " is playing? " + playable.isPlaying());
//            playable.playChord();
//            System.out.println(playable + " is playing? " + playable.isPlaying());
//
//        }


    }
}
