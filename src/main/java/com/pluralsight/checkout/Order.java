package com.pluralsight.checkout;

import com.pluralsight.interfaces.FoodItemInterface;
import com.pluralsight.orderItems.FoodItem;
import com.pluralsight.orderItems.Sandwich;
import com.pluralsight.orderItems.Toppings;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Order {

    private int orderID;
    private Customer customer;
    private List<FoodItemInterface> foodItemInterfaces;
    private double totalPrice;

    public Order(int id, Customer customer){
        this.orderID = id;
        this.customer = customer;
        this.foodItemInterfaces = new ArrayList<>();
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

    public List<FoodItemInterface> getFoodItemInterfaces() {
        return foodItemInterfaces;
    }

    public void setFoodItemInterfaces(List<FoodItemInterface> foodItemInterfaces) {
        this.foodItemInterfaces = foodItemInterfaces;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void addItem(FoodItem foodItem){
        foodItemInterfaces.add(foodItem);
        totalPrice = totalPrice + foodItem.calculatePrice();
    }

    public void removeItem(FoodItem foodItem){
        foodItemInterfaces.remove(foodItem);
        totalPrice = totalPrice + foodItem.calculatePrice();
    }

    public void removeAllItems(){
        foodItemInterfaces.clear();
        totalPrice = 0.0;
    }

}
