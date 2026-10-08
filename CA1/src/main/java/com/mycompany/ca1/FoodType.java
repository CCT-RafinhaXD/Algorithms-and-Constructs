/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ca1;

/**
 *
 * @author rafae
 */
public enum FoodType {
    
    BURGER("Burger"),
    PIZZA("Pizza"),
    FRIES("Fries"),
    SANDWICH("Sandwich"),
    HOTDOG("Hotdog");
    
    private final String displayName;

     FoodType(String displayName) {
        this.displayName = displayName;
     }

    public String getDisplayName() {
        return displayName;
    }
    
    public static FoodType fromString(String input){
    
        if (input == null || input.trim().isEmpty()){
           throw new IllegalArgumentException("please choose a food type");
        }
        String cleaned = input.trim();
        
        FoodType[] list = values();
    }
    
}
        
    

