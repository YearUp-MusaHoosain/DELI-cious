package com.pluralsight.orderItems;

import com.pluralsight.interfaces.FoodItemInterface;

import java.util.ArrayList;

public abstract class FoodItem implements FoodItemInterface{

    private String name;
    private double price;
    static ArrayList<FoodItem> cart = new ArrayList<FoodItem>();

    public FoodItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public double calculatePrice() {
        return 0;
    }

    @Override
    public String getName() {
        return "";
    }
}
