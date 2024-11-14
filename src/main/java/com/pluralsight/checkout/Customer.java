package com.pluralsight.checkout;

public class Customer {

    private String name;
    private String phoneNumber;

    public Customer(String name, String contactInfo) {
        this.name = name;
        this.phoneNumber = contactInfo;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Order createOrder (int orderID){
        return new Order(orderID, this);
    }
}
