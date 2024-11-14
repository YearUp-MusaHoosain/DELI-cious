package com.pluralsight.orderItems;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends FoodItem {

    public static List<Double> sandwichsizePricesArrayList = new ArrayList<>(List.of(5.50, 7.00, 8.50));
    public static List<String> sandwichSizesArrayList = new ArrayList<>(List.of("4\"", "8\"", "12\""));
    public static List<String> sandwichBreadArrayList = new ArrayList<>(List.of("White Bread", "Wheat Bread", "Rye Bread", "Wrap Bread"));

    private String sandwichBread;
    private String sandwichSize;
    private List<Toppings> toppingsList;
    boolean wantToasted;

    // CONSTRUCTORS

    public Sandwich(String name, String sandwichBread, String sandwichSize) {
        super(name, 0);
        this.sandwichBread = sandwichBread;
        this.sandwichSize = sandwichSize;
        this.toppingsList = new ArrayList<>();
        this.wantToasted = false;
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

    public boolean wantToasted() {
        return wantToasted;
    }

    public void setWantToasted(boolean wantToasted) {
        this.wantToasted = wantToasted;
    }

    public void addTopping(Toppings toppings){
        toppingsList.add(toppings);
    }

    @Override
    public double calculatePrice() {
        double basePrice = sandwichsizePricesArrayList.get(sandwichSizesArrayList.indexOf(sandwichSize));
        double toppingPrice = toppingsList.stream()
                .mapToDouble(Toppings::calculatePrice)
                .sum();

        return basePrice + toppingPrice;
    }

    @Override
    public String toString() {
        return """
                ~~~~ Order Captured! ~~~~
               
                Your sandwich is:
               
                Bread Type =\s""" + sandwichBread +
                """
                
                Bread Size =\s""" + sandwichSize +
                """
                
                Chosen Toppings =\s""" + toppingsList +
                """
                
                Toasted? =\s""" + wantToasted;


    }
}
