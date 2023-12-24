/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rofcapp;

import java.io.Serializable;

/**
 * Enumeration representing different bases for furniture items.
 * Each base has an associated price.
 * 
 * 
 * @author Francis Okoye (C2680301)
 */
public enum BASE implements Serializable {

    /**
     * CHROME base with a price of 50.
     */
    CHROME(50),

    /**
     * WOOD base with a price of 40.
     */
    WOOD(40);

    private final double price;

    /**
     * Constructor for the BASE enum.
     *
     * @param price The price associated with the base.
     */
    BASE(double price) {
        this.price = price;
    }

    /**
     * Get the price of the base.
     *
     * @return The price as a double.
     */
    public double getPrice() {
        return price;
    }
}
