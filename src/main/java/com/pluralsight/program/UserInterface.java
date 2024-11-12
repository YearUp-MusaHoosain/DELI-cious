package com.pluralsight.program;

import com.pluralsight.checkout.Customer;
import com.pluralsight.checkout.Order;
import com.pluralsight.checkout.SalesSystem;
import com.pluralsight.orderItems.Chips;
import com.pluralsight.orderItems.Drink;
import com.pluralsight.utils.Console;

public class UserInterface {

    private static SalesSystem salesSystem = new SalesSystem();

    public UserInterface(){}


    // HOME SCREEN
    public void homeScreenDisplay() throws InterruptedException {

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
    public void orderScreenDisplay () throws InterruptedException {

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
        String customerContactInfo = Console.PromptForString(">>> Enter customer contact info: ");

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
                        addSandwichScreenDisplay();
                    }
                    case 2 -> processAddDrinkRequest(order);
                    case 3 -> processAddChipsRequest(order);
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

        int customerDrink = Console.PromptForInt("Select drink: ");

        for (int i = 0; i < salesSystem.getMenu().getDrinkList().size(); i++){
            Drink drink = salesSystem.getMenu().getDrinkList().get(i);
            System.out.println((i + 1) + ") " + drink.getName());
        }
        Drink drink = salesSystem.getMenu().getDrinkList().get(customerDrink - 1);
        order.addItem(drink);
    }

    private void processAddChipsRequest(Order order) {

        int customerChips = Console.PromptForInt("Select Chips: ");

        for (int i = 0; i < salesSystem.getMenu().getChipsList().size(); i++){
            Chips chips = salesSystem.getMenu().getChipsList().get(i);
            System.out.println((i + 1) + ") " + chips.getName());
        }
        Drink chips = salesSystem.getMenu().getDrinkList().get(customerChips - 1);
        order.addItem(chips);
    }




    // todo COME BACK AND SORT OUT HOW TO TAKE CARE OF SANDWICHES AND TOPPINGS SCREENS
    // ADD SANDWICH DISPLAY
    private void addSandwichScreenDisplay() throws InterruptedException {
        String orderScreenOptions = """
                ╔════════════════════════════════════════════════╗
                ║               ADD SANDWICH SCREEN              ║
                ╠════════════════════════════════════════════════╣
                ║                                                ║
                ║           Please make selections for           ║
                ║             the following choices:             ║
                ║                                                ║
                ║        Select your bread:                      ║
                ║          - white                               ║
                ║          - wheat                               ║
                ║          - rye                                 ║
                ║          - wrap                                ║
                ║                                                ║
                ║        Sandwich size:                          ║
                ║          - 4"                                  ║
                ║          - 8"                                  ║
                ║          - 12"                                 ║
                ║                                                ║
                ║        Toppings:                               ║
                ║    (Premium)   |   (Premium)  |  (Regular)     ║
                ║    * Meats *   |  * Cheese *  |  * Veggies *   ║
                ║   - steak      |  - American  |  - lettuce     ║
                ║   - ham        |  - Provolone |  - peppers     ║
                ║   - salami     |  - Cheddar   |  - onions      ║
                ║   - roast beef |  - Swiss     |  - tomatoes    ║
                ║   - chicken    |              |  - jalapenos   ║
                ║   - bacon      |              |  - cucumbers   ║
                ║   - bacon      |              |  - pickles     ║
                ║   - bacon      |              |  - guacamole   ║
                ║                                  - mushrooms   ║
                ║                                                ║
                ║      Would you like the sandwich toasted?      ║
                ║                                                ║
                ║        0 - Cancel Order                        ║
                ║                                                ║
                ╚════════════════════════════════════════════════╝
                \n""";

        String breadOptions = """
                ╔════════════════════════════════════════════════╗
                ║           WHAT BREAD WOULD YOU LIKE?           ║
                ╠════════════════════════════════════════════════╣
                ║                                                ║
                ║   Please select from the following choices:    ║
                ║                                                ║
                ║        1 - White                               ║
                ║        2 - Wheat                               ║
                ║        3 - Rye                                 ║
                ║        4 - Wrap                                ║
                ║        0 - Cancel Order                        ║
                ║                                                ║
                ╚════════════════════════════════════════════════╝
                
                >>> Enter your choice here! :\s""";

        String toppingOptions = """
                ╔════════════════════════════════════════════════╗
                ║           WHAT BREAD WOULD YOU LIKE?           ║
                ╠════════════════════════════════════════════════╣
                ║                                                ║
                ║   Please select from the following choices:    ║
                ║                                                ║
                ║        1 - Meat (Premium):                     ║
                ║        2 - Cheese (Premium):                   ║
                ║        3 - Other Toppings (Regular)            ║
                ║        4 - Select Sauces                       ║
                ║        0 - Cancel Order                        ║
                ║                                                ║
                ╚════════════════════════════════════════════════╝
                
                >>> Enter your choice here:\s""";

        int selection;

        // ADD SANDWICH SCREEN OPTIONS LOOP
        do {


            selection = Console.PromptForInt(orderScreenOptions);
            switch (selection) {
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


    private void processAddSandwichRequest() {
        System.out.println("Add Sandwich");
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
