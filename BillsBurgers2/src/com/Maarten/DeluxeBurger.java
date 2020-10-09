package com.Maarten;

public class DeluxeBurger extends Hamburger {

    public DeluxeBurger() {
        super("Deluxe", "Sausage & Bacon", 14.53, "White");
        super.addHamburgerAddition1("Chips", 2.57);
        super.addHamburgerAddition2("Drink", 1.81);
    }


}
