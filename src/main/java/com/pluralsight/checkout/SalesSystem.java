package com.pluralsight.checkout;

import com.pluralsight.orderItems.Menu;

import java.util.ArrayList;
import java.util.List;

public class SalesSystem {

    private List<Order> orders;
    private Menu menu;

    public SalesSystem() {
        this.orders = new ArrayList<>();
        this.menu = new Menu();
    }

    public Menu getMenu(){
        return menu;
    }

    public void addOrder(Order order){
        orders.add(order);
    }

    public List<Order> getOrders(){
        return orders;
    }

    public Customer createCustomer(String name, String contactInfo){
        return new Customer(name, contactInfo);
    }

    public Order getOrderByID(int orderID){
        return orders.stream()
                .filter(order -> order.getOrderID() == orderID)
                .findFirst()
                .orElse(null);
    }
}
