package com.pluralsight.orderItems;

import org.apache.commons.lang3.StringUtils;

public class Drink extends FoodItem{

    public Drink(String name, double price) {
        super(name, price);
    }

    @Override
    public String toString() {
        return getName();
    }
}
