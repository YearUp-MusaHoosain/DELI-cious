package com.pluralsight.orderItems;

public class Toppings extends FoodItem{

    private boolean isPremium;

    public Toppings(String name, double price, boolean isPremium) {
        super(name, price);
        this.isPremium = isPremium;
    }

    public boolean isPremium() {
        return isPremium;
    }

    @Override
    public double calculatePrice() {
        return getPrice();
    }
}
