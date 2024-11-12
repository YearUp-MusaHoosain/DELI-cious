package com.pluralsight.fileManager;

import com.pluralsight.checkout.Order;
import com.pluralsight.interfaces.FoodItemInterface;
import com.pluralsight.orderItems.Sandwich;
import com.pluralsight.orderItems.Toppings;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class OrderFileManager {

    private Order orders;
    private List<FoodItemInterface> foodItemInterfaces;

    public void saveReceipt()
    {
        File folder = new File("receipts/");
        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
        String folderName = "receipts/";
        String fileName = folderName + dateTime + ".txt";



        try (FileWriter writer = new FileWriter(fileName))
        {
            writer.write("Order ID: " + orders.getOrderID() + "\n");
            writer.write("Customer: " + orders.getCustomer().getName() + " (" + orders.getCustomer().getContactInfo() + ")\n\n");
            for (FoodItemInterface item : foodItemInterfaces)
            {
                if (item instanceof Sandwich) {
                    Sandwich sandwich = (Sandwich) item;
                    writer.write(sandwich.getSandwichSize() + " Sandwich on " + sandwich.getSandwichBread() + " - $" + sandwich.calculatePrice() + "\n");
                    for (Toppings topping : sandwich.getToppingsList())
                    {
                        writer.write("  + " + topping.getName() + (topping.isPremium() ? " (Premium)" : "") + "\n");
                    }
                } else {
                    writer.write(item.getName() + " - $" + item.calculatePrice() + "\n");
                }
            }
            writer.write("\nTotal Price: $" + orders.getTotalPrice());
        } catch (IOException e)
        {
            System.out.println("Invalid entry");
            e.printStackTrace();
        }
    }
}
