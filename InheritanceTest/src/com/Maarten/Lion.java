package com.Maarten;

public class Lion extends Cat {

    public Lion(String name) {
        super(name);
        System.out.println("A new lion is born with the name of " + getName());
    }

    @Override
    public void talk() {
        System.out.println("Lion.talk()");
        System.out.println("Rawr");
    }

    public void king() {
        System.out.println("Lion.king()");
        System.out.println("Aaaaah simbanya wabagee seemawoo");
    }

}
