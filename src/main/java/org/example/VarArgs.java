package org.example;

public class VarArgs {

    // Method with varargs parameter (can take 0+ Strings)
    public static void printItems(String... items) {
        System.out.println("\nNumber of items: " + items.length);
        for (String item : items) {
            System.out.println("- " + item);
        }
    }

    public static void main(String[] args) {
        // Different ways to call the varargs method
        printItems();                      // 0 arguments
        printItems("Apple");               // 1 argument
        printItems("Banana", "Cherry");    // 2 arguments
        printItems("Date", "Fig", "Grape"); // 3 arguments

        // You can also pass an array
        String[] fruits = {"Kiwi", "Lemon", "Mango", "Orange"};
        printItems(fruits);                // Array as argument
    }
}