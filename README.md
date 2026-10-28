# Algorithms-and-Constructs

# Fast-Food Storage App

This is our CA1 project for Algorithms and Constructs at CCT College Dublin.

For this assignment, we are working on a Java program to help a fast-food restaurant organise its food storage using two data structures: Stack and Circular Queue.

The storage can hold up to 8 trays, with five types of food: Burger, Pizza, Fries, Sandwich and Hotdog.

Each food item has a name, weight, best-before date and the time it was added.

# How it works

We use two different ways to store and remove food:

**Stack (LIFO)** – The last food added is the first one removed. This is used when the chef adds and removes trays from the same side.

**Circular Queue (FIFO)** – The first food added is the first one removed. This is used when the chef adds trays from one side and removes them from the other.

The Circular Queue also reuses empty spaces in the array.

# Our Java Classes

We divided the code into four classes to keep everything organised:

- **CA1.java** – The main class for running the program.
- **FoodItem.java** – Stores the food details, such as name, weight and dates.
- **SingleStack.java** – Handles adding and removing food using LIFO.
- **CircularQueue.java** – Handles adding and removing food using FIFO.

We also used arrays, methods and Object-Oriented Programming to organise the code.

# Main Operations

The Stack uses push, pop and peek, while the Circular Queue uses enqueue, dequeue and peek.

We also worked on checking the storage limits and handling invalid inputs, such as incorrect dates or trying to add more than 8 trays.

# Tools We Used

- Java
- Apache NetBeans
- GitHub

# Group Members

Rafael, Natalia and Sara.
