package com.Maarten;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Hamburger hamburger = new Hamburger("Basic", "Sausage", 3.56, "White");

        //double price = hamburger.itemizeHamburger();
//        hamburger.addHamburgerAddition1("Tomato", 0.89);
//        hamburger.addHamburgerAddition2("Lettuce", 0.34);
//        hamburger.addHamburgerAddition3("Cheese", 1.12);
//        System.out.println("Total burger price is " + hamburger.itemizeHamburger());

        HealthyBurger healthyBurger = new HealthyBurger("Bacon", 4.15);
        healthyBurger.addHamburgerAddition1("Tomato", 0.89);
        healthyBurger.addHealthyAddition1("Egg", 3.12);
        healthyBurger.addHealthyAddition2("Lentils", 8.12);

        System.out.println("Total burger price is " + healthyBurger.itemizeHamburger());

        DeluxeBurger db = new DeluxeBurger();
        db.itemizeHamburger();

    }
}
