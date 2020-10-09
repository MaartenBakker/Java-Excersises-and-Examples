package com.Maarten;

public class Dog extends Animal  {

    private int eyes;
    private int teeth;
    private int legs;
    private int tail;
    private String coat;

    public Dog(String name,  int size, int weight, int eyes, int teeth, int legs, int tail, String coat) {
        super(name, 1, 1, size, weight);
        this.eyes = eyes;
        this. teeth = teeth;
        this.legs = legs;
        this.tail = tail;
        this.coat = coat;
    }

    private void chew(){
        System.out.println("Dog.chew() called");
    }

    public void walk(){
        System.out.println("Dog.walk() called");
        super.move(5);
    }

    public void run(){
        System.out.println("Dog.run() called");
        move(10);
    }

    @Override
    public void move(int speed) {
        System.out.println("Dog.move() called");
        moveLegs(speed);
        super.move(speed);
    }

    private void moveLegs(int speed){
        System.out.println("Dog.moveLegs called");
    }

    @Override
    public void eat() {
        System.out.println("Dog.eat() called");
        chew();
        super.eat();
    }
}
