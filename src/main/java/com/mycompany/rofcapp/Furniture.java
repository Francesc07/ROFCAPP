/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rofcapp;

import java.io.Serializable;
import javax.swing.ImageIcon;


/**
 * This abstract class represents furniture items with properties such as ID, wood type, quantity, price, and image.
 * 
 * @author USER Francis Okoye (C2680301)
 */
public abstract class Furniture implements Serializable {
    private String ID;
    private WOOD_TYPE woodType;
    private int quantity;
    ImageIcon image;

    /**
     * Default constructor for Furniture.
     */
    public Furniture() {
        
    }

    /**
     * Parameterized constructor for Furniture.
     *
     * @param ID      The id of the furniture item.
     * @param woodType The type of wood used for the furniture (OAK or WALNUT).
     * @param quantity The quantity of furniture items.
     * @param image   The ImageIcon representing the furniture item.
     */
    public Furniture(String ID, WOOD_TYPE woodType, int quantity, ImageIcon image) {
        this.ID = ID;
        this.quantity = quantity;
        this.woodType = woodType;
        this.image = image;
    }

    /**
     * Get the ID of the furniture item.
     *
     * @return The ID as a string.
     */
    public String getID() {
        return ID;
    }

    /**
     * Get the quantity of the furniture items.
     *
     * @return The quantity as an integer.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Get the wood type of the furniture item.
     *
     * @return The wood type as a WoodType enum value (OAK or WALNUT).
     */
    public WOOD_TYPE getWoodType() {
        return woodType;
    }

    /**
     * Abstract method to be implemented by subclasses to calculate the total price.
     *
     * @return The calculated total price of the furniture items.
     */
    public abstract double calculatePrice();

    /**
     * Get the image representing the furniture item.
     *
     * @return The ImageIcon of the furniture item.
     */
    public abstract ImageIcon getImageIcon();
    
    public abstract ImageIcon setImageIcon(ImageIcon icon);

    /**
     * Returns a string representation of the furniture item.
     *
     * @return A string containing the ID, wood type, quantity, and price of the furniture item.
     */
    @Override
    public String toString() {
        return "Furniture ID=" + ID + ","
                + " WoodType=" + woodType + ","
                + " Quantity=" + quantity + ","
                + " Price=" + calculatePrice() + ", ";
    }
    
     
} 
