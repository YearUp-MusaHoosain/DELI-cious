package com.pluralsight.orderItems;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends FoodItem {

    private String sandwichBread;
    private String sandwichSize;
    private List<Toppings> toppingsList = new ArrayList<>();

    // CONSTRUCTORS
    public Sandwich(){}

    public Sandwich(String sandwichBread, String sandwichSize) {
        this.sandwichBread = sandwichBread;
        this.sandwichSize = sandwichSize;
    }

    public Sandwich(String sandwichBread, String sandwichSize, List<Toppings> toppingsList) {
        this.sandwichBread = sandwichBread;
        this.sandwichSize = sandwichSize;
        this.toppingsList = toppingsList;
    }

    // SETTERS AND GETTERS
    public String getSandwichBread() {
        return sandwichBread;
    }

    public void setSandwichBread(String sandwichBread) {
        this.sandwichBread = sandwichBread;
    }

    public String getSandwichSize() {
        return sandwichSize;
    }

    public void setSandwichSize(String sandwichSize) {
        this.sandwichSize = sandwichSize;
    }

    public List<Toppings> getToppingsList() {
        return toppingsList;
    }

    public void setToppingsList(List<Toppings> toppingsList) {
        this.toppingsList = toppingsList;
    }

    @Override
    public double calculatePrice() {
        return 0;
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "sandwichBread='" + sandwichBread + '\'' +
                ", sandwichSize='" + sandwichSize + '\'' +
                ", toppingsList=" + toppingsList +
                '}';
    }
}
