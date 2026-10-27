/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ca1;
/**
 *
 * @author rafae
 */

    // Circular Queue (FIFO): the chef adds food items at the front side
    // and removes them from the opposite side
    public class CircularQueue {
    private FoodItem[] queue;
    private int front, rear, size;

    public CircularQueue(int size) {
        this.size = size;
        this.queue = new FoodItem[size];
        this.front = -1;
        this.rear = -1;
    }

    // Time complexity: O(1)
    public boolean isEmpty() {
        return front == -1;
    }

    // Time complexity: O(1)
    public boolean isFull() {
        return (rear + 1) % size == front;
    }

    // Time complexity: O(1)
    public void enqueue(FoodItem item) {
        if (isFull()) {
            System.out.println("⚠ Storage is full! The maximum is " + size + " trays.");
        } else {
            if (front == -1) { // First element to be enqueued
                front = 0;
            }
            rear = (rear + 1) % size; // Wrap around to the front if needed
            queue[rear] = item;
            System.out.println(item.getName() + " added to the storage.");
        }
    }

    // Time complexity: O(1)
    public void dequeue() {
        if (isEmpty()) {
            System.out.println("⚠ Storage is empty! There is nothing to remove.");
        } else {
            FoodItem item = queue[front];
            if (front == rear) { // Only one element left in the queue
                front = rear = -1; // Reset queue
            } else {
                front = (front + 1) % size; // Move front pointer forward
            }
            System.out.println(item.getName() + " removed from the storage.");
        }
    }

    // Time complexity: O(1)
    public void peek() {
        if (isEmpty()) {
            System.out.println("⚠ Storage is empty! There is no item at the top.");
        } else {
            System.out.println("Item at the top: " + queue[front].getName());
            queue[front].display();
        }
    }

    // Time complexity: O(n)
    public void display() {
        if (isEmpty()) {
            System.out.println("⚠ Storage is empty.");
        } else {
            System.out.println("Stored Food Items (next to be removed first):");
            int i = front;
            while (i != rear) {
                queue[i].display();
                i = (i + 1) % size;
            }
            queue[rear].display(); // Print the rear element
        }
    }

    // Time complexity: O(n)
    public FoodItem search(String foodName) {
        if (isEmpty()) {
            return null;
        }
        int i = front;
        while (i != rear) {
            if (queue[i].getName().equalsIgnoreCase(foodName)) {
                return queue[i];
            }
            i = (i + 1) % size;
        }
        if (queue[rear].getName().equalsIgnoreCase(foodName)) {
            return queue[rear];
        }
        return null;
    }

    // Time complexity: O(1)
    public void size() {
        if (isEmpty()) {
            System.out.println("Storage size: 0");
        } else {
            int currentSize = (rear - front + 1 + size) % size;
            if (currentSize == 0) { // full queue
                currentSize = size;
            }
            System.out.println("Storage size: " + currentSize);
        }
    }
}


