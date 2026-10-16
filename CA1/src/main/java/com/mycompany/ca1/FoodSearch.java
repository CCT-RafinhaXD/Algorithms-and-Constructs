/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ca1;

/**
 *
 * @author natvi
 */
public class FoodSearch {
   
    // Search for a food name in storage
    public static int search(String[][] storage,
                             String foodName) {

        for (int i = 0; i < storage.length; i++) {

            if (storage[i][0] != null &&
                storage[i][0].equalsIgnoreCase(foodName)) {

                return i;
            }
        }

        return -1;
    }
}

    

