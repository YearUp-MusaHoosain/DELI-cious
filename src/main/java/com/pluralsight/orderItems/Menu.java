package com.pluralsight.orderItems;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private List<Toppings> toppingsList;
    private List<Drink> drinkList;
    private List<Chips> chipsList;

    public Menu() {
        this.toppingsList = new ArrayList<>();
        this.drinkList = new ArrayList<>();
        this.chipsList = new ArrayList<>();
        createMenu();
    }

    public List<Toppings> getToppingsList(){
        return toppingsList;
    }

    public List<Drink> getDrinkList() {
        return drinkList;
    }

    public List<Chips> getChipsList() {
        return chipsList;
    }

    // TODO: CHANGE TO ACCOMMODATE FOR ALL SANDWICH SIZES
    private void createMenu(){
        // ----- MEATS -----
        toppingsList.add(new Toppings("Steak", 1.00, true));
        toppingsList.add(new Toppings("Ham", 1.00, true));
        toppingsList.add(new Toppings("Salami", 1.00, true));
        toppingsList.add(new Toppings("Roast Beef", 1.00, true));
        toppingsList.add(new Toppings("Chicken", 1.00, true));
        toppingsList.add(new Toppings("Bacon", 1.00, true));

        // ----- CHEESES -----
        toppingsList.add(new Toppings("American Cheese", 0.75, true));
        toppingsList.add(new Toppings("Provolone Cheese", 0.75, true));
        toppingsList.add(new Toppings("Cheddar Cheese", 0.75, true));
        toppingsList.add(new Toppings("Swiss Cheese", 0.75, true));

        // ----- REGULAR TOPPINGS -----
        toppingsList.add(new Toppings("Lettuce", 0.00, false));
        toppingsList.add(new Toppings("Peppers", 0.00, false));
        toppingsList.add(new Toppings("Onions", 0.00, false));
        toppingsList.add(new Toppings("Tomatoes", 0.00, false));
        toppingsList.add(new Toppings("Jalapenos", 0.00, false));
        toppingsList.add(new Toppings("Cucumbers", 0.00, false));
        toppingsList.add(new Toppings("Pickles", 0.00, false));
        toppingsList.add(new Toppings("Guacamole", 0.00, false));
        toppingsList.add(new Toppings("Mushrooms", 0.00, false));

        // ----- SAUCES -----
        toppingsList.add(new Toppings("Mayo", 0.00, false));
        toppingsList.add(new Toppings("Mustard", 0.00, false));
        toppingsList.add(new Toppings("Ketchup", 0.00, false));
        toppingsList.add(new Toppings("Ranch", 0.00, false));
        toppingsList.add(new Toppings("Thousand Islands", 0.00, false));
        toppingsList.add(new Toppings("Vinaigrette", 0.00, false));

        // ----- SIDES -----
        toppingsList.add(new Toppings("Au jus", 0.00, false));
        toppingsList.add(new Toppings("Sauce", 0.00, false));


        // ----- DRINKS -----
        drinkList.add(new Drink("Small Drink", 2.00));
        drinkList.add(new Drink("Medium Drink", 2.50));
        drinkList.add(new Drink("Large Drink", 3.00));

        // ----- CHIPS -----
        chipsList.add(new Chips("Chips", 1.50));

    }

}
