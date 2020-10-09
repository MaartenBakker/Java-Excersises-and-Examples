package com.Maarten;

public class Main {

    public static void main(String[] args) {

        Car porsche = new Car();
        Car holden = new Car();


        porsche.setModel("911");
        System.out.println("Model is : " + porsche.getModel());
        holden.setModel("COMMODORE");
        System.out.println(holden.getModel());
        holden.setModel("Test");
        System.out.println(holden.getModel());

    }
}
