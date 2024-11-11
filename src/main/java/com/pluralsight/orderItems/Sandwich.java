package com.pluralsight.orderItems;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends FoodItem {

    private String sandwichBread;
    private String sandwichSize;
    private String wantToasted;
    private List<Toppings> toppingsList = new ArrayList<>();

    // CONSTRUCTORS

    public Sandwich(String name, int quantity, String sandwichBread, String sandwichSize, String wantToasted) {
        super(name, quantity);
        this.sandwichBread = sandwichBread;
        this.sandwichSize = sandwichSize;
        this.wantToasted = wantToasted;
    }

    public Sandwich(String name, int quantity,String sandwichBread, String sandwichSize, String wantToasted, List<Toppings> toppingsList) {
        super(name, quantity);
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

    public String getWantToasted() {
        return wantToasted;
    }

    public void setWantToasted(String wantToasted) {
        this.wantToasted = wantToasted;
    }

    @Override
    public double calculatePrice() {
        /*
        if sandwich is 4", and regular
         */
        double sandwich = 0;


        try{
            for (String chip : chipsArray){
                if(chipsType.equalsIgnoreCase(chip)){
                    return chips = 1.5;
                }
                else if(chipsType.equalsIgnoreCase("no")){
                    return chips;
                }
                else {
                    System.out.println("Do you want chips? \nPlease say the chip type, or 'No' if you don't want chips.");
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid entry! Please choose a chip.");
            e.printStackTrace();
        }

        return chips;
    }

    @Override
    public String getName() {
        return "";
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
