package com.Maarten;



public class Hamburger {

    // Fields
    private String breadRoll;
    private String meat;
    private boolean lettuce;
    private boolean tomato;
    private boolean carrot;
    private double price;

    // Constructors

    public Hamburger(String breadRoll, String meat, double price) {
        this.breadRoll = breadRoll;
        this.meat = meat;
        if (price < 0) price = 0;
        this.price = price;
        System.out.println(this.getClass().getSimpleName() +  " created with base price of: " + getPrice());
    }

    // Getters & Setters

    public String getBreadRoll() {
        return breadRoll;
    }

    public String getMeat() {
        return meat;
    }

    public boolean hasLettuce() {
        return lettuce;
    }

    public boolean hasTomato() {
        return tomato;
    }

    public boolean hasCarrot() {
        return carrot;
    }

    public double getPrice() {
        return price;
    }

    public void setLettuce(boolean lettuce) {
        this.lettuce = lettuce;
    }

    public void setTomato(boolean tomato) {
        this.tomato = tomato;
    }

    public void setCarrot(boolean carrot) {
        this.carrot = carrot;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Methods

    public void addLettuce() {
        setLettuce(true);
        System.out.println("Lettuce added.");
    }

    public void addCarrot() {
        setCarrot(true);
        System.out.println("Carrot added.");
    }

    public void addTomato() {
        setTomato(true);
        System.out.println("Tomato added.");
    }

    public void calculatePrice(){
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
        System.out.println("Total: " + getPrice());
    }


}
