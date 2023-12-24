/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rofcapp;

import java.io.Serializable;

/**
 * Enumeration representing different types of wood used in furniture.
 * Each wood type has an associated price per unit.
 * 
 * @author USER Francis Okoye (C2680301)
 */
public enum WOOD_TYPE implements Serializable {

    /**
     * OAK wood type with a price of 0.09 per unit.
     */
    OAK(0.09),

    /**
     * WALNUT wood type with a price of 0.05 per unit.
     */
    WALNUT(0.05);

    private final double price;

    /**
     * Constructor for the WOOD_TYPE enum.
     *
     * @param price The price associated with the wood type.
     */
    WOOD_TYPE(double price) {
        this.price = price;
    }

    /**
     * Get the price associated with the wood type.
     *
     * @return The price as a double.
     */
    public double getPrice() {
        return price;
    }
}