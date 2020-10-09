package com.Maarten;

public class HealthyBurger extends Hamburger {
    // Fields
    private boolean egg;
    private boolean tofu;

    // Constructors

    public HealthyBurger(String meat, double price) {
        super("Brown Rye", meat, price);

    }

    // Getters & Setters

    public boolean hasEgg() {
        return egg;
    }

    public void setEgg(boolean egg) {
        this.egg = egg;
    }

    public boolean hasTofu() {
        return tofu;
    }

    public void setTofu(boolean tofu) {
        this.tofu = tofu;
    }


    // Methods

    public void addEgg() {
        setEgg(true);
        System.out.println("Egg added.");
    }

    public void addTofu() {
        System.out.println(("Tofu added."));
    }

    @Override
    public void calculatePrice() {
        System.out.println(this.getClass().getSimpleName() +  " base price: " + getPrice());
        System.out.println("Type of breadroll: " + getBreadRoll());
        System.out.println("Type of meat: " + getMeat());

        if (hasLettuce()) {
            System.out.println("Lettuce: 0.30");
            setPrice(getPrice() + 0.30);
        }
        if (hasCarrot()) {
            System.out.println("Carrot 0.50");
            setPrice(getPrice() + 0.50);
        }
        if (hasTomato()) {
            System.out.println("Tomato 0.40");
            setPrice((getPrice() + 0.40));
        }
        if (hasEgg()) {
            System.out.println("Egg 0.70");
            setPrice((getPrice() + 0.70));
        }
        if (hasTofu()) {
            System.out.println("Tofu 1.10");
            setPrice((getPrice() + 1.10));
        }
        System.out.println("Total: " + getPrice());
    }
}
