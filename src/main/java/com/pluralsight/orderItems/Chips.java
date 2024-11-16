package com.pluralsight.orderItems;

import java.util.ArrayList;
import java.util.List;

public class Chips extends FoodItem{

    public Chips(String name, double price) {
        super(name, price);
    }

    @Override
    public String toString() {
        return "Chips";
    }
}
