package com.pluralsight.checkout;

import com.pluralsight.orderItems.FoodItem;

import java.util.List;

public class Order {

    private List<FoodItem> cart;
    private double totalPrice;
    private int numberOfItems;
    private int numberOfDrinks;
    private int numberOfChips;
    private int numberOfSandwiches;

    public Order() {}

    public Order(List<FoodItem> cart, double totalPrice, int numberOfItems, int numberOfDrinks, int numberOfChips, int numberOfSandwiches) {
        this.cart = cart;
        this.totalPrice = totalPrice;
        this.numberOfItems = numberOfItems;
        this.numberOfDrinks = numberOfDrinks;
        this.numberOfChips = numberOfChips;
        this.numberOfSandwiches = numberOfSandwiches;
    }
}
