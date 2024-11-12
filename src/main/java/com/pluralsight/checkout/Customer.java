package com.pluralsight.checkout;

public class Customer {

    private String name;
    private String contactInfo;

    public Customer(String name, String contactInfo) {
        this.name = name;
        this.contactInfo = contactInfo;
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public Order createOrder (int orderID){
        return new Order(orderID, this);
    }
}
