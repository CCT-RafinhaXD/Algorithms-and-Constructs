/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ca1;
import java.util.Scanner;
/**
 *
 * @author rafae
 */

    public class CircularQueue {
    private String[] queue;
    private int front, rear, size;

    public CircularQueue(int size) {
        this.size = size;
        this.queue = new String[size];
        this.front = -1;
        this.rear = -1;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (rear + 1) % size == front;
    }

    public void enqueue(String item) {
        if (isFull()) {
            System.out.println("Queue is full!");
        } else {
            if (front == -1) { // First element to be enqueued
                front = 0;
            }
            rear = (rear + 1) % size; // Wrap around to the front if needed
            queue[rear] = item;
            System.out.println(item + " added to the queue.");
        }
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
        } else {
            String item = queue[front];
            if (front == rear) { // Only one element left in the queue
                front = rear = -1; // Reset queue
            } else {
                front = (front + 1) % size; // Move front pointer forward
            }
            System.out.println(item + " removed from the queue.");
        }
    }

    public void peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
        } else {
            System.out.println("Front of the queue: " + queue[front]);
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
        } else {
            System.out.print("Queue contents: ");
            int i = front;
            while (i != rear) {
                System.out.print(queue[i] + " ");
                i = (i + 1) % size;
            }
            System.out.println(queue[rear]); // Print the rear element
        }
    }

    public void size() {
        if (isEmpty()) {
            System.out.println("Queue size: 0");
        } else {
            int currentSize = (rear - front + 1 + size) % size;
            System.out.println("Queue size: " + currentSize);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the queue: ");
        int size = scanner.nextInt();
        CircularQueue q = new CircularQueue(size);

        while (true) {
            System.out.println("\nQueue Operations:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Size");
            System.out.println("6. Exit");

            System.out.print("Choose an operation (1-6): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the item to enqueue: ");
                    String item = scanner.nextLine();
                    q.enqueue(item);
                    break;
                case 2:
                    q.dequeue();
                    break;
                case 3:
                    q.peek();
                    break;
                case 4:
                    q.display();
                    break;
                case 5:
                    q.size();
                    break;
                case 6:
                    System.out.println("Exiting the program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}


