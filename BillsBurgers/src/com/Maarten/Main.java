package com.Maarten;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Hamburger basicBurger = new Hamburger("White", "Cow", 1.50);
        basicBurger.addCarrot();
        basicBurger.addLettuce();
        System.out.println();

        HealthyBurger healthyBurger = new HealthyBurger("Chicken", 1.60);
        healthyBurger.addEgg();
        healthyBurger.addTofu();
        healthyBurger.addCarrot();
        healthyBurger.addTomato();
        System.out.println();

        DeluxeBurger deluxeBurger = new DeluxeBurger("White", "Veal", 4.80, "Coke");
        deluxeBurger.addCarrot();
        deluxeBurger.setDrink("Fanta");
        System.out.println();

        Hamburger[] burgers = {basicBurger, healthyBurger, deluxeBurger};

        for (Hamburger burger : burgers) {
            burger.calculatePrice();
            System.out.println();
        }
    }

}
