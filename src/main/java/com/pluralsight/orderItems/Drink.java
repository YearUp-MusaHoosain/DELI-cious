package com.pluralsight.orderItems;

import org.apache.commons.lang3.StringUtils;

public class Drink extends FoodItem{

//    private String drinkSize;
//    private String drinkFlavor;


    public Drink(String name, double price) {
        super(name, price);
//        this.drinkSize = drinkSize;
//        this.drinkFlavor = drinkFlavor;
    }

//    public String getDrinkSize() {
//        return drinkSize;
//    }
//
//    public void setDrinkSize(String drinkSize) {
//        this.drinkSize = drinkSize;
//    }
//
//    public String getDrinkFlavor() {
//        return drinkFlavor;
//    }
//
//    public void setDrinkFlavor(String drinkFlavor) {
//        this.drinkFlavor = drinkFlavor;
//    }
//
//
//    @Override
//    public double calculatePrice() {
//        double drinkPrice = 0;
//
//        try{
//            if (drinkSize.equalsIgnoreCase("small")){
//                StringUtils.capitalize(drinkSize);
//                return drinkPrice = 2.0;
//            }
//            else if (drinkSize.equalsIgnoreCase("medium")) {
//                StringUtils.capitalize(drinkSize);
//                return drinkPrice = 2.5;
//            }
//            else if (drinkSize.equalsIgnoreCase("large")) {
//                StringUtils.capitalize(drinkSize);
//                return drinkPrice = 3.0;
//            }
//            else if (drinkSize.isEmpty()){
//                return 0;
//            }
//        } catch (Exception e) {
//            System.out.println("Invalid entry! Please choose a drink size: Small, Medium, or Large.");
//            e.printStackTrace();
//        }
//
//        return drinkPrice * getQuantity();
//    }
//
//    @Override
//    public String getName() {
//        return "";
//    }
}
