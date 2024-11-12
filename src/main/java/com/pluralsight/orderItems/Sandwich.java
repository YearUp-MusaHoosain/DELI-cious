package com.pluralsight.orderItems;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends FoodItem {

    private List<Double> sizePricesArrayList = new ArrayList<>(List.of(5.50, 7.00, 8.50));
    private List<String> sandwichSizesArrayList = new ArrayList<>(List.of("4\"", "8\"", "12\""));
    private List<String> sandwichBreadArrayList = new ArrayList<>(List.of("white", "wheat", "rye", "wrap"));

    private String sandwichBread;
    private String sandwichSize;
    private boolean wantToasted;
    private List<Toppings> toppingsList = new ArrayList<>();

    // CONSTRUCTORS

    public Sandwich(String name, String sandwichBread, String sandwichSize, boolean wantToasted) {
        super(name, 0);
        this.sandwichBread = sandwichBread;
        this.sandwichSize = sandwichSize;
        this.wantToasted = wantToasted;
    }

    public Sandwich(String name, String sandwichBread, String sandwichSize, boolean wantToasted, List<Toppings> toppingsList) {
        super(name, 0);
        this.sandwichBread = sandwichBread;
        this.sandwichSize = sandwichSize;
        this.wantToasted = wantToasted;
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

    public boolean isToasted() {
        return wantToasted;
    }

    public void setWantToasted(boolean wantToasted) {
        this.wantToasted = wantToasted;
    }

    @Override
    public double calculatePrice() {
        double basePrice = sizePricesArrayList.get(sandwichSizesArrayList.indexOf(sandwichSize));
        double toppingPrice = toppingsList.stream()
                .mapToDouble(Toppings::calculatePrice)
                .sum();

        return basePrice + toppingPrice;
    }


}
