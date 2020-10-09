package com.Maarten;

public class Main {

    public static void main(String[] args) {
	// write your code here

        VipCustomer maarten = new VipCustomer("Maarten", 10000.00, "maarten@maarten.com");
        VipCustomer anna = new VipCustomer("Anna", 500.76);
        VipCustomer ella = new VipCustomer();

        System.out.println(maarten.getCredit());
        System.out.println(maarten.getEmailAddress());
        System.out.println(maarten.getName());

        System.out.println(anna.getCredit());
        System.out.println(anna.getEmailAddress());
        System.out.println(anna.getName());

        System.out.println(ella.getCredit());
        System.out.println(ella.getEmailAddress());
        System.out.println(ella.getName());

    }
}
