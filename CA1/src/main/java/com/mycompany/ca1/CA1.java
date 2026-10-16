/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ca1;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author rafae
 */
public class CA1 {


    public static void main(String[] args) {

        //implemented scanner to read user input
        Scanner sc = new Scanner(System.in); 

        // Array: [maximum 8 trays][name, weight, best-before, storage time]
        String[][] storage = new String[8][4];

        //prompt for user to add items
        System.out.print("How many items do you want to store? ");
        int n = sc.nextInt();
        sc.nextLine(); // clear buffer

        //added a for loop to enter name, weight, bb, storage time of each item
        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter details for item " + (i + 1));

            System.out.print("Name: ");
            storage[i][0] = sc.nextLine();

            System.out.print("Weight (grams): ");
            storage[i][1] = sc.nextLine();

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
        //Converts the date into string so it can be stored in array
        storage[i][2] = expiryDate.toString();

        // Store current time automatically
        storage[i][3] = LocalDateTime.now().toString();
        }

        // Display stored items
        System.out.println("\nStored Food Items:");
        for (int i = 0; i < n; i++) {
            System.out.println("----------------------");
            System.out.println("Name: " + storage[i][0]);
            System.out.println("Weight: " + storage[i][1] + "g");
            System.out.println("Best Before: " + storage[i][2]);
            System.out.println("Stored At: " + storage[i][3]);
        }

        sc.close();

       

    }
}


