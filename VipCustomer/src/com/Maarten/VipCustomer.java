package com.Maarten;

public class VipCustomer {

    private String name;
    private double credit;
    private String emailAddress;

    public String getName() {
        return name;
    }

    public double getCredit() {
        return credit;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public VipCustomer() {
        this("defaultName", 0.00, "defaultEmail");
    }

    public VipCustomer(String name, double credit) {
        this(name, credit, "defaultEmail");
    }

    public VipCustomer(String name, double credit, String emailAddress) {
        this.name = name;
        this.credit = credit;
        this.emailAddress = emailAddress;
    }
}
