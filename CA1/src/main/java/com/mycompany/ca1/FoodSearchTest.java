/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ca1;

/**
 *
 * @author natvi
 */

public class FoodSearchTest {

    public static void main(String[] args) {

        String[][] storage = {
            {"Pizza", "500"},
            {"Apple", "300"},
            {"Sandwich", "200"}
        };

        int result = FoodSearch.search(storage, "Burger");

        if (result != -1) {
            System.out.println("Food found at position: " + result);
        } else {
            System.out.println("Food not found");
        }
    }
}
