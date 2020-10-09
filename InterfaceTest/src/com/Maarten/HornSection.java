package com.Maarten;

public class HornSection extends Section {

    private Blowable member1;
    private Blowable member2;
    private Blowable member3;

    public HornSection(Blowable member1, Blowable member2, Blowable member3) {
        this.member1 = member1;
        this.member2 = member2;
        this.member3 = member3;
    }
}
