/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ca1;
import java.util.Scanner;
import java.time.LocalDate;

/**
 *
 * @author rafae
 */
public class CA1 {


    public static void main(String[] args) {

        //implemented scanner to read user input
        Scanner sc = new Scanner(System.in);

        //the five types of food the restaurant provides
        String[] foodTypes = {"Burger", "Pizza", "Fries", "Sandwich", "Hotdog"};

        //maximum 8 trays in the storage
        SingleStack.Stack stack = new SingleStack.Stack(8);
        CircularQueue queue = new CircularQueue(8);

        //user chooses how the chef uses the storage
        int mode = 0;
        while (mode != 1 && mode != 2) {
            System.out.println("How will the chef use the storage?");
            System.out.println("1. Front side to add and remove (Stack)");
            System.out.println("2. Front side to add, opposite side to remove (Queue)");
            System.out.print("Enter your choice: ");

            //added try-catch in case user types letters
            try {
                mode = sc.nextInt();
                sc.nextLine(); // clear buffer
                if (mode != 1 && mode != 2) {
                    System.out.println("⚠ Invalid choice! Please enter 1 or 2.");
                }
            } catch (Exception e) {
                sc.nextLine(); // clear buffer
                System.out.println("⚠ Invalid input! Please enter a number.");
            }
        }

        //menu loop runs until the user chooses to exit
        while (true) {
            System.out.println("\n--- Food Storage Menu ---");
            System.out.println("1. Add food item");
            System.out.println("2. Remove food item");
            System.out.println("3. Show food item at the top");
            System.out.println("4. Display all food items");
            System.out.println("5. Search food item");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = 0;
            //added try-catch in case user types letters
            try {
                choice = sc.nextInt();
                sc.nextLine(); // clear buffer
            } catch (Exception e) {
                sc.nextLine(); // clear buffer
                System.out.println("⚠ Invalid input! Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    //check if the storage is full before asking for the details
                    if ((mode == 1 && stack.isFull()) || (mode == 2 && queue.isFull())) {
                        System.out.println("⚠ Storage is full! The maximum is 8 trays.");
                        break;
                    }

                    //name must be one of the five food types
                    String name = "";
                    boolean validName = false;
                    while (!validName) {
                        System.out.print("Name (Burger, Pizza, Fries, Sandwich, Hotdog): ");
                        String nameInput = sc.nextLine();
                        for (int i = 0; i < foodTypes.length; i++) {
                            if (foodTypes[i].equalsIgnoreCase(nameInput)) {
                                name = foodTypes[i];
                                validName = true;
                            }
                        }
                        if (!validName) {
                            System.out.println("⚠ Invalid food! Choose Burger, Pizza, Fries, Sandwich or Hotdog.");
                        }
                    }

                    //weight must be a number greater than 0
                    double weight = 0;
                    boolean validWeight = false;
                    while (!validWeight) {
                        System.out.print("Weight (grams): ");
                        try {
                            weight = sc.nextDouble();
                            sc.nextLine(); // clear buffer
                            if (weight > 0) {
                                validWeight = true;
                            } else {
                                System.out.println("⚠ Invalid weight! It must be greater than 0.");
                            }
                        } catch (Exception e) {
                            sc.nextLine(); // clear buffer
                            System.out.println("⚠ Invalid weight! Please enter a number.");
                        }
                    }

        //declare the variable for expiry date initializing it from today.
        LocalDate expiryDate = LocalDate.now();

        //set the valid date as false so user can set it inside of the loop
        boolean validDate = false;

        //implemented a while loop for expiry date for error handling purposes
        //with while loop user won't need to start adding the details of the item from the beginning
        while (!validDate) {
            System.out.print("Best-before (YYYY-MM-DD, max 2 weeks): ");
            String dateInput = sc.nextLine();

        //added try-catch to prompt user in case of errors
        try {

            //converts user input into a real local calendar date
            expiryDate = LocalDate.parse(dateInput);

            // Check 2-week limit
            if (expiryDate.isAfter(LocalDate.now().plusWeeks(2))) {
            System.out.println("⚠ Invalid date! The maximum limit is 2 weeks from today. Try again.");

            //check
            } else if (expiryDate.isBefore(LocalDate.now())) {
            System.out.println("⚠ Invalid date! The food cannot already be expired. Try again.");

            //get user out of the loop when the date meets the requirments
            } else {
            validDate = true;
            }

        //Check if user types numbers, special characters and invalid format
        } catch (Exception e) {
        System.out.println("⚠ Invalid format! Please use YYYY-MM-DD.");
        }
    }

                    //create the food item (storage time is stored automatically)
                    FoodItem item = new FoodItem(name, weight, expiryDate);
                    if (mode == 1) {
                        stack.push(item);
                    } else {
                        queue.enqueue(item);
                    }
                    break;

                case 2:
                    if (mode == 1) {
                        FoodItem removed = stack.pop();
                        if (removed != null) {
                            System.out.println(removed.getName() + " removed from the storage.");
                        }
                    } else {
                        queue.dequeue();
                    }
                    break;

                case 3:
                    if (mode == 1) {
                        FoodItem top = stack.peek();
                        if (top != null) {
                            System.out.println("Item at the top: " + top.getName());
                            top.display();
                        }
                    } else {
                        queue.peek();
                    }
                    break;

                case 4:
                    if (mode == 1) {
                        stack.display();
                    } else {
                        queue.display();
                    }
                    break;

                case 5:
                    if ((mode == 1 && stack.isEmpty()) || (mode == 2 && queue.isEmpty())) {
                        System.out.println("⚠ Storage is empty! There is nothing to search.");
                        break;
                    }
                    System.out.print("Enter food name to search: ");
                    String foodName = sc.nextLine();

                    FoodItem found;
                    if (mode == 1) {
                        found = stack.search(foodName);
                    } else {
                        found = queue.search(foodName);
                    }

                    if (found != null) {
                        System.out.println("Food found!");
                        found.display();
                    } else {
                        System.out.println("Food not found.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting the application.");
                    sc.close();
                    return;

                default:
                    System.out.println("⚠ Invalid choice! Please enter a number from 1 to 6.");
            }
        }
    }
}


