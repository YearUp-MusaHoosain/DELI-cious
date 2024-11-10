package com.pluralsight.orderItems;

public class Chips extends FoodItem{

    private String chipsType;
    private final String[] chipsArray = {"potato chips", "corn chips", "tortilla chips", "bean chips"};

    public String getChipsType() {
        return chipsType;
    }

    public void setChipsType(String chipsType) {
        this.chipsType = chipsType;
    }

    public Chips(String chipsType) {
        this.chipsType = chipsType;
    }

    public String[] getChipsArray() {
        return chipsArray;
    }

    @Override
    public double calculatePrice() {
        double chips = 0;

        // todo: get feedback if i need to add user input here

        try{
            for (String chip : chipsArray){
                if(chipsType.equalsIgnoreCase(chip)){
                    return chips = 1.5;
                }
                else if(chipsType.equalsIgnoreCase("no")){
                    return chips;
                }
                else {
                    System.out.println("Do you want chips? \nPlease say 'yes' or 'no'.");
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid entry! Please choose a chip.");
            e.printStackTrace();
        }

        return chips;
    }
}
