package com.Maarten;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Cat cat =  new Cat("Darwin");
        Lion lion = new Lion("Simba");

        cat.talk();
        lion.talk();
        lion.king();

        Cat catLion = new Lion("voorbeeld A");
        catLion.talk();
        // catLion.king niet toegankelijk;



    }
}
