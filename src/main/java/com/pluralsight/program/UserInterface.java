package com.pluralsight.program;

import com.pluralsight.checkout.Customer;
import com.pluralsight.checkout.Order;
import com.pluralsight.checkout.SalesSystem;
import com.pluralsight.fileManager.OrderFileManager;
import com.pluralsight.interfaces.FoodItemInterface;
import com.pluralsight.orderItems.Chips;
import com.pluralsight.orderItems.Drink;
import com.pluralsight.orderItems.Sandwich;
import com.pluralsight.orderItems.Toppings;
import com.pluralsight.utils.Console;


public class UserInterface {

    private static SalesSystem salesSystem = new SalesSystem();
    private static OrderFileManager orderFileManager = new OrderFileManager();

    public UserInterface() {
    }


    // HOME SCREEN
    public void homeScreenDisplay() {

        String options = """
                ╔════════════════════════════════════════════════╗
                ║  +++++++++  WELCOME TO DELI-cious!  +++++++++  ║
                ╠════════════════════════════════════════════════╣
                ║                                                ║
                ║    Please select from the following choices:   ║
                ║                                                ║
                ║        1 - New Order                           ║
                ║        0 - Quit                                ║
                ║                                                ║
                ╚════════════════════════════════════════════════╝
                
                >>> Enter your choice here:\s""";

        int selection = 0;

        // HOME SCREEN OPTIONS LOOP

        do {
            try {
                selection = Console.PromptForInt(options);
                switch (selection) {
                    case 1 -> {
                        Console.displayDelayedString("\nDisplaying Order Screen...\n");
                        orderScreenDisplay();
                    }
                    case 0 -> {
                        Console.displayDelayedString("\nExiting...\n");
                        Console.displayDelayedString("Thank you, have a nice day!");
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid choice! Please try again.");
                }
            } catch (Exception e) {
                e.getMessage();
                e.printStackTrace();
            }
        } while (selection != 0);


    }


    // ORDER SCREEN
    public void orderScreenDisplay() {

        System.out.println("""
                 ╔════════════════════════════════════════════════╗
                 ║                 Customer Info                  ║
                 ╠════════════════════════════════════════════════╣
                 ║                                                ║
                 ║           To Order, Please enter your          ║
                 ║        name and your contact info below        ║
                 ║                                                ║
                 ╚════════════════════════════════════════════════╝
                \s""");


        String customerName = Console.PromptForString(">>> Enter customer name: ");
        String customerContactInfo = Console.PromptForString(">>> Enter customer phone number: ");

        // CUSTOMER CLASS CREATES CUSTOMER INSTANCES OF NAME AND CONTACT INFO
        // ORDER CLASS CREATES ORDER INSTANCES BY ORDERID
        Customer customer = salesSystem.createCustomer(customerName, customerContactInfo);
        Order order = customer.createOrder(salesSystem.validateOrderID());

        Console.displayDelayedString("\nThank you! Displaying Order Screen now...\n");

        String options = """
                ╔════════════════════════════════════════════════╗
                ║                  ORDER SCREEN                  ║
                ╠════════════════════════════════════════════════╣
                ║                                                ║
                ║   Please select from the following choices:    ║
                ║                                                ║
                ║        1 - Add Sandwich                        ║
                ║        2 - Add Drink                           ║
                ║        3 - Add Chips                           ║
                ║        4 - Checkout                            ║
                ║        0 - Cancel Order                        ║
                ║                                                ║
                ╚════════════════════════════════════════════════╝
                
                >>> Enter your choice here:\s""";

        int selection = 0;

        // ORDER SCREEN OPTIONS LOOP

        do {
            try {
                selection = Console.PromptForInt(options);
                switch (selection) {
                    case 1 -> {
                        Console.displayDelayedString("\nDisplaying Add Sandwich Screen...\n");
                        addSandwichScreenDisplay(order);
                    }
                    case 2 -> {
                        Console.displayDelayedString("\nDisplaying Drink Screen...\n");
                        processAddDrinkRequest(order);
                    }
                    case 3 -> {
                        Console.displayDelayedString("\nDisplaying Chips Screen...\n");
                        processAddChipsRequest(order);
                    }
                    case 4 -> {
                        Console.displayDelayedString("\nDisplaying Checkout Screen...\n");
                        checkoutScreenDisplay(order);
                    }
                    case 0 -> {
                        Console.displayDelayedString("\nDisplaying order to cancel...\n");
                        processCancelOrderRequest(order);
                        return;
                    }
                    default -> System.out.println("Invalid choice! Please try again.");
                }
            } catch (Exception e) {
                e.getMessage();
                e.printStackTrace();
            }
        } while (selection != 0);


    }

    private void processAddDrinkRequest(Order order) {

        Runnable drinkLoop = () -> {
            for (int i = 0; i < salesSystem.getMenu().getDrinkList().size(); i++) {
                Drink drink = salesSystem.getMenu().getDrinkList().get(i);
                System.out.println("║        " + (i + 1) + " - " + drink.getName() + "                         ║");
            }
        };

        System.out.println("""
                ╔════════════════════════════════════════════════╗
                ║                  DRINK SCREEN                  ║
                ╠════════════════════════════════════════════════╣
                ║                                                ║
                ║   Please select from the following choices:    ║
                ║                                                ║""");
        drinkLoop.run();
        System.out.println("""
                ║                                                ║
                ╚════════════════════════════════════════════════╝
                """);

        try {
            System.out.println("Select Drink:");
            int customerDrink = Console.PromptForInt(">>> Enter (1), (2), (3) for drink: ");
            Drink drink = salesSystem.getMenu().getDrinkList().get(customerDrink - 1);
            order.addItem(drink);
            Console.displayMoreDelayedString("\n ----- Selected \"" + drink + "\". Added to Checkout! -----\n");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private void processAddChipsRequest(Order order) {

        Runnable chipsLoop = () -> {
            for (int i = 0; i < salesSystem.getMenu().getChipsList().size(); i++) {
                Chips chips = salesSystem.getMenu().getChipsList().get(i);
                System.out.println("║        " + (i + 1) + " - " + chips.getName() + "                               ║");
            }
        };


        System.out.println("""
                ╔════════════════════════════════════════════════╗
                ║                  ORDER SCREEN                  ║
                ╠════════════════════════════════════════════════╣
                ║                                                ║
                ║   Please select from the following choices:    ║
                ║                                                ║""");
        chipsLoop.run();
        System.out.println("""
                ║                                                ║
                ╚════════════════════════════════════════════════╝
                """);
        System.out.println("Select Chips:");


        int customerChips = Console.PromptForInt(">>> Select Chips: ");
        Drink chips = salesSystem.getMenu().getDrinkList().get(customerChips - 1);
        order.addItem(chips);
        Console.displayMoreDelayedString("\n ----- Selected \"" + chips + "\". Added to Checkout! -----\n");
    }


    // ADD SANDWICH DISPLAY
    private void addSandwichScreenDisplay(Order order) {
        String orderScreenOptions = """
                ╔═══════════════════════════════════════════════════════════════════════════╗
                ║                            ADD SANDWICH SCREEN                            ║
                ╠═══════════════════════════════════════════════════════════════════════════╣
                ║                                                                           ║
                ║                         Please make selections for                        ║
                ║                           the following choices:                          ║
                ║                                                                           ║
                ║===========================================================================║
                ║                                                                           ║
                ║                    ---------- Select Bread: ----------                    ║
                ║                      -------------------------------                      ║
                ║                                                                           ║
                ║                                 1) White                                  ║
                ║                                 2) Wheat                                  ║
                ║                                 3) Rye                                    ║
                ║                                 4) Wrap                                   ║
                ║                                                                           ║
                ║---------------------------------------------------------------------------║
                ║                                                                           ║
                ║                  -------- Select Sandwich Size: --------                  ║
                ║                      -------------------------------                      ║
                ║                                                                           ║
                ║                                 1) 4"                                     ║
                ║                                 2) 8"                                     ║
                ║                                 3) 12"                                    ║
                ║                                                                           ║
                ║---------------------------------------------------------------------------║
                ║                                                                           ║
                ║                      ---------- Toppings: ----------                      ║
                ║                      -------------------------------                      ║
                ║                                                                           ║
                ║     ($ Premium $) | ($ Premium $) |   (Regular)    |   (Regular)          ║
                ║       * Meats *   |  * Cheese *   |  * Veggies *   |  * Sauces *          ║
                ║                                                                           ║
                ║    (1) steak      | (7) American  | (11) lettuce   | (20) Mayo            ║
                ║    (2) ham        | (8) Provolone | (12) peppers   | (21) Mustard         ║
                ║    (3) salami     | (9) Cheddar   | (13) onions    | (22) Ketchup         ║
                ║    (4) roast beef | (10) Swiss    | (14) tomatoes  | (23) Ranch           ║
                ║    (5) chicken    |               | (15) jalapenos | (24) Thousand        ║
                ║    (6) bacon      |               | (16) cucumbers |      Islands         ║
                ║                   |               | (17) pickles   | (25) Vinaigrette     ║
                ║                   |               | (18) guacamole | (26) Au Jus          ║
                ║                   |               | (19) mushrooms | (27) Sauce           ║
                ║                   |               |                |                      ║
                ║                                                                           ║
                ║---------------------------------------------------------------------------║
                ║                                                                           ║
                ║                   Would you like the sandwich toasted?                    ║
                ║                                                                           ║
                ║---------------------------------------------------------------------------║
                ║                                                                           ║
                ║                            0 - Cancel Order                               ║
                ║                                                                           ║
                ╚═══════════════════════════════════════════════════════════════════════════╝
                """;

        System.out.println(orderScreenOptions);

        int breadChoice = 0;
        int sizeChoice = 0;

        boolean t = true;
        while (t){
            try {
                breadChoice = Console.PromptForInt(">>> Select Bread (Or Select 0 to Cancel Order): ");
                sizeChoice = Console.PromptForInt(">>> Select Size (Or Select 0 to Cancel Order): ");
            } catch (Exception e) {
                System.out.println("Error! Please enter a valid input");
                e.printStackTrace();
            } finally {
                t = false;
            }
        }


        try {
            int toppingChoice;
            if (breadChoice >= 1 && breadChoice <= Sandwich.sandwichBreadArrayList.size() &&
                    sizeChoice >= 1 && sizeChoice <= Sandwich.sandwichSizesArrayList.size()) {

                Sandwich sandwich = new Sandwich("Sandwich", Sandwich.sandwichBreadArrayList.get(breadChoice - 1), Sandwich.sandwichSizesArrayList.get(sizeChoice - 1));

                do {
                    try {
                        toppingChoice = Console.PromptForInt(">>> Add Toppings (Done with toppings? Enter 99 | Want to Cancel Order? Enter 0): ");
                        if (toppingChoice == 99) {
                            break;
                        } else if (toppingChoice == 0) {
                            order.removeAllItems();
                            homeScreenDisplay();
                            return;
                        } else {
                            Toppings topping = salesSystem.getMenu().getToppingsList().get(toppingChoice - 1);
                            sandwich.addTopping(topping);
                        }
                    } catch (Exception e) {
                        System.out.println("Error! Please enter a valid input");
                        e.getMessage();
                    }

                } while (true);


                String toastedChoice = Console.PromptForString(">>> Would you like the sandwich toasted? (yes / no): ");
                sandwich.setWantToasted(toastedChoice.equalsIgnoreCase("yes"));
                System.out.println("""
                        
                        -------------------------------------------------------------
                        
                        """ + sandwich + """
                        
                        
                        -------------------------------------------------------------
                        """);

                order.addItem(sandwich);
            } else if (breadChoice == 0 || sizeChoice == 0) {
                order.removeAllItems();
                homeScreenDisplay();
                return;
            } else {
                System.out.println("Invalid choice. Please select a valid option.");
            }
        } catch (Exception e) {
            System.out.println("ERROR!! Please enter a valid option");
            e.printStackTrace();
        }
    }


    // CHECKOUT SCREEN
    private void checkoutScreenDisplay(Order order) {
        String options = """
                ╔════════════════════════════════════════════════╗
                ║                 CHECKOUT SCREEN                ║
                ╠════════════════════════════════════════════════╣
                ║                                                ║
                ║    Please select from the following choices:   ║
                ║                                                ║
                ║        1 - Confirm Order                       ║
                ║        0 - Cancel Order                        ║
                ║                                                ║
                ╚════════════════════════════════════════════════╝
                
                >>> Enter your choice here:\s""";

        int selection;

        // CHECKOUT SCREEN OPTIONS LOOP
        do {
            selection = Console.PromptForInt(options);
            switch (selection) {
                case 1 -> {
                    Console.displayDelayedString("\nDisplaying Order Confirmation Screen...\n");
                    processConfirmOrderRequest(order);
                }
//                case 2 -> processModifyOrderRequest(order);
                case 0 -> {
                    Console.displayDelayedString("\nDisplaying order to cancel...\n");
                    processCancelOrderRequest(order);
                    return;
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        } while (selection != 0);
    }


    private void processConfirmOrderRequest(Order order) {
        System.out.println("Order details:");
        for (FoodItemInterface item : order.getFoodItemInterfaces()) {
            if (item instanceof Sandwich) {
                Sandwich sandwich = (Sandwich) item;
//                System.out.println(sandwich.getSandwichSize() + " Sandwich on " + sandwich.getSandwichBread() + " - $" + sandwich.calculatePrice());
                System.out.printf("%s Sandwich on %s - %.2f\n", sandwich.getSandwichSize(), sandwich.getSandwichBread(), sandwich.calculatePrice());
                System.out.println("Toppings:");
                for (Toppings topping : sandwich.getToppingsList()) {
                    System.out.println("  + " + topping.getName());
                }
                System.out.println("- Toasted: " + (sandwich.wantToasted() ? "Yes" : "No"));
            } else if (item instanceof Drink) {
                Drink drink = (Drink) item;
//                System.out.println(drink.getName() + " - $" + drink.getPrice());
                System.out.printf("- %s - $%.2f\n", drink.getName(), drink.getPrice());
            } else if (item instanceof Chips) {
                Chips chips = (Chips) item;
//                System.out.println(chips.getName() + " - $" + chips.getPrice());
                System.out.printf("- %s - $%.2f\n", chips.getName(), chips.getPrice());
            }
        }
//        System.out.println("Total: $" + order.getTotalPrice());
        System.out.println("\n\n========================");
        System.out.printf("      Total: $%.2f", order.getTotalPrice());
        System.out.println("\n========================");

        String options = """
                
                -------- Ready to Complete the Order? --------
                            1) Yes
                            2) No
                ----------------------------------------------
                
                >>> Enter Choice:\s""";

        int selection;

        do {
            selection = Console.PromptForInt(options);
            switch (selection) {
                case 1 -> {
                    orderFileManager.saveReceipt(order);
//                    order.saveReceipt();
                    Console.displayDelayedString("""
                            
                            ╭⋆✧✦✧⋆━━━━━━━━━━━━━━━━━━━━━━━━━━⋆✧✦✧⋆╮
                            ┃                                       ┃
                            ┃          ★ ORDER CONFIRMED! ★        ┃
                            ┃                                       ┃
                            ┃    --- Returning to Home Screen ---   ┃
                            ┃                                       ┃
                            ╰⋆✧✦✧⋆━━━━━━━━━━━━━━━━━━━━━━━━━━⋆✧✦✧⋆╯
                            
                            """);
                    order.removeAllItems();
                    return;
                }
                case 2 -> {
                    Console.displayDelayedString("""
                            -------- Returning to Home Screen --------
                            """);
                    return;
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        } while (true);

    }

//    private void processModifyOrderRequest(Order order) {
//        System.out.println("Order details:");
//        for (FoodItemInterface item : order.getFoodItems()) {
//            if (item instanceof Sandwich) {
//                Sandwich sandwich = (Sandwich) item;
//                System.out.println(sandwich.getSandwichSize() + " Sandwich on " + sandwich.getSandwichBread() + " - $" + sandwich.calculatePrice());
//                System.out.println("- Toppings:");
//                for (Toppings topping : sandwich.getToppingsList()) {
//                    System.out.println("  + " + topping.getName());
//                }
//                System.out.println("- Toasted: " + (sandwich.wantToasted() ? "Yes" : "No"));
//            }
//            else if (item instanceof Drink) {
//                Drink drink = (Drink) item;
//                System.out.println(drink.getName() + " - $" + drink.getPrice());
//            }
//            else if (item instanceof Chips) {
//                Chips chips = (Chips) item;
//                System.out.println(chips.getName() + " - $" + chips.getPrice());
//            }
//        }
//        System.out.println("\n========================");
//        System.out.println("Total: $" + order.getTotalPrice());
//        System.out.println("\n========================\n\n");
//
//        String userInput = Console.PromptForString("-------- What item to remove from your order? --------");
//        System.out.println("-------- (Enter 0 ) --------");
//
//        do {
//            for (FoodItemInterface item : order.getFoodItems()) {
//                if (item instanceof Sandwich) {
//                    Sandwich sandwich = (Sandwich) item;
//                    order.removeItem(sandwich);
//                    for (Toppings topping : sandwich.getToppingsList()) {
//                        order.removeItem(topping);
//                    }
////                order.removeItem();
//                    System.out.println("- Toasted: " + (sandwich.wantToasted() ? "Yes" : "No"));
//                }
//                else if (item instanceof Drink) {
//                    Drink drink = (Drink) item;
//                    order.removeItem(drink);
//                }
//                else if (item instanceof Chips) {
//                    Chips chips = (Chips) item;
//                    order.removeItem(chips);
//                }
//            }
//        }while();
//
//
//
//
//    }

    private void processCancelOrderRequest(Order order) {
        System.out.println("Order details:");
        for (FoodItemInterface item : order.getFoodItemInterfaces()) {
            if (item instanceof Sandwich) {
                Sandwich sandwich = (Sandwich) item;
                System.out.println(sandwich.getSandwichSize() + " Sandwich on " + sandwich.getSandwichBread() + " - $" + sandwich.calculatePrice());
                System.out.println("- Toppings:");
                for (Toppings topping : sandwich.getToppingsList()) {
                    System.out.println("  + " + topping.getName());
                }
                System.out.println("- Toasted: " + (sandwich.wantToasted() ? "Yes" : "No"));
            } else if (item instanceof Drink) {
                Drink drink = (Drink) item;
                System.out.println(drink.getName() + " - $" + drink.getPrice());
            } else if (item instanceof Chips) {
                Chips chips = (Chips) item;
                System.out.println(chips.getName() + " - $" + chips.getPrice());
            }
        }
        System.out.println("Total: $" + order.getTotalPrice());

        String options = """
                -------- Are you sure you want to delete your order? --------
                            1) Yes
                            2) No
                """;

        int selection;

        do {
            selection = Console.PromptForInt(options);
            switch (selection) {
                case 1 -> {
                    order.removeAllItems();
                    Console.displayDelayedString("""
                            -------- All Items Removed From Order --------
                            """);
                    return;
                }
                case 2 -> {
                    Console.displayDelayedString("""
                            -------- Not Cancelling, Keeping Order --------
                            """);
                    return;
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        } while (true);


    }
}
