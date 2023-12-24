/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rofcapp;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 * A class representing an order that includes a list of furniture items (tables, chairs, desks)
 * and calculates the total price.
 * 
 * This class provides functionality to manage a list of furniture items in an order,
 * calculate the total price, and update order details for display purposes.
 * It also includes logging and user feedback for various actions.
 * 
 * @author Francis Okoye C2680301
 */
public class Order implements Serializable{
    private static final long serialVersionUID = 1L;
    private List<Furniture> furnitureList;
    private static final int MAX_ORDER = 9;
    private static final Logger LOGGER = Logger.getLogger(Order.class.getName());
    private JPanel orderPanel;
    private JLabel JLabel;
    /**
     * Constructs an Order object with an empty list of furniture items.
     */
    public Order() {
        furnitureList = new ArrayList<>();
    }
    
 
    /**
     * Adds a furniture item to the order if the maximum order limit is not reached.
     * Logs a warning and displays an error message if the order basket is full.
     * 
     * @param furniture The furniture item to be added to the order.
     */
    public void addFurniture(Furniture furniture) {
    if (getFurnitureList().size() < MAX_ORDER) {
        furnitureList.add(furniture);
        
    } else {
        LOGGER.log(Level.WARNING, "Order basket is full. Unable to add furniture: {0}", furniture);
        JOptionPane.showMessageDialog(null, "Order Basket Full error 1", "error", JOptionPane.ERROR_MESSAGE);
    }
        }
    
    /**
     * Retrieves the list of furniture items in the order.
     * 
     * @return The list of furniture items in the order.
     */
    public List<Furniture> getFurnitureList() {
        return furnitureList;
    }
    
    /**
     * Sets the list of furniture items in the order.
     * 
     * @param furnitureList The new list of furniture items.
     */
    public void setFurnitureList(List<Furniture> furnitureList) {
        this.furnitureList = furnitureList;
    }

    /**
     * Removes a furniture item from the order. 
     * Logs a warning and displays an error message if the furniture item is not found.
     * 
     * @param furniture The furniture item to be removed from the order.
     */
    public void removeFurniture(Furniture furniture) {
       if (furnitureList.contains(furniture)) {
        furnitureList.remove(furniture);
    } else {
        LOGGER.log(Level.WARNING, "Attempted to remove non-existing furniture: {0}", furniture);
         JOptionPane.showMessageDialog(null, "No order in Basket", "error", JOptionPane.ERROR_MESSAGE);
    }
    }
    /**
     * Clears all furniture items from the order.
     */
    public void clearOrder() {
        furnitureList.clear();
    } 
    /**
     * Calculates the total price of all furniture items in the order.
     * 
     * @return The total price of the order.
     */
    public double calculateTotalPrice() {
        double total = 0.0;
        for (Furniture furniture : furnitureList) {
            total += furniture.calculatePrice();
        }
        return total;
    }
    /**
     * Returns a string representation of the order, including details of each furniture item
     * and the total price.
     * 
     * @return A string representation of the order.
     */
    
      @Override
    public String toString() {
        StringBuilder orderDetails = new StringBuilder("Order Details:\n");
        for (Furniture furniture : furnitureList) {
            orderDetails.append(furniture.toString()).append("\n");
        }
        orderDetails.append("Total Price: £").append(calculateTotalPrice());
        return orderDetails.toString();
    }

        
     /**
     * Updates the display of order details on a JPanel and a total price label.
     * Clears and repopulates the orderPanel with furniture details.
     * 
     * @param orderPanel The JPanel where the order details will be displayed.
     * @param totalLabel The JLabel where the total price will be displayed.
     */
    public void updateOrderDetails(JPanel orderPanel, JLabel totalLabel) {
       
       
        orderPanel.removeAll();
        
        orderPanel.add(new JLabel("ProductID   "));
        orderPanel.add(new JLabel("ItemType   "));
        orderPanel.add(new JLabel("Quantity   "));
        orderPanel.add(new JLabel("Price   "));
        
        
        for (Furniture furniture : getFurnitureList()) {
            JLabel productIDLabel = new JLabel(furniture.getID());
            JLabel itemLabel = new JLabel(furniture.getClass().getSimpleName());
           
            JLabel quantityLabel = new JLabel(String.valueOf(furniture.getQuantity()));
            JLabel priceLabel = new JLabel(String.format("%.2f", furniture.calculatePrice()));

            orderPanel.add(productIDLabel);
             orderPanel.add(itemLabel);
            orderPanel.add(quantityLabel);
           orderPanel.add(priceLabel);
            
           
             
                
            }
             orderPanel.revalidate();
              orderPanel.repaint();
               
    
        }


    
    
    
    }

    
    

       

