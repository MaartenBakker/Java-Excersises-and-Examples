package com.Maarten;

public class DeluxeBurger extends Hamburger {

    // Fields
    private boolean chips;
    private String drink;

    // Constructors

    public DeluxeBurger(String breadRoll, String meat, double price, String drink) {
        super(breadRoll, meat, price);
        this.chips = true;
        this.drink = drink;
    }


    // Getters & Setters

    public boolean hasChips() {
        return chips;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    // Methods


    @Override
    public void addLettuce() {
        System.out.println("Cannot add Lettuce to DeluxeBurger.");
    }

    @Override
    public void addCarrot() {
        System.out.println("Cannot add Carrot to DeluxeBurger.");
    }

    @Override
    public void addTomato() {
        System.out.println("Cannot add Tomato to DeluxeBurger.");
    }

    @Override
    public void calculatePrice() {
        System.out.println(this.getClass().getSimpleName() +  " base price: " + getPrice());
        System.out.println("Type of breadroll: " + getBreadRoll());
        System.out.println("Type of meat: " + getMeat());
        if (hasChips()) {
            System.out.println("Chips included.");
        }
        System.out.println("Type of drink: " + getDrink());
        System.out.println("Total: " + getPrice());
    }
}
