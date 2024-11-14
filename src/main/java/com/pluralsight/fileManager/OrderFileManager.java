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


    public void saveReceipt(Order orders)
    {
        File folder = new File("/receipts__");
        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HH-mm-ss"));
        String folderName = "src/main/java/com/pluralsight/receipts";
        String fileName = folderName + folder + dateTime + ".txt";



        try (FileWriter writer = new FileWriter(fileName))
        {
            writer.write("Order ID: " + orders.getOrderID() + "\n");
            writer.write("Customer: " + orders.getCustomer().getName() + " (" + orders.getCustomer().getPhoneNumber() + ")\n----------------------------------\n");
            for (FoodItemInterface item : orders.getFoodItemInterfaces())
            {
                if (item instanceof Sandwich) {
                    System.out.println(item);
                    Sandwich sandwich = (Sandwich) item;
                    String sandwichFormattedString = String.format("%s Sandwich on %s - %.2f\n", sandwich.getSandwichSize(), sandwich.getSandwichBread(), sandwich.calculatePrice());
                    writer.write(sandwichFormattedString);
//                    writer.write(sandwich.getSandwichSize() + " Sandwich on " + sandwich.getSandwichBread() + " - $" + sandwich.calculatePrice() + "\n");
                    for (Toppings topping : sandwich.getToppingsList())
                    {
                        writer.write("  + " + topping.getName() + (topping.isPremium() ? " (Premium)" : "") + "\n");
                    }
                } else {
                    System.out.println(item);
                    String itemFormattedString = String.format("%s - $%.2f\n", item.getName(), item.calculatePrice());
                    writer.write(itemFormattedString);
//                    writer.write(item.getName() + " - $" + item.calculatePrice() + "\n");
                }
            }
            writer.write("========================");
            String totalPriceFormattedString = String.format("\n\nTotal Price: $%.2f\n\n", orders.getTotalPrice());
            writer.write(totalPriceFormattedString);
            writer.write("========================");
//            writer.write("\nTotal Price: $" + orders.getTotalPrice());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
