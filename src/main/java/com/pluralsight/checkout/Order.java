package com.pluralsight.checkout;

import com.pluralsight.orderItems.FoodItem;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private int orderID;
    private Customer customer;
    private List<FoodItem> foodItems;
    private double totalPrice;

    public Order(int orderID, Customer customer){
        this.orderID = orderID;
        this.customer = customer;
        this.foodItems = new ArrayList<>();
        this.totalPrice = 0.0;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<FoodItem> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void addItem(FoodItem foodItem){
        foodItems.add(foodItem);
        totalPrice = totalPrice + foodItem.calculatePrice();
    }
}
