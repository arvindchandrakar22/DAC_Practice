package com.codePractice.defaultt;

import java.util.HashSet;

public class Hash1 {
    public static void main(String[] args) {
        // Create a HashSet
        HashSet<String> names = new HashSet<>();
        
        // Add elements to the HashSet
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        
        System.out.println("Initial HashSet: " + names);
        
        // Replace an element in the HashSet
        String oldName = "Bob";
        String newName = "Bobby";
        
        // Remove the old element
        names.remove(oldName);
        
        // Add the new element
        names.add(newName);
        
        System.out.println("Updated HashSet: " + names);
    }
}
