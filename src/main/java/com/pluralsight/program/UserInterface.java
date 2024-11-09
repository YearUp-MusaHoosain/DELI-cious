package com.pluralsight.program;

import com.pluralsight.utils.Console;

public class UserInterface {

    public UserInterface(){}

    public void display() throws InterruptedException {

        String options = """
                ╔════════════════════════════════════════════════╗
                ║              WELCOME TO DELI-cious!            ║
                ╠════════════════════════════════════════════════╣
                ║                                                ║
                ║   Please select from the following choices:    ║
                ║                                                ║
                ║        1 - New Order                           ║
                ║        0 - Quit                                ║
                ║                                                ║
                ╚════════════════════════════════════════════════╝
                """;

        int selection;

        // User Interface Loop
        do {
            System.out.println("Welcome to " + currentDealership.getName() + "!");
            selection = Console.PromptForInt(options);
            switch (selection) {
                case 1 -> System.out.println("New Order");
                case 0 -> {
                    System.out.println("Exiting...");
                    Thread.sleep(500);
                    System.out.println("Thank you, have a nice day!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid selection. Please try again.");
            }
        } while (selection != 0);
    }
    


}
