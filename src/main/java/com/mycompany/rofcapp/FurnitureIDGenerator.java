/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rofcapp;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author USER
 */
public class FurnitureIDGenerator {
     private static Set<String> usedChairIDs = new HashSet<>();
    private static Set<String> usedDeskIDs = new HashSet<>();
    // Add similar sets for other furniture types if needed.

    public static String generateChairID() {
        String prefix = "CH";
        return generateUniqueID(prefix, usedChairIDs);
    }

    public static String generateDeskID() {
        String prefix = "DK";
        return generateUniqueID(prefix, usedDeskIDs);
    }
    
     public static String generateTableID() {
        String prefix = "TB";
        return generateUniqueID(prefix, usedDeskIDs);
    }
    

    // Add similar methods for other furniture types if needed.

    private static String generateUniqueID(String prefix, Set<String> usedIDs) {
        String generatedID;
        do {
            // Generate a random two-digit number between 10 and 99.
            int randomDigits = (int) (Math.random() * 90 + 10);
            generatedID = prefix + randomDigits;
        } while (usedIDs.contains(generatedID)); // Check if the ID is already used.

        usedIDs.add(generatedID); // Mark the generated ID as used.
        return generatedID;
    }

    // You can reset the usedIDs sets if needed, e.g., for testing purposes.
    public static void resetUsedIDs() {
        usedChairIDs.clear();
        usedDeskIDs.clear();
        // Add similar lines for other furniture types if needed.
    }
    
}
