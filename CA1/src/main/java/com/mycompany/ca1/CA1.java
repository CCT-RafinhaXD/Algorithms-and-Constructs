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


        Scanner sc = new Scanner(System.in);

        // Array: [name, weight, best-before, storage time]
        String[][] storage = new String[5][4];

        System.out.print("How many items do you want to store? ");
        int n = sc.nextInt();
        sc.nextLine(); // clear buffer

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

            LocalDate date = LocalDate.parse(dateInput);

            // Check 2-week limit
            if (date.isAfter(LocalDate.now().plusWeeks(2))) {
                System.out.println("⚠ Invalid date! Setting to max 2 weeks.");
                date = LocalDate.now().plusWeeks(2);
            }

            storage[i][2] = date.toString();

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


