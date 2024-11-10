package com.pluralsight.orderItems;

public abstract class FoodItem {

    private String name;
    private int quantity;

    public abstract double calculatePrice();
}
