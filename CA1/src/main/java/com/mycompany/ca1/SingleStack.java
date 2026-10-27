/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ca1;
/**
 *
 * @author rafae
 */
class SingleStack {

    // Inner Stack class
    // Stack (LIFO): the chef uses only the front side to add and remove food items
    static class Stack {
        private FoodItem[] arr;
        private int top;
        private int capacity;

        public Stack(int size) {
            arr = new FoodItem[size];
            capacity = size;
            top = -1;
        }

        // Time complexity: O(1)
        public void push(FoodItem x) {
            if (top == capacity - 1) {
                System.out.println("⚠ Storage is full! The maximum is " + capacity + " trays.");
                return;
            }
            arr[++top] = x;
            System.out.println(x.getName() + " added to the storage.");
        }

        // Time complexity: O(1)
        public FoodItem pop() {
            if (top == -1) {
                System.out.println("⚠ Storage is empty! There is nothing to remove.");
                return null;
            }
            return arr[top--];
        }

        // Time complexity: O(1)
        public FoodItem peek() {
            if (top == -1) {
                System.out.println("⚠ Storage is empty! There is no item at the top.");
                return null;
            }
            return arr[top];
        }

        // Time complexity: O(1)
        public boolean isEmpty() {
            return top == -1;
        }

        // Time complexity: O(1)
        public boolean isFull() {
            return top == capacity - 1;
        }

        // Time complexity: O(n)
        public void display() {
            if (top == -1) {
                System.out.println("⚠ Storage is empty.");
                return;
            }
            System.out.println("Stored Food Items (top first):");
            for (int i = top; i >= 0; i--) {
                arr[i].display();
            }
        }

        // Time complexity: O(n)
        public FoodItem search(String foodName) {
            for (int i = 0; i <= top; i++) {
                if (arr[i].getName().equalsIgnoreCase(foodName)) {
                    return arr[i];
                }
            }
            return null;
        }
    }
}



