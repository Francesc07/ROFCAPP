/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rofcapp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.atomic.AtomicLong;
import javax.swing.JOptionPane;

/**
 * Utility class for saving and loading Order objects using data serialization.
 * Provides methods to save an order to a file and load an order from a file.
 * Also includes a method to generate unique order IDs for saved files.
 * 
 * This class uses Object Serialization to persist order data to files and retrieve it.
 * It includes error handling to manage file not found, IO, and class not found exceptions.
 * 
 * @author USER Francis Okoye (C2680301)
 */
public class OrderSerialization {
    
private static final AtomicLong idCounter = new AtomicLong(System.currentTimeMillis());
     
    /**
     * Saves an Order object to a file using data serialization.
     * Generates a unique order ID for the saved file.
     * Displays a success message upon successful saving and an error message on failure.
     * 
     * @param order The Order object to be saved.
     */
    public static void saveOrder(Order order) {
            
         String orderId = generateSavedOrderId();

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(orderId))) {
            oos.writeObject(order);
            JOptionPane.showMessageDialog(null, "Order saved succesfully \n Order ID: " + orderId);
            
            
        } catch (IOException e) {
             JOptionPane.showMessageDialog(null, "Failed to save order.");
            
        }
    
    }

     /**
     * Loads an Order object from a file using data deserialization.
     * Displays error messages for file not found, IO, and class not found exceptions.
     * 
     * @param orderId The unique ID of the order file to be loaded.
     * @return The loaded Order object, or null if loading fails.
     */
    public static Order loadOrder(String orderId) {
        

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(orderId))) {
            return (Order) ois.readObject();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Order file not found for ID: " + orderId);
            
        } catch (IOException | ClassNotFoundException e) {
             JOptionPane.showMessageDialog(null, "Failed to load order for ID: " + orderId);
           
        }

        return null;
    }
    /**
     * Generates a unique order ID using a combination of timestamp and a random number.
     * Converts the ID to base36 for a shorter representation.
     * 
     * @return A unique order ID as a String.
     */
    public static String generateSavedOrderId() {
        // Using timestamp and a random number for a shorter unique ID
        long timestamp = System.currentTimeMillis();
        long randomNum = (long) (Math.random() * 1000); // Adjust the range as needed
        long orderId = timestamp * 1000 + randomNum;

        return Long.toString(orderId, 36); // Convert to base36 for a shorter representation
    }
    
   
    
}
    
