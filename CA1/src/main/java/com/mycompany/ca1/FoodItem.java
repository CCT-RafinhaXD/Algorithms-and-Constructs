/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ca1;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author sara_
 */
public class FoodItem {
    
    //Properties of the Food Item
    private String name;
    private double weight;
    private LocalDate bestBefore;
    private LocalDateTime storedAt;
    
    //Contructor of Food Item 
    public FoodItem(String name, double weight, LocalDate bestBefore) {
        this.name = name;
        this.weight = weight;
        this.bestBefore = bestBefore;
        this.storedAt = LocalDateTime.now();
    }

    //Getters of Food Item
    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public LocalDate getBestBefore() {
        return bestBefore;
    }

    public LocalDateTime getStoredAt() {
        return storedAt;
    }

    //prints the details of the food item
    public void display() {
        System.out.println("----------------------");
        System.out.println("Name: " + name);
        System.out.println("Weight: " + weight + "g");
        System.out.println("Best Before: " + bestBefore);
        System.out.println("Stored At: " + storedAt);
    }
}
