package com.Maarten;

public class Cat {

    private String name;

    public Cat() {
    }

    public Cat(String name) {
        this.name = name;
        System.out.println("A new cat is born with the name of " + this.name);
    }

    public void talk(){
        System.out.println("Cat.talk()");
        System.out.println("Miauw");
    }

    public String getName() {
        return name;
    }
}
