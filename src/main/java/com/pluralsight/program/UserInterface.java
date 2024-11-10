package com.pluralsight.program;

import com.pluralsight.utils.Console;

public class UserInterface {

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

        int selection;

        // HOME SCREEN OPTIONS LOOP
        do {
            selection = Console.PromptForInt(options);
            switch (selection) {
                case 1 -> {
                    System.out.println("\nDisplaying Order Screen...\n");
                    Thread.sleep(500);
                    orderScreenDisplay();
                }
                case 0 -> {
                    System.out.println("Exiting...");
                    Thread.sleep(500);
                    System.out.println("Thank you, have a nice day!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        } while (selection != 0);
    }




    // ORDER SCREEN
    public void orderScreenDisplay () throws InterruptedException {
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

        int selection;

        // ORDER SCREEN OPTIONS LOOP
        do {
            selection = Console.PromptForInt(options);
            switch (selection) {
                case 1 -> {
                    System.out.println("\nDisplaying Add Sandwich Screen...\n");
                    Thread.sleep(500);
                    addSandwichScreenDisplay();
                }
                case 2 -> processAddDrinkRequest();
                case 3 -> processAddChipsRequest();
                case 4 -> {
                    System.out.println("\nDisplaying Checkout Screen...\n");
                    Thread.sleep(500);
                    checkoutScreenDisplay();
                }
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

    private void processAddDrinkRequest() {
        System.out.println("Add Drink");
    }

    private void processAddChipsRequest() {
        System.out.println("Add Chips");
    }




    // todo COME BACK AND SORT OUT HOW TO TAKE CARE OF SANDWHICHES AND TOPPINGS SCREENS
    // ADD SANDWICH DISPLAY
    private void addSandwichScreenDisplay() throws InterruptedException {
        String orderScreenOptions = """
                ╔════════════════════════════════════════════════╗
                ║               ADD SANDWICH SCREEN              ║
                ╠════════════════════════════════════════════════╣
                ║                                                ║
                ║   Please select from the following choices:    ║
                ║                                                ║
                ║        Select your bread:                      ║
                ║        Sandwich size:                          ║
                ║        Toppings:                               ║
                ║        Would you like the sandwich toasted?    ║
                ║        0 - Cancel Order                        ║
                ║                                                ║
                ╚════════════════════════════════════════════════╝
                
                >>> Enter your choice here! :\s""";

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
