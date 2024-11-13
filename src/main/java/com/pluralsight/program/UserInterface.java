package com.pluralsight.program;

import com.pluralsight.checkout.Customer;
import com.pluralsight.checkout.Order;
import com.pluralsight.checkout.SalesSystem;
import com.pluralsight.orderItems.Chips;
import com.pluralsight.orderItems.Drink;
import com.pluralsight.orderItems.Sandwich;
import com.pluralsight.orderItems.Toppings;
import com.pluralsight.utils.Console;

public class UserInterface {

    private static SalesSystem salesSystem = new SalesSystem();

    public UserInterface(){}


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
            try{
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
        Order order = customer.createOrder(salesSystem.getOrders().size() + 1);

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
                try{
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
                        checkoutScreenDisplay();
                    }
                    case 0 -> {
                        Console.displayDelayedString("\n\"Cancelling order, and returning to Home Screen...\n");
                        processCancelOrderRequest();
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
            for (int i = 0; i < salesSystem.getMenu().getChipsList().size(); i++){
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
                ║                                 1) white                                  ║
                ║                                 2) wheat                                  ║
                ║                                 3) rye                                    ║
                ║                                 4) wrap                                   ║
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
                \n""";

        System.out.println(orderScreenOptions);

        int breadChoice = Console.PromptForInt(">>> Select Bread: ");
        int sizeChoice = Console.PromptForInt(">>> Select Size: ");

        try{
            if (breadChoice >=1 && breadChoice <= Sandwich.sandwichBreadArrayList.size() &&
                    sizeChoice >= 1 && sizeChoice <= Sandwich.sandwichSizesArrayList.size()){

                Sandwich sandwich = new Sandwich("Sandwich", Sandwich.sandwichBreadArrayList.get(breadChoice - 1), Sandwich.sandwichSizesArrayList.get(sizeChoice - 1));

                while (true){
                    int toppingChoice = Console.PromptForInt(">>> Add Toppings (Done with toppings? Enter 0): ");
                    if (toppingChoice == 0){
                        break;
                    }
                    else {
                        Toppings topping = salesSystem.getMenu().getToppingsList().get(toppingChoice - 1);
                        sandwich.addTopping(topping);
                    }
                }
                String toastedChoice = Console.PromptForString(">>> Would you like the sandwich toasted? (yes / no): ");
                sandwich.setWantToasted(toastedChoice.equalsIgnoreCase("yes"));

                order.addItem(sandwich);
            }
            else if (userInput == 0) {

                return;
            }
            else{
                System.out.println("Invalid choice. Please select a valid option.");
            }
        } catch (Exception e) {
            System.out.println("ERROR!! Please enter a valid option");
            e.printStackTrace();
        }
    }




    // CHECKOUT SCREEN
    private void checkoutScreenDisplay() throws InterruptedException {
        String options = """
                ╔════════════════════════════════════════════════╗
                ║                 CHECKOUT SCREEN                ║
                ╠════════════════════════════════════════════════╣
                ║                                                ║
                ║    Please select from the following choices:   ║
                ║                                                ║
                ║        1 - Confirm Order                       ║
                ║        2 - Modify Order                        ║
                ║        0 - Cancel Order                        ║
                ║                                                ║
                ╚════════════════════════════════════════════════╝
                
                >>> Enter your choice here:\s""";

        int selection;

        // CHECKOUT SCREEN OPTIONS LOOP
        do {
            selection = Console.PromptForInt(options);
            switch (selection) {
                case 1 -> processConfirmOrderRequest();
                case 2 -> processModifyOrderRequest();
                case 0 -> {
                    System.out.println("Cancelling order, and returning to Home Screen...");
                    Thread.sleep(500);

                    processCancelOrderRequest();
                    return;
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        } while (selection != 0);
    }


    private void processConfirmOrderRequest() {
        System.out.println("Confirm Order");
        System.out.println("create the receipt file and go back to the home screen");
    }

    private void processModifyOrderRequest() {
        System.out.println("Modify Order");
    }

    private void processCancelOrderRequest() {
        System.out.println("Cancel Order");
        System.out.println("delete order and go back to the home screen");
    }




}
